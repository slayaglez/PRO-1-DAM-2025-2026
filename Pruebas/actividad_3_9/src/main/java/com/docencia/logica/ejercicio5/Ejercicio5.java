/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que suma dias sin contar los dias no laborales
 */
package com.docencia.logica.ejercicio5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Pattern;

public final class Ejercicio5 {

    public static LocalDate sumarDiasLaborables(String fechaInicio, int n) {
        if (fechaInicio == null || fechaInicio.isBlank() || n < 0) {
            throw new IllegalArgumentException();
        }

        // paso de string a localdate
        String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[1-9])/([0-9]{4})$";
        if (!Pattern.matches(patron, fechaInicio)) {
            throw new IllegalArgumentException();
        }
        String[] arrayFecha = fechaInicio.split("/");
        String fechaString = arrayFecha[2] + "-" + arrayFecha[1] + "-" + arrayFecha[0];
        LocalDate fechaDate;
        try {
            fechaDate = LocalDate.parse(fechaString);
        } catch (Exception DateTimeParseException) {
            throw new IllegalArgumentException();
        }

        if (n == 0) {
            return fechaDate;
        }
        
        // si estoy en sabado o domingo
        // si divido n entre 5 numero de dias laborales de la semana
        // recibo el numero de semanas que debo avanzar, tras ello
        // el resto de dicha division es el numero de dias que le debo sumar
        // si cae sabado o domingo caso especial
        int numeroSemanasASumar = n/5;
        int numeroDiasASumar = n % 5;

        int numeroDiaSemana = fechaDate.getDayOfWeek().getValue();
        if(numeroDiaSemana == 6){
            return fechaDate.plusDays(2);
        }
        if(numeroDiaSemana == 7){
            return fechaDate.plusDays(1);
        }

        fechaDate = fechaDate.plusWeeks(numeroSemanasASumar).plusDays(numeroDiasASumar);

        numeroDiaSemana = fechaDate.getDayOfWeek().getValue();
        if(numeroDiaSemana == 6){
            return fechaDate.plusDays(2);
        }
        if(numeroDiaSemana == 7){
            return fechaDate.plusDays(1);
        }

        return fechaDate;
    }

}
