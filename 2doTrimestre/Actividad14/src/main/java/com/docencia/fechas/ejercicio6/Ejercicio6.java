package com.docencia.fechas.ejercicio6;

import com.docencia.fechas.BusinessCalendar;

import java.time.LocalDate;

public final class Ejercicio6 {

    private Ejercicio6() {}

    public static LocalDate addBusinessDays(LocalDate start, int n) {
        if(start == null){
            throw new NullPointerException();
        }
        if(n == 0){
            return start;
        }
        if(n < 0){
            throw new IllegalArgumentException();
        }
    
        if(start.getDayOfWeek().getValue() == 5){
            return start.plusDays(n).plusDays(2);
        }
        if(start.getDayOfWeek().getValue() == 6){
            return start.plusDays(n).plusDays(1);
        }
        return start.plusDays(n);
    }
}
