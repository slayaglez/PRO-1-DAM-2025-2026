package com.docencia.fechas.ejercicio8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public final class Ejercicio8 {

    private Ejercicio8() {}

    public static LocalDate processingDateByCutoff(LocalDateTime received, LocalTime cutoff) {
        if(received == null || cutoff == null){
            throw new IllegalArgumentException();
        }

        // TODO No se copien chicos por favor
        return null;
    }
}
