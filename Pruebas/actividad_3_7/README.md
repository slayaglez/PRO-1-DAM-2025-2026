# Proyecto: Ejercicios 01-10 (Fechas + Expresiones Regulares) 

Este proyecto incluye **los ejercicios del 01 al 10** en Java (paquete `regexfechas`), con:
- **Una clase por ejercicio**: `Exercise10` … `Exercise20`
- **Un fichero de test por ejercicio**: `Exercise10Test` … `Exercise20Test`
- **15 tests por ejercicio**, y **cada test es un método `@Test` independiente** (no parameterized)
- En **todos** los ejercicios se validan:
  - `null`
  - `""` (cadena vacía)

## Requisitos
- Java 17+
- Maven 3.8+

## Ejecutar tests
```bash
mvn cleant test
```

---

## Ejercicio 01 — Buscar fechas `dd/MM/yyyy` dentro de un texto
**Qué hay que hacer:** Dado un texto, **extraer todas** las fechas con formato `dd/MM/yyyy`.

**Ejemplos que funcionan**
- `"La fecha es 15/08/2024."` → `["15/08/2024"]`
- `"01/01/2025 y 31/12/1999"` → `["01/01/2025","31/12/1999"]`

**Ejemplos que NO funcionan**
- `"1/1/2020"` → `[]` (no cumple 2 dígitos)
- `null` / `""` → `[]`

Clase: `Exercise01.findAll(String)`

---

## Ejercicio 02 — Validar fecha `dd-mes-yyyy` (mes en español)
**Qué hay que hacer:** Validar fechas tipo `12-marzo-2022` con el mes escrito en español.
Debe aceptar mayúsculas/minúsculas y `septiembre` / `setiembre`.

**Ejemplos que funcionan**
- `12-marzo-2022`
- `1-ENERO-2020`
- `12-setiembre-2022`

**Ejemplos que NO funcionan**
- `12-marz-2022` (mes incorrecto)
- `12/03/2022` (formato incorrecto)
- `null` / `""`

Clase: `Exercise02.isValid(String)`

---

## Ejercicio 03 — Validar `dd/MM/yyyy` con año entre 1900 y 2099
**Qué hay que hacer:** Validar el formato `dd/MM/yyyy` y que el año esté en `1900..2099`.

**Ejemplos que funcionan**
- `01/01/1900`
- `31/12/2099`

**Ejemplos que NO funcionan**
- `15/08/1899`
- `15/08/2100`
- `null` / `""`

Clase: `Exercise03.isValid(String)`

---

## Ejercicio 04 — Validar `dd-MM-yyyy` rechazando 00 en día/mes
**Qué hay que hacer:** Validar `dd-MM-yyyy` y **rechazar** día/mes fuera de rango (incluye `00`).

**Ejemplos que funcionan**
- `01-01-2020`

**Ejemplos que NO funcionan**
- `00-12-2020`
- `12-00-2020`
- `null` / `""`

Clase: `Exercise04.isValid(String)`

---

## Ejercicio 05 — Validar `d/m/yyyy` con 1 o 2 dígitos en día y mes
**Qué hay que hacer:** Aceptar `5/7/2023` y también `05/07/2023`.

**Ejemplos que funcionan**
- `5/7/2023`
- `05/07/2023`

**Ejemplos que NO funcionan**
- `0/7/2023`
- `5-7-2023`
- `null` / `""`

Clase: `Exercise05.isValid(String)`

---

## Ejercicio 06 — Validar `dd/MM/yyyy` opcionalmente con hora `HH:mm`
**Qué hay que hacer:** Aceptar:
- `dd/MM/yyyy`
- `dd/MM/yyyy HH:mm` (24h)

**Ejemplos que funcionan**
- `10/10/2023`
- `10/10/2023 14:30`

**Ejemplos que NO funcionan**
- `10/10/2023 24:00`
- `10/10/2023 7:05`
- `null` / `""`

Clase: `Exercise06.isValid(String)`

---

## Ejercicio 07 — Extraer día, mes y año desde `dd/MM/yyyy`
**Qué hay que hacer:** Si el formato es válido `dd/MM/yyyy`, devolver `Optional<int[]>` con `{día, mes, año}`.

**Ejemplos que funcionan**
- `05/11/2023` → `{5, 11, 2023}`

**Ejemplos que NO funcionan**
- `5/11/2023` → `Optional.empty()` (no cumple 2 dígitos)
- `null` / `""` → `Optional.empty()`

> Nota: este ejercicio **no valida calendario real**, solo formato y extracción.

Clase: `Exercise07.extract(String)`

---

## Ejercicio 08 — Validar solo fechas de diciembre
**Qué hay que hacer:** Validar `dd/12/yyyy`.

**Ejemplos que funcionan**
- `05/12/2020`

**Ejemplos que NO funcionan**
- `15/11/2020`
- `15-12-2020`
- `null` / `""`

Clase: `Exercise09.isValid(String)`

---

## Ejercicio 09 — Buscar fechas con `/` o `-` en un texto
**Qué hay que hacer:** Extraer fechas dentro de un texto en formato:
- `dd/MM/yyyy`
- `dd-MM-yyyy`
con separador consistente.

**Ejemplos que funcionan**
- `"05/11/2023 y 06-11-2023"` → `["05/11/2023","06-11-2023"]`

**Ejemplos que NO funcionan**
- `"05/11-2023"` → `[]`
- `null` / `""` → `[]`

Clase: `Exercise09.findAll(String)`

---

## Ejercicio 10 — Validar `dd/MM/yyyy` con año >= 2000
**Qué hay que hacer:** Validar formato y que el año sea `2000..2099`.

**Ejemplos que funcionan**
- `01/01/2000`
- `05/11/2023`

**Ejemplos que NO funcionan**
- `15/08/1999`
- `15/08/2100`
- `null` / `""`

Clase: `Exercise10.isValid(String)`

---

## Consulta tus resultados

```bash
 mvn clean -Pcalificar verify
```
