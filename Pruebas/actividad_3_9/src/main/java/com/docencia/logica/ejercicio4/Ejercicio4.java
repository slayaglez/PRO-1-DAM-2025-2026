/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que devuelve si es un dia laborable o no pasada una fecha
 */
package com.docencia.logica.ejercicio4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Set;

public final class Ejercicio4 {


        
public static boolean esLaborable(LocalDate d) {
    
        if(d == null){
            throw new NullPointerException();
        }

        int numeroDiaSemana = d.getDayOfWeek().getValue();
        if(numeroDiaSemana > 5){
            return false;
        }
        return true;
    }
    
}
