package com.docencia.fechas.ejercicio5;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public final class Ejercicio5 {

    private Ejercicio5() {}

    public static int ageYears(LocalDate birth, LocalDate today) {

        if(birth.isBefore(today)){
            throw new IllegalArgumentException();
        }

        return 0;
    }
}
