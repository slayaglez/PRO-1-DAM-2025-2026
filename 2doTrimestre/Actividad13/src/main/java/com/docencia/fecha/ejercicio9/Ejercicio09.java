/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que itera en una lista de horas y se queda con la menor y la mayor
 */
package com.docencia.fecha.ejercicio9;

import java.time.LocalTime;
import java.util.List;

/**
     * EJERCICIO 9) Obtener mínimo y máximo de una lista (una sola pasada)
     *
     * Dada una lista de LocalTime, devuelve un array de tamaño 2:
     * - índice 0: la hora más temprana
     * - índice 1: la hora más tardía
     * Sin ordenar la lista (solo recorriéndola una vez).
     *
     * Programación defensiva:
     * - Si la lista es null, lanza IllegalArgumentException.
     * - Si la lista está vacía, lanza IllegalArgumentException.
     * - Si la lista contiene null, lanza IllegalArgumentException (o define política e impleméntala).
     *
     * Ejemplo:
     * - [10:00, 09:30, 12:15] => [09:30, 12:15]
     */
public class Ejercicio09 {
    public static LocalTime[] minMax(List<LocalTime> horas) {
        if(horas == null || horas.isEmpty()){
            throw new IllegalArgumentException();
        }

        LocalTime[] resultado = new LocalTime[2];
        //resultado[0] = min;
        //resultado[1] = max;
        LocalTime minimo = horas.get(0);
        LocalTime maximo = horas.get(0);
        for (int i = 1; i < horas.size(); i++) {
            if(horas.get(i) == null){
                throw new IllegalArgumentException();
            }
            if(horas.get(i).isBefore(minimo)){
                minimo = horas.get(i);
            }
            if(horas.get(i).isAfter(maximo)){
                maximo = horas.get(i);
            }
        }
        resultado[0] = minimo;
        resultado[1] = maximo;

        return resultado;
    }
}
