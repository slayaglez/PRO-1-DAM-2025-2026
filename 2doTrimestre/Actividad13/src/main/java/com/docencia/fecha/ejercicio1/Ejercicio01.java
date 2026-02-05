/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que comprueba si una fecha se encuentra en un intervalo
 */
package com.docencia.fecha.ejercicio1;

import java.time.LocalTime;

/**
 * EJERCICIO 1) Dentro de intervalo simple (sin cruzar medianoche)
 *
 * Dadas tres horas: t, inicio y fin, devuelve true si t está dentro del
 * intervalo [inicio, fin),
 * es decir: incluye inicio y excluye fin.
 *
 * Requisitos:
 * - El intervalo NO cruza medianoche (se asume inicio < fin).
 * - Si t == fin, el resultado debe ser false.
 *
 * Programación defensiva:
 * - Si t, inicio o fin son null, lanza IllegalArgumentException.
 * - Si inicio.equals(fin), considera el intervalo vacío y devuelve false (o
 * documenta tu decisión).
 * - Si inicio.isAfter(fin), lanza IllegalArgumentException (intervalo inválido
 * para este ejercicio).
 *
 * Ejemplos:
 * - t=10:00, inicio=09:00, fin=12:00 => true
 * - t=12:00, inicio=09:00, fin=12:00 => false
 */

public class Ejercicio01 {
    public static boolean estaDentro(LocalTime t, LocalTime inicio, LocalTime fin) {
        if (t == null || inicio == null || fin == null || inicio.isAfter(fin)) {
            throw new IllegalArgumentException();
        } else if (inicio.equals(fin)) {
            return false;
        }

        return t.isBefore(fin) && t.isAfter(inicio) || t.equals(inicio);
    }
}
