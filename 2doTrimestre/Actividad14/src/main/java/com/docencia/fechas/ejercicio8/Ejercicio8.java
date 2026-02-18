/**
 * @author slayaglez
 * @version 1.0.0
 * @brief 
 */
package com.docencia.fechas.ejercicio8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public final class Ejercicio8 {

    private Ejercicio8() {}

    public static LocalDate processingDateByCutoff(LocalDateTime received, LocalTime cutoff) {
        if(received == null || cutoff == null){
            throw new NullPointerException();
        }

        // primero la fecha de received la paso a cutoff
        // si cutoff isBefore received devuelvo received +1 dia
        LocalDate fecha = LocalDate.of(received.getYear(), received.getMonthValue(), received.getDayOfMonth());
        LocalDateTime fechaCutoff = LocalDateTime.of(fecha, cutoff);

        if(fechaCutoff.isBefore(received)){
            return fecha.plusDays(1);
        }
        return fecha;
    }
}
