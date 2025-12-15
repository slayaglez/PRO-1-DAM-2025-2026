# Proyecto de ejercicios – Listas, Composición y Herencia (Java + Maven)

Este proyecto contiene ejercicios para trabajar en clase con el alumnado, organizados por **bloques** y por **ejercicio**:

- `listas` → `com.docencia.listas.ejercicio1..4`
- `composicion` → `com.docencia.composicion.ejercicio1..4`
- `herencia` → `com.docencia.herencia.ejercicio1..4`

En `src/main/java` hay **esqueletos** (con `TODO`) para completar.
En `src/test/java` hay **tests JUnit 5** que definen el comportamiento esperado.

## Ejecutar los tests

```bash
mvn clean test
```

## Estructura de paquetes

### Listas

- `com.docencia.listas.ejercicio1.Ejercicio1` → `contarMayoresQue(List<Integer>, int)`
- `com.docencia.listas.ejercicio2.Ejercicio2` → `invertirYFiltrarNoVacias(List<String>)`
- `com.docencia.listas.ejercicio3.Ejercicio3` → `interseccionOrdenada(List<Integer>, List<Integer>)`
- `com.docencia.listas.ejercicio4.Ejercicio4` → `mediaValoresValidos(List<Integer>)`

### Composición

Cada ejercicio tiene su paquete independiente con **sus clases propias** (sin compartir modelos entre ejercicios):

- `com.docencia.composicion.ejercicio1` → `Tarea`, `ListaTareas`, `Ejercicio1`
- `com.docencia.composicion.ejercicio2` → `Alumno`, `RegistroNota`, `Aula`, `Ejercicio2`
- `com.docencia.composicion.ejercicio3` → `Paciente`, `Consulta`, `CentroSalud`, `Ejercicio3`
- `com.docencia.composicion.ejercicio4` → `Usuario`, `Mensaje`, `BandejaMensajes`, `Ejercicio4`

### Herencia

- `com.docencia.herencia.ejercicio1` → `Figura`, `Circulo`, `Rectangulo`, `Ejercicio1`
- `com.docencia.herencia.ejercicio2` → `Empleado`, `EmpleadoFijo`, `EmpleadoPorHoras`, `Ejercicio2`
- `com.docencia.herencia.ejercicio3` → `Animal`, `Perro`, `Gato`, `Ejercicio3`
- `com.docencia.herencia.ejercicio4` → `Publicacion`, `LibroPublicacion`, `ArticuloPublicacion`, `Ejercicio4`

## Notas para clase

- Cada paquete `...ejercicioN` es autocontenido: ahí están **las clases** y, si se desea, una clase `EjercicioN` con `main`.
- Los tests están en el **mismo esquema** de paquetes dentro de `src/test/java`.
