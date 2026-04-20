# Proyecto de persistencia con SQLite: propietarios e inmuebles

## Enunciado

Desarrolla una aplicacion siguiendo una arquitectura por capas.

La aplicacion debe gestionar **propietarios** e **inmuebles** usando una base de datos **SQLite**.

### Reglas del dominio

- La clave principal del propietario es su `dni`.
- Un propietario puede tener **uno o varios inmuebles**.
- Cada inmueble pertenece a un unico propietario.
- Las validaciones principales deben hacerse en la capa `service`.
- El acceso a datos debe hacerse desde la capa `repository`.

---

## Objetivos

Debes de ser capaz de:

- organizar un proyecto en paquetes `app`, `model`, `repository` y `service`
- crear clases de modelo con atributos, constructores, getters, setters, `equals`, `hashCode` y `toString`
- implementar CRUD sobre SQLite con `PreparedStatement`
- validar datos sencillos antes de persistirlos
- separar reglas de negocio y acceso a datos
- probar el comportamiento de la capa `service` con tests automatizados
- restaurar una base de datos de copia de seguridad antes de cada test

---

## Modelo de datos

### Tabla `propietario`

- `dni` TEXT PRIMARY KEY
- `nombre` TEXT NOT NULL
- `email` TEXT
- `telefono` TEXT
- `ciudad` TEXT
- `activo` INTEGER NOT NULL

### Tabla `inmueble`

- `id` INTEGER PRIMARY KEY AUTOINCREMENT
- `referencia` TEXT NOT NULL UNIQUE
- `tipo` TEXT NOT NULL
- `direccion` TEXT NOT NULL
- `ciudad` TEXT
- `anio_construccion` INTEGER
- `metros_cuadrados` INTEGER NOT NULL
- `precio` REAL NOT NULL
- `vendido` INTEGER NOT NULL
- `dni_propietario` TEXT NOT NULL

---

## Tareas minimas a implementar

### Propietario

- crear propietario
- buscar propietario por DNI
- listar todos los propietarios
- actualizar propietario
- eliminar propietario por DNI
- listar propietarios activos
- buscar propietarios por ciudad

### Inmueble

- crear inmueble
- buscar inmueble por id
- listar todos los inmuebles
- actualizar inmueble
- eliminar inmueble por id
- listar inmuebles de un propietario
- listar inmuebles vendidos
- listar inmuebles disponibles
- cambiar el propietario de un inmueble
- marcar un inmueble como vendido
- actualizar metros cuadrados

---

## Reglas de validacion sugeridas

### PropietarioService

- el DNI no puede ser nulo ni vacio
- el nombre no puede ser nulo ni vacio
- no se puede crear un propietario con un DNI repetido
- no se puede actualizar un propietario que no existe

### InmuebleService

- la referencia no puede ser nula ni vacia
- tipo y direccion son obligatorios
- `metrosCuadrados` no puede ser negativo
- `precio` debe ser mayor que 0
- no se puede crear un inmueble si el propietario no existe
- no se puede cambiar el propietario a un DNI inexistente
- no se puede vender dos veces el mismo inmueble

---

## Estructura del proyecto

```text
src/main/java/com/ejemplo/
├── app
├── model
├── repository
│   └── sqlite
└── service
```

```text
src/test/java/com/ejemplo/
├── service
└── support
```

---

## Paquetes incluidos en esta propuesta

### `model`

- `Propietario`
- `Inmueble`

### `repository`

- `IPropietarioRepository`
- `IInmuebleRepository`

### `repository/sqlite`

- `SQLiteConnectionManager`
- `SchemaRepository`
- `PropietarioSqliteRepository`
- `InmuebleSqliteRepository`

### `service`

- `PropietarioService`
- `InmuebleService`

### `support` en test

- `TestBackupManager`
- `TestDataFactory`

---

## Base de datos de test

Los tests deben usar una base de datos de trabajo que se restaura desde una **copia de seguridad** antes de cada test.

La idea es:

1. partir siempre del mismo estado inicial
2. evitar que un test afecte a otro
3. poder repetir la bateria completa de tests con resultados estables

### Base de datos.

La base de datos se encuentra en la siguientes rutas:

- `src/main/resources/data/sqlite/inmuebles.db`;
- `src/main/resources/data/sqlite/inmuebles_backup.db`;

---

## Pruebas automatizadas

La suite de tests verifica:

- creacion correcta de propietarios e inmuebles
- rechazo de datos invalidos
- actualizacion y borrado
- filtros por activo, ciudad, vendido y propietario
- cambios de propietario
- marcado de vendido
- calculos sencillos en servicios
- aislamiento entre tests restaurando la BBDD en cada ejecucion

En esta propuesta se incluyen **mas de 40 tests** centrados en el comportamiento de los servicios.

---

## Calificacion automatica

La nota se calcula de forma automatica a partir de:

- los reportes XML generados por `mvn test` en `target/surefire-reports`
- la documentacion de las interfaces de servicio

### Reparto de pesos

- **Propietario = 4 puntos**
  - 3 puntos por tests del bloque `propietario`
  - 1 punto por documentacion de las operaciones de propietario en `IPropietarioService`
- **Inmueble = 6 puntos**
  - 5 puntos por tests del bloque `inmueble`
  - 1 punto por documentacion de las operaciones de inmueble en `IInmuebleService`

### Como se evalua la documentacion

El script `tools/calcular_nota.py` revisa automaticamente que en las interfaces de servicio aparezcan los metodos esperados documentados con Javadoc.

### Uso

1. Ejecutar los tests:

```bash
mvn test
```

2. Calcular la nota:

```bash
mvn clean verify -Pcalificar
```

3. Revisar el resultado en:

```text
target/nota.txt
```

---

## Ejecucion

### Ejecutar tests

```bash
mvn test
```

### Ejecutar aplicacion de ejemplo

```bash
EJECUTA EL MAIN PARA VERIFICAR EL FINDALL DE LOS SERVICIOS
```
