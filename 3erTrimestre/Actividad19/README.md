# Proyecto Basico Para Alumnado De 1o De Ciclo

Esta carpeta es una version mas basica del proyecto, pensada como plantilla de trabajo.

La solucion completa existe en otra entrega. Esta version se puede usar como base para clase, practicas o examen.

Este proyecto esta pensado como guia de trabajo para alumnado de 1o de ciclo.

La idea no es solo ejecutar una aplicacion ya terminada, sino entender:

- como se organiza un proyecto en capas
- como se representa la informacion con clases de modelo
- como se hace un CRUD
- como se leen y escriben datos en `CSV`, `JSON`, `XML` y `SQLite`
- como se prueban las clases con tests

El proyecto esta hecho con Java 17 y Maven.

## Que tiene esta version basica

- estructura completa del proyecto
- modelos terminados
- interfaces de repositorio
- recursos de ejemplo en `CSV`, `JSON`, `XML` y `SQLite`
- menu de prueba
- tests basicos por capa

## Que debe desarrollar el alumnado

Se recomienda usar esta carpeta para que el alumnado:

- complete o reescriba repositorios concretos
- practique el CRUD de cada entidad
- compare distintas persistencias
- añada validaciones en `service`
- escriba nuevos tests
- mejore el `Main` o cree nuevas opciones de menu

## Objetivo didactico

El alumnado debe ser capaz de:

- identificar las capas `model`, `repository`, `service` y `app`
- seguir el flujo completo desde el menu hasta el repositorio
- crear objetos del modelo
- implementar operaciones `create`, `findAll`, `findById`, `update` y `deleteById`
- leer datos desde ficheros
- guardar datos en ficheros
- abrir una base de datos SQLite y hacer consultas sencillas
- comprobar el resultado con tests

## Estructura del proyecto

```text
src/main/java/com/ejemplo/
├── app
├── model
├── repository
│   ├── csv
│   ├── json
│   ├── sqlite
│   └── xml
└── service
```

```text
src/main/resources/data/
├── csv
├── json
├── sqlite
└── xml
```

## Capas del proyecto

### `model`

Aqui estan las clases que representan los datos.

Modelos incluidos:

- `Cliente`
- `Producto`
- `Proveedor`
- `Inventario`
- `Pedido`
- `LineaPedido`

Cada modelo tiene:

- atributos
- constructor vacio
- constructor con parametros
- getters y setters
- `toString()`
- `equals()`
- `hashCode()`

### `repository`

Aqui esta el acceso a datos.

Hay repositorios para:

- `CSV`
- `JSON`
- `XML`
- `SQLite`

Cada entidad tiene su propia interfaz de repositorio, por ejemplo:

- `IClienteRepository`
- `IProductoRepository`
- `IProveedorRepository`

Esto se ha hecho asi para que el alumnado vea mejor la idea de repositorio, sin genéricos complejos.

### `service`

Aqui van las reglas de negocio.

Por ejemplo:

- validar datos
- buscar activos
- calcular medias
- calcular totales
- filtrar por estado o pais

La capa `service` no necesita saber si los datos vienen de `CSV`, `JSON`, `XML` o `SQLite`.

### `app`

Aqui esta el punto de entrada del programa.

- [src/main/java/com/ejemplo/app/Main.java](/Users/jpexposito/Documents/New%20project/src/main/java/com/ejemplo/app/Main.java:1)

## Menu de consola

El proyecto tiene un `Main` con menu para probar la aplicacion.

Opciones actuales:

- ver clientes desde CSV
- ver productos desde JSON
- ver pedidos desde XML
- probar SQLite
- crear un cliente nuevo en CSV

Se puede ejecutar con:

```bash
mvn exec:java
```

## Reglas sencillas que se han seguido

- sin `Optional`
- sin `enum`
- sin herencia abstracta complicada
- sin repositorios genericos complejos para el alumnado
- CRUD con `boolean`
- busquedas por id devolviendo objeto o `null`
- listas con `List<T>`
- codigo directo, aunque haya repeticion

## CRUD basico que debe entender el alumnado

Todos los repositorios siguen esta idea:

```java
boolean create(T dato);
List<T> findAll();
T findById(Long id);
boolean update(T dato);
boolean deleteById(Long id);
```

Significado:

- `create`: inserta un elemento nuevo
- `findAll`: devuelve todos los elementos
- `findById`: busca uno por id
- `update`: modifica un elemento existente
- `deleteById`: elimina uno por id

## Como se trabajan los ficheros

Los repositorios de fichero reciben la ruta como `String`.

Ejemplo:

```java
ClienteJsonRepository repository =
    new ClienteJsonRepository("src/main/resources/data/json/clientes.json");
```

Cuando se construye el repositorio:

- la ruta se convierte a `Path`
- si la carpeta no existe, se crea
- si la ruta es un directorio, se lanza un error
- si el fichero no existe, se crea automaticamente

Esto permite trabajar sin tener que crear manualmente todos los archivos al principio.

## Como se leen los CSV

La lectura CSV se apoya en:

- [src/main/java/com/ejemplo/repository/csv/CsvReader.java](/Users/jpexposito/Documents/New%20project/src/main/java/com/ejemplo/repository/csv/CsvReader.java:1)

Proceso:

1. se lee el fichero linea a linea
2. se separa cada linea con el separador indicado
3. el repositorio convierte cada fila en un objeto del modelo

Ejemplo:

- [src/main/java/com/ejemplo/repository/csv/ClienteCsvRepository.java](/Users/jpexposito/Documents/New%20project/src/main/java/com/ejemplo/repository/csv/ClienteCsvRepository.java:1)

Separadores usados en el proyecto:

- `clientes.csv` -> `;`
- `productos.csv` -> `;`
- `proveedores.csv` -> `|`
- `inventarios.csv` -> tabulador
- `pedidos.csv` -> `,`
- `lineas_pedido.csv` -> `#`

## Como se leen los JSON

Los repositorios JSON usan Jackson.

Dependencia Maven:

- `jackson-databind`

Clase principal:

- `ObjectMapper`

Ejemplo:

- [src/main/java/com/ejemplo/repository/json/ProductoJsonRepository.java](/Users/jpexposito/Documents/New%20project/src/main/java/com/ejemplo/repository/json/ProductoJsonRepository.java:1)

Proceso:

1. se crea un `ObjectMapper`
2. se define el tipo `List<T>`
3. Jackson convierte el fichero JSON en objetos Java

## Como se leen los XML

Los repositorios XML usan Jackson XML.

Dependencia Maven:

- `jackson-dataformat-xml`

Clase principal:

- `XmlMapper`

Ejemplo:

- [src/main/java/com/ejemplo/repository/xml/PedidoXmlRepository.java](/Users/jpexposito/Documents/New%20project/src/main/java/com/ejemplo/repository/xml/PedidoXmlRepository.java:1)

Los XML se convierten en clases contenedoras como:

- [src/main/java/com/ejemplo/model/xml/Clientes.java](/Users/jpexposito/Documents/New%20project/src/main/java/com/ejemplo/model/xml/Clientes.java:1)
- [src/main/java/com/ejemplo/model/xml/Productos.java](/Users/jpexposito/Documents/New%20project/src/main/java/com/ejemplo/model/xml/Productos.java:1)
- [src/main/java/com/ejemplo/model/xml/Pedidos.java](/Users/jpexposito/Documents/New%20project/src/main/java/com/ejemplo/model/xml/Pedidos.java:1)

En estas clases, la lista interna se llama `items`, para que el patron sea el mismo en todos los casos.

Proceso:

1. se crea un `XmlMapper`
2. se lee el XML completo en una clase contenedora como `Clientes` o `Pedidos`
3. esa clase devuelve la lista `items`
4. cuando se guarda, Jackson vuelve a convertir los objetos Java en XML

## SQLite incluida en el proyecto

La base de datos incluida esta en:

- [src/main/resources/data/sqlite/demo.db](/Users/jpexposito/Documents/New%20project/src/main/resources/data/sqlite/demo.db)

Se usa en la demo del `Main` y tambien sirve para practicar consultas.

### Abrir la base de datos

```bash
sqlite3 src/main/resources/data/sqlite/demo.db
```

### Ver las tablas

```sql
.tables
```

### Ver la estructura de una tabla

```sql
.schema cliente
```

### Leer datos

```sql
SELECT * FROM cliente;
SELECT * FROM producto;
```

### Mostrar cabeceras y columnas mejor formateadas

```sql
.headers on
.mode column
SELECT * FROM cliente;
```

### Salir

```sql
.quit
```

## CRUD basico en SQLite

### Read

```sql
SELECT * FROM cliente;
SELECT * FROM cliente WHERE id = 100;
```

### Insert

```sql
INSERT INTO cliente (id, nif, nombre, email, telefono, ciudad, pais, activo)
VALUES (200, '22222222B', 'Cliente SQL', 'sql@demo.com', '600222222', 'Sevilla', 'Espana', 1);
```

### Update

```sql
UPDATE cliente
SET nombre = 'Cliente SQL Modificado', ciudad = 'Malaga'
WHERE id = 200;
```

### Delete

```sql
DELETE FROM cliente
WHERE id = 200;
```

## Como verificar el proyecto

### Ejecutar tests

```bash
mvn test
```

Con esto se comprueba:

- que el modelo funciona
- que los repositorios funcionan
- que los servicios funcionan
- que se crean archivos si no existen
- que se restauran copias de seguridad antes de cada test

### Ver cobertura

Tras `mvn test`, el informe JaCoCo queda en:

- [target/site/jacoco/index.html](/Users/jpexposito/Documents/New%20project/target/site/jacoco/index.html:1)

La solucion completa supera el `95%` de cobertura de lineas.

## Tests incluidos en esta version

En esta version basica se han dejado los tests mas importantes y se han quitado algunos tests avanzados de cobertura para que el punto de partida sea mas manejable.

Tests que se mantienen:

- `ModelLayerTest`
- `CsvReaderTest`
- `CsvRepositoriesTest`
- `JsonRepositoriesTest`
- `XmlRepositoriesTest`
- `SqliteRepositoriesTest`
- `ServiceLayerTest`
- `XmlCollectionsTest`

## Tests y copias de seguridad

Los tests que usan ficheros o SQLite restauran una copia base antes de cada prueba.

Utilidad usada:

- [src/test/java/com/ejemplo/support/TestBackupManager.java](/Users/jpexposito/Documents/New%20project/src/test/java/com/ejemplo/support/TestBackupManager.java:1)

Esto permite que:

- cada test empiece limpio
- un test no rompa el siguiente
- se puedan probar errores, altas y borrados con seguridad

## Version basica para el alumnado

Si quieres usar este proyecto como punto de partida para que el alumnado complete el trabajo, la version basica recomendada seria esta:

### Dejar ya hecho

- la estructura de carpetas
- el `pom.xml`
- los modelos
- las interfaces de repositorio
- el `Main`
- los ficheros de ejemplo en `resources/data`
- una parte de los tests

### Dejar pendiente para el alumnado

- implementar `findAll()` en un repositorio CSV
- implementar `findById()` en un repositorio CSV
- implementar `create()` en un repositorio CSV
- implementar `update()` en un repositorio CSV
- implementar `deleteById()` en un repositorio CSV
- repetir el proceso en JSON
- repetir el proceso en XML
- implementar un repositorio SQLite
- completar metodos de `service`
- completar tests que falten

### Orden de trabajo recomendado

1. empezar por `Cliente`
2. hacer primero el repositorio CSV
3. despues el `ClienteService`
4. añadir tests de `Cliente`
5. repetir con `Producto`
6. repetir con el resto de modelos
7. dejar SQLite para el final

## Flujo recomendado para clase

1. ejecutar `mvn test`
2. ejecutar `mvn exec:java`
3. abrir un repositorio concreto
4. seguir el flujo desde `findAll()` o `create()`
5. comparar como se hace en CSV, JSON, XML y SQLite
6. modificar un caso sencillo
7. volver a lanzar tests

## Comandos utiles

### Compilar

```bash
mvn compile
```

### Ejecutar tests

```bash
mvn test
```

### Ejecutar la aplicacion

```bash
mvn exec:java
```

## Idea para el alumnado

No hace falta memorizar todo el proyecto a la vez.

Lo importante es entender siempre estas preguntas:

- que dato entra
- en que clase se transforma
- donde se guarda
- como se recupera
- que hace el servicio con ese dato
- como se comprueba con un test

Si el alumnado domina ese recorrido, ya esta entendiendo la base del proyecto.
