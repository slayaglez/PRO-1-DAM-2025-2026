/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que calcula un intervalo en minutos entre dos horas distintas
 */
package com.docencia.fecha.ejercicio3;

import java.time.LocalTime;

/**
 * EJERCICIO 3) Minutos hasta una hora objetivo (hoy o mañana)
 *
 * Calcula los minutos desde 'ahora' hasta 'objetivo'.
 * - Si objetivo es igual o posterior a ahora, calcula la diferencia dentro del
 * mismo día.
 * - Si objetivo es anterior a ahora, se considera que el objetivo ocurre
 * "mañana"
 * y se calcula el tiempo restante hasta el final del día + el tiempo desde
 * 00:00 hasta objetivo.
 *
 * Programación defensiva:
 * - Si ahora u objetivo son null, lanza IllegalArgumentException.
 *
 * Ejemplos:
 * - ahora=10:00, objetivo=10:10 => 10
 * - ahora=23:50, objetivo=00:10 => 20
 */
public class Ejercicio03 {
    public static long minutosHasta(LocalTime ahora, LocalTime objetivo) {
        if(ahora == null || objetivo == null){
            throw new IllegalArgumentException();
        }
        long minutos = 0;
        int horas = 0;

        if(ahora.equals(objetivo)){
            return 0;
        }

        if(ahora.isBefore(objetivo)){
            minutos = objetivo.getMinute() - ahora.getMinute();
            horas = objetivo.getHour() - ahora.getHour();
            minutos += horas*60;
        }
        else {
            // si ahora no es before obj es after obj
            // calculo intervalo de ahora a las 00:00 y de las 00:00 a objetivo
            // ejemplo 23:50 -> 00:00 luego 00:00 -> 00:10
            // 00:00 se puede mirar de forma practica como 23:60
            // si hago 23:60 - 23:50 devolveria 10 min y //! no permite 23:60
            //? Lo sustituyo por 23:59 y le sumo un minuto
            // sumo minutos y horas de obj
            horas = 23;
            minutos = 59;

            horas -= ahora.getHour();
            minutos -= ahora.getMinute();
            minutos ++;

            horas += objetivo.getHour();
            minutos += objetivo.getMinute();

            minutos += horas*60;
        }
        
        return minutos;

    }
}
