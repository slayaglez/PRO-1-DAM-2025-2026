/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con fechas
 */
package com.docencia.fechas.ejercicio7;

import com.docencia.fechas.TimeUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class Ejercicio7 {

    private Ejercicio7() {}

    public static boolean isOpenInclusive(LocalTime t, LocalTime open, LocalTime close) {
        if(t == null || open == null || close == null){
            throw new NullPointerException();
        }

        LocalDate fecha = LocalDate.of(2000, 1, 1);
        LocalDateTime diaOpen = LocalDateTime.of(fecha, open);
        LocalDateTime diaT = LocalDateTime.of(fecha, t);
        LocalDateTime diaClose = LocalDateTime.of(fecha, close);
        
        //mismo dia
        if(diaOpen.isBefore(diaClose)){
            if((diaOpen.isBefore(diaT) && diaClose.isAfter(diaT)) || diaOpen.equals(diaT) || diaClose.equals(diaT)){
                return true;
            } 
            return false;
        }
        //otro dia
        diaClose = LocalDateTime.of(fecha.plusDays(1), close); //? RECUERDA no es lo mismo a diaClose.plusDays(1)

        if(diaT.isBefore(diaClose)&&diaT.isBefore(diaOpen)){
            diaT = LocalDateTime.of(fecha.plusDays(1), t);
        }
        
        if((diaT.isAfter(diaOpen) && diaT.isBefore(diaClose))){ 
            return true;
        }
        return false;
    }
}
