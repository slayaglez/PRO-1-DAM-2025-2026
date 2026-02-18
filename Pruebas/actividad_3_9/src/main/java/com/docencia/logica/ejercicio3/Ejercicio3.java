/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con fechas y festivos y laborales
 */
package com.docencia.logica.ejercicio3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Set;
import java.util.regex.Pattern;

public final class Ejercicio3 {

    public static LocalDate siguienteLaborable(String fecha, Set<LocalDate> festivos) {
        if (fecha == null || fecha.isBlank() || festivos == null) {
            throw new IllegalArgumentException();
        }

        // paso de string a localdate
        String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[1-9])/([0-9]{4})$";
        if (!Pattern.matches(patron, fecha)) {
            throw new IllegalArgumentException();
        }
        String[] arrayFecha = fecha.split("/");
        String fechaString = arrayFecha[2] + "-" + arrayFecha[1] + "-" + arrayFecha[0];
        LocalDate fechaDate;
        try {
            fechaDate = LocalDate.parse(fechaString);
        } catch (Exception DateTimeParseException) {
            throw new IllegalArgumentException();
        }

        // si no hay festivos
        if (festivos.isEmpty()) {

            // averiguo si el siguiente dia es laborable
            int numeroDiaSemana = fechaDate.getDayOfWeek().getValue();
            if (numeroDiaSemana > 5) {
                // no es laborable sabado o domingo
                if (numeroDiaSemana == 6) {
                    return fechaDate.plusDays(2);
                }
                return fechaDate.plusDays(1);
            }
            // es laborable
            return fechaDate;

        }

        // si hay festivos
        LocalDate resultado = fechaDate;

        // es festivo?
        for (LocalDate festivo : festivos) {
            if (festivo.equals(resultado)) {
                resultado = resultado.plusDays(1);
            }
        }

        // es no laborable?
        int numeroDiaSemana = resultado.getDayOfWeek().getValue();
        if (numeroDiaSemana > 5) {
            // no es laborable sabado o domingo
            if (numeroDiaSemana == 6) {
                resultado = resultado.plusDays(2);
            } else {
                //es domingo
                resultado = resultado.plusDays(1);
            }
            
        }

        // el tema laboral esta arreglado, pero es festivo?
        // repito
        for (LocalDate festivo : festivos) {
            if (festivo.equals(resultado)) {
                resultado = resultado.plusDays(1);
            }
        }
        return resultado;

    }

}
