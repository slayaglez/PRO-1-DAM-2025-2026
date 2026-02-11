
# Practica - fechas y expresiones regulares

El proyecto esta dividido en **dos grandes bloques**:

- `com.docencia.fechas` → logica usando API `java.time`
- `com.docencia.expresiones` → combinacion de **regex + fechas**

Cada ejercicio esta en su propio paquete:

```
com.docencia.fechas.ejercicioN
com.docencia.expresiones.ejercicioN
```

y contiene:

- `EjercicioN.java` → implementacion
- `EjercicioNTest.java` → 5 pruebas unitarias

La evaluacion suele hacerse por clases (no por numero total de tests).

---

---
# EJERCICIOS DE FECHAS (15)
---

## Ejercicio 1 - etiquetarDia
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Dada una `LocalDate` debes devolver:

- `"LABORABLE"` si es lunes-viernes
- `"FIN_DE_SEMANA"` si es sabado o domingo

### Ayuda
`getDayOfWeek()`, enums de `DayOfWeek`.

---

## Ejercicio 2 - redondearAbajoPorPaso
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Redondear una hora hacia abajo al multiplo de minutos indicado.

Ej: 10:29 con paso 15 → 10:15.

### Ayuda
`getMinute()`, `withMinute()`, `withSecond(0)`, `withNano(0)`.

---

## Ejercicio 3 - crearCitaValidada
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Construir un `LocalDateTime` a partir de fecha y hora.
Si el resultado esta en el pasado respecto a `now`, lanzar excepcion.

### Ayuda
`LocalDateTime.of()`, `isBefore()`.

---

## Ejercicio 4 - finDeMes
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Obtener el ultimo dia del mes de una fecha.

### Ayuda
`TemporalAdjusters.lastDayOfMonth()`.

---

## Ejercicio 5 - calcularEdadEnAnios
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Calcular años completos entre nacimiento y hoy.
Si hoy es anterior al nacimiento → error.

### Ayuda
`Period.between()`.

---

## Ejercicio 6 - sumarDiasHabiles
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Dependencias
conceptos basicos de ejercicios anteriores
Sumar N dias ignorando sabados y domingos.

### Ayuda
Iterar con `plusDays(1)` y comprobar `DayOfWeek`.

---

## Ejercicio 7 - estaAbiertoInclusivo
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Dependencias
conceptos basicos de ejercicios anteriores
Comprobar si una hora esta dentro de una ventana `[open, close]`.
Debe soportar ventanas que cruzan medianoche.

### Ayuda
`isBefore`, `isAfter`.

---

## Ejercicio 8 - fechaProcesamientoPorCorte
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Dependencias
conceptos basicos de ejercicios anteriores
Si la hora de recepcion es mayor que el corte → dia siguiente.
Si no → mismo dia.

### Ayuda
`toLocalTime()`.

---

## Ejercicio 9 - puedeCancelarEn48h
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Dependencias
conceptos basicos de ejercicios anteriores
Desde el instante de compra, comprobar si aun no han pasado 48h.

### Ayuda
`Instant`, `Duration.ofHours()`.

---

## Ejercicio 10 - minutosEntreConCruce
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Dependencias
conceptos basicos de ejercicios anteriores
Minutos entre dos horas, permitiendo cruce de dia.

23:30 → 00:15 = 45.

---

## Ejercicio 11 - convertirZonaMismoInstante
### Nivel
⭐⭐⭐

### Tiempo estimado
20-40 minutos

### Dependencias
manejo previo de zonas, periodos y validaciones
Cambiar de zona horaria manteniendo el instante real.

### Ayuda
`atZone()`, `withZoneSameInstant()`.

---

## Ejercicio 12 - compararEventos
### Nivel
⭐⭐⭐

### Tiempo estimado
20-40 minutos

### Dependencias
manejo previo de zonas, periodos y validaciones
Determinar cual ocurre primero y devolver la diferencia absoluta.

### Ayuda
`toInstant()`, `Duration.between().abs()`.

---

## Ejercicio 13 - convertirDisponibilidadDiaria
### Nivel
⭐⭐⭐

### Tiempo estimado
20-40 minutos

### Dependencias
manejo previo de zonas, periodos y validaciones
Tienes una franja en una zona origen y debes obtenerla en otra.

### Ayuda
Crear `ZonedDateTime` y luego convertir.

---

## Ejercicio 14 - duracionSolapamiento
### Nivel
⭐⭐⭐

### Tiempo estimado
20-40 minutos

### Dependencias
manejo previo de zonas, periodos y validaciones
Indicar si dos intervalos se cruzan y cuanto tiempo.

### Ayuda
Trabajar en `Instant`.

---

## Ejercicio 15 - planSiguienteProcesamiento
### Nivel
⭐⭐⭐

### Tiempo estimado
20-40 minutos

### Dependencias
manejo previo de zonas, periodos y validaciones
Planificar el siguiente momento valido:
- solo dias habiles
- hora fija de ejecucion
- si ya paso o supera corte → avanzar

Ejercicio muy parecido a sistemas reales batch.

---

---
# EJERCICIOS DE EXPRESIONES + FECHAS (10)
---

## Ejercicio 1 - parsearFechaIso
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Validar `YYYY-MM-DD` y convertir a `LocalDate`.

---

## Ejercicio 2 - extraerPrimeraHora
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Buscar dentro de un texto la primera hora valida `HH:mm`.

---

## Ejercicio 3 - parsearFechaHoraFlexible
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Aceptar:
- `YYYY-MM-DD HH:mm`
- `YYYY-MM-DDTHH:mm`

---

## Ejercicio 4 - parsearComandoZona
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Entrada tipo:
```
SET TZ=Europe/Madrid
```
Extraer el `ZoneId`.

---

## Ejercicio 5 - parsearInstanteLog
### Nivel
⭐

### Tiempo estimado
10-15 minutos

### Dependencias
ninguna
Extraer timestamp entre corchetes y convertir a `Instant`.

---

## Ejercicio 6 - aplicarComandoDelta
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Dependencias
conceptos basicos de ejercicios anteriores
Aplicar comandos tipo:
```
+3d
-2h
+90m
```

---

## Ejercicio 7 - parsearRangoFechas
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Dependencias
conceptos basicos de ejercicios anteriores
Formato:
```
inicio..fin
```
Calcular dias totales e incluso habiles.

---

## Ejercicio 8 - contarEventosPorDia
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Dependencias
conceptos basicos de ejercicios anteriores
Extraer multiples `(fecha hora)` y agrupar por fecha.

---

## Ejercicio 9 - estaAbiertoDesdeConfig
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Dependencias
conceptos basicos de ejercicios anteriores
Leer configuracion:
```
OPEN=09:00 CLOSE=18:00 TZ=Atlantic/Canary
```
y validar usando la hora actual.

---

## Ejercicio 10 - parsearRecordatorioAInstante
### Nivel
⭐⭐

### Tiempo estimado
15-25 minutos

### Ejecutar tests
```bash
mvn clean test
```

### Ejecutar verificación completa (incluye JaCoCo + nota)
```bash
 mvn clean -Pcalificar verify
```

