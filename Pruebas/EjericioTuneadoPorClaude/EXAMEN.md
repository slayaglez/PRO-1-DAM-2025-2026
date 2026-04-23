# Guía de conceptos para el examen

Proyecto: Employee-Skills con SQLite y JDBC puro (Java 17, sin JPA/Hibernate).

---

## 1. `execute()` vs `executeUpdate()` vs `executeQuery()`

| Método | Cuándo usarlo | Devuelve |
|---|---|---|
| `executeQuery()` | SELECT | `ResultSet` |
| `executeUpdate()` | INSERT / UPDATE / DELETE | número de filas afectadas |
| `execute()` | sentencias genéricas (DDL, etc.) | `true` si hay ResultSet |

```java
// MAL para DML — execute() devuelve false para cualquier INSERT/UPDATE/DELETE
return sentencia.execute();

// BIEN
return sentencia.executeUpdate() > 0;
```

---

## 2. Lógica de validaciones en el servicio

El error más común es mezclar `&&` y `||` en las guardas de entrada.

```java
// MAL — solo retorna false si AMBAS condiciones se cumplen (casi nunca ocurre)
if (!validarEmployee(employee) && repository.findById(employee.getId()) == null)
    return false;

// BIEN — retorna false en cuanto falla cualquier condición (fail-fast)
if (!validarEmployee(employee)) return false;
if (repository.findById(employee.getId()) != null) return false;
if (!existeEnTabla("rol", employee.getRolId())) return false;
```

---

## 3. IDs autogenerados por la BD (AUTOINCREMENT)

En este proyecto los IDs se pasan explícitamente. Si la tabla usa autoincrement, el patrón para recuperar el ID asignado por la BD es:

```java
PreparedStatement ps = connection.prepareStatement(
    "INSERT INTO tabla (name) VALUES (?)",
    Statement.RETURN_GENERATED_KEYS  // indica que queremos el ID generado
);
ps.setString(1, nombre);
ps.executeUpdate();

try (ResultSet keys = ps.getGeneratedKeys()) {
    if (keys.next()) {
        int idGenerado = keys.getInt(1);
        objeto.setId(idGenerado);
    }
}
```

En SQLite, cualquier columna `INTEGER PRIMARY KEY` actúa como autoincrement si no insertas el id en el INSERT.

---

## 4. Campos nullable en JDBC

Cuando una columna admite `NULL`, `getInt()` devuelve `0` en lugar de `null`. Usar `getObject()` con cast:

```java
// Lectura — getObject() devuelve null si la columna es NULL en BD
Integer reportsTo = (Integer) resultado.getObject("reports_to");

// Escritura — setNull() cuando el valor Java es null
if (employee.getReportsTo() == null) {
    sentencia.setNull(5, java.sql.Types.INTEGER);
} else {
    sentencia.setInt(5, employee.getReportsTo());
}
```

---

## 5. `try-with-resources` para conexiones JDBC

La conexión, el `PreparedStatement` y el `ResultSet` implementan `AutoCloseable`. El patrón correcto:

```java
try (Connection conn = SQLiteConnectionManager.openConnection();
     PreparedStatement ps = conn.prepareStatement("SELECT ...")) {
    ps.setInt(1, id);
    try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            // mapear filas
        }
    }
} catch (SQLException e) {
    // manejar error
}
// conn, ps y rs se cierran automáticamente al salir del bloque
```

---

## 6. JOIN en relaciones muchos a muchos

La relación `employee ↔ skill` pasa por la tabla intermedia `employee_skill`.

```java
// Skills de un empleado concreto
"SELECT s.id, s.name, s.category_id " +
"FROM skill s " +
"INNER JOIN employee_skill es ON s.id = es.skill_id " +
"WHERE es.employee_id = ?"
```

| Tipo de JOIN | Resultado |
|---|---|
| `INNER JOIN` | Solo filas con coincidencia en ambas tablas |
| `LEFT JOIN` | Todas las filas de la izquierda, coincidan o no |
| `RIGHT JOIN` | Todas las filas de la derecha (poco usado en SQLite) |

---

## 7. Subconsultas: `NOT IN` y `NOT EXISTS`

Para encontrar registros que no tienen relación con otra tabla:

```sql
-- NOT IN con subconsulta
SELECT id, name FROM skill
WHERE id NOT IN (SELECT DISTINCT skill_id FROM employee_skill)

-- NOT EXISTS (equivalente, más eficiente en tablas grandes)
SELECT id, name FROM skill s
WHERE NOT EXISTS (
    SELECT 1 FROM employee_skill es WHERE es.skill_id = s.id
)
```

En Java con `PreparedStatement`:

```java
PreparedStatement ps = connection.prepareStatement(
    "SELECT id, name, category_id FROM skill " +
    "WHERE id NOT IN (SELECT DISTINCT skill_id FROM employee_skill)");
try (ResultSet rs = ps.executeQuery()) {
    List<Skill> skills = new ArrayList<>();
    while (rs.next()) {
        skills.add(new Skill(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getInt("category_id")));
    }
    return skills;
}
```

---

## 8. COUNT y agregaciones

```java
// Contar empleados que tienen una skill concreta
PreparedStatement ps = connection.prepareStatement(
    "SELECT COUNT(*) FROM employee_skill WHERE skill_id = ?");
ps.setInt(1, skillId);
try (ResultSet rs = ps.executeQuery()) {
    return rs.next() ? rs.getInt(1) : 0;
}
```

Otras agregaciones útiles: `SUM`, `AVG`, `MAX`, `MIN`. El `ResultSet` de una agregación siempre tiene exactamente una fila.

---

## 9. Detección de duplicados case-insensitive

SQLite por defecto distingue mayúsculas en `UNIQUE`. Para impedir `"java"` cuando ya existe `"Java"`, la comprobación se hace en el servicio con `UPPER()`:

```java
// Al crear: no debe existir ninguna skill con el mismo nombre (sin importar case)
"SELECT COUNT(*) FROM skill WHERE UPPER(name) = UPPER(?)"

// Al actualizar: excluir el propio registro para no bloquearse a sí mismo
"SELECT COUNT(*) FROM skill WHERE UPPER(name) = UPPER(?) AND id != ?"
```

En Java, el equivalente en memoria es `equalsIgnoreCase()`:

```java
if (e.getSurname().equalsIgnoreCase(surname.trim())) { ... }
```

---

## 10. Trim de campos antes de persistir

Los tests suelen pasar strings con espacios para verificar que el servicio los normaliza antes de guardar:

```java
// En crear() y actualizar(), antes de llamar al repositorio:
employee.setName(employee.getName().trim());
employee.setSurname(employee.getSurname().trim());
employee.setStartDate(employee.getStartDate().trim());
```

La validación `isBlank()` ya cubre tabs y saltos de línea (`"\t"`, `"\n"`), así que no hace falta trim previo para validar; solo para guardar.

---

## 11. Prevención de auto-referencia

Un empleado no puede ser su propio manager. Se comprueba antes de persistir:

```java
if (employee.getReportsTo() != null) {
    if (employee.getReportsTo().equals(employee.getId())) return false;
    if (repository.findById(employee.getReportsTo()) == null) return false;
}
```

Usar `.equals()` y no `==` para comparar `Integer` (pueden ser objetos distintos con el mismo valor).

---

## 12. Las FK de la BD como red de seguridad

Si el repositorio ya atrapa la excepción y devuelve `false`, el servicio no necesita duplicar la comprobación para restricciones que la BD puede hacer sola (FK, UNIQUE exacto). Solo añadir lógica en el servicio cuando la BD no puede comprobarlo (como case-insensitive o auto-referencia).

```java
// El repositorio ya maneja esto — no hace falta comprobación extra en el servicio:
// - FK: category_id inexistente → SQLite lanza excepción → repositorio retorna false
// - UNIQUE exacto: nombre duplicado → SQLite lanza excepción → repositorio retorna false

// Sí hace falta en el servicio:
// - UNIQUE case-insensitive (SQLite no lo hace por defecto)
// - Auto-referencia (la BD permite reports_to = id propio)
```

---

## 13. Patrón para detectar managers (recolectar IDs únicos)

Un manager es cualquier empleado cuyo `id` aparece en el campo `reports_to` de otro empleado.

```java
List<Employee> todos = repository.findAll();
Set<Integer> idsDeManagers = new HashSet<>();
for (Employee e : todos) {
    if (e.getReportsTo() != null) idsDeManagers.add(e.getReportsTo());
}
List<Employee> managers = new ArrayList<>();
for (Employee e : todos) {
    if (idsDeManagers.contains(e.getId())) managers.add(e);
}
```

Equivalente en SQL:

```sql
SELECT DISTINCT e.* FROM employee e
INNER JOIN employee sub ON sub.reports_to = e.id
```

---

## 14. Insertar en tabla intermedia (muchos a muchos)

```java
// La PK compuesta (employee_id, skill_id) impide duplicados.
// Las FK impiden employee_id o skill_id inexistentes.
// Ambas restricciones las gestiona la BD; el catch captura la violación.
PreparedStatement ps = connection.prepareStatement(
    "INSERT INTO employee_skill (employee_id, skill_id, level_id) VALUES (?, ?, ?)");
ps.setInt(1, employeeId);
ps.setInt(2, skillId);
ps.setString(3, levelId);
return ps.executeUpdate() > 0;
```

Si se intenta insertar un duplicado o un ID inexistente, SQLite lanza una `SQLException` que el `catch` convierte en `return false`.

---

## 15. Activar foreign keys en SQLite

SQLite **no activa las foreign keys por defecto**. Hay que ejecutar este PRAGMA en cada conexión:

```java
try (Statement statement = connection.createStatement()) {
    statement.execute("PRAGMA foreign_keys = ON");
}
```

Sin esto, las restricciones FK no se comprueban y se pueden insertar referencias inválidas sin error.
