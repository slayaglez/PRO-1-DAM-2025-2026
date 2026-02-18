/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja comprobando si una hora este en un intervalo
 */
package com.docencia.logica.ejercicio1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Objects;
import java.util.regex.Pattern;

public final class Ejercicio1 {

    public static boolean estaDentroHorario(String hora, LocalTime inicio, LocalTime fin) {
        if (hora == null || hora.isBlank() || inicio == null || fin == null) {
            return false;
        }

        String patron = "^(2[0-3]||[0-1][0-9]):([0-5][0-9])$";
        if (Pattern.matches(patron, hora)) {

            LocalTime horaTime = LocalTime.parse(hora);
            if(horaTime.equals(inicio)&& horaTime.equals(fin)){
                return true;
            }

            // mismo dia
            if (inicio.isBefore(fin)) {
                return (horaTime.isAfter(inicio) && horaTime.isBefore(fin)) || horaTime.equals(inicio) || horaTime.equals(fin);

            }
        }

        return false;
    }

}
