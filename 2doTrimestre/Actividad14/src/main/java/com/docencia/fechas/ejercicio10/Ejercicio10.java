/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con horas
 */
package com.docencia.fechas.ejercicio10;

import java.time.Duration;
import java.time.LocalTime;

public final class Ejercicio10 {

    private Ejercicio10() {}

    public static long minutesBetweenWithWrap(LocalTime start, LocalTime end) {
        if(start == null || end == null){
            throw new NullPointerException();
        }
        long resultado = 0l;

        if(start.equals(end)){
            return resultado;
        }
        
        //mismo dia
        if (start.isBefore(end)) {
            Duration periodo = Duration.between(start, end);
            resultado = periodo.toMinutes();
            return resultado;
        }
        
        //otro dia
        LocalTime casiMediaNoche = LocalTime.of(23, 59);
        LocalTime mediaNoche = LocalTime.of(0, 0);
        Duration periodo1 = Duration.between(start, casiMediaNoche);
        Duration periodo2 = Duration.between(mediaNoche, end);
        resultado = periodo1.toMinutes() + periodo2.toMinutes() + 1;
        return resultado;
    }
}
