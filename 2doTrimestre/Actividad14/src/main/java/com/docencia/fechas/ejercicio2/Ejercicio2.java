/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con fechas
 */
package com.docencia.fechas.ejercicio2;

import com.docencia.fechas.TimeUtils;

import java.time.LocalTime;

public final class Ejercicio2 {

    private Ejercicio2() {}

    public static LocalTime roundDownToStep(LocalTime time, int stepMinutes) {
        if(time == null){
            throw new NullPointerException();
        }
        if(stepMinutes <= 0) {
            throw new IllegalArgumentException();
        }

        int minutos = time.getMinute();
        int cociente = minutos/stepMinutes;
        return time.withMinute(cociente * stepMinutes).withSecond(0);
    }
}
