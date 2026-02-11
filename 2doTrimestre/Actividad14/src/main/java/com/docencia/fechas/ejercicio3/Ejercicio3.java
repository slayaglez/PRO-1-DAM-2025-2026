/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con fechas
 */
package com.docencia.fechas.ejercicio3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public final class Ejercicio3 {

    private Ejercicio3() {}

    public static LocalDateTime buildAppointmentChecked(LocalDate date, LocalTime time, LocalDateTime now) {
        if(LocalDateTime.of(date, time).isBefore(now)){
            throw new IllegalArgumentException();
        } 

        return LocalDateTime.of(date, time);
    }
}
