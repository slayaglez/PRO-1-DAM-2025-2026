/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con fechas
 */
package com.docencia.fechas.ejercicio1;

import com.docencia.fechas.BusinessCalendar;

import java.time.LocalDate;
import java.util.Objects;

public final class Ejercicio1 {

    private Ejercicio1() {}

    public static String labelDay(LocalDate date) {
        if(date == null){
            throw new NullPointerException();
        }
        
        if(date.getDayOfWeek().getValue() > 5){
            return "FIN_DE_SEMANA";
        }
        return "LABORABLE";
    }
}
