package com.docencia.fechas.ejercicio4;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Objects;

public final class Ejercicio4 {

    private Ejercicio4() {}

    public static LocalDate endOfMonth(LocalDate date) {
        if(date == null){
            throw new NullPointerException();
        }

        return date.with(TemporalAdjusters.lastDayOfMonth());
    }
}
