/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que calcula la edad de alguien con su cumpleanios
 */
package com.docencia.logica.ejercicio2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.regex.Pattern;

public final class Ejercicio2 {

    public static int calcularEdad(String nacimiento, LocalDate hoy) {
        if(nacimiento == null || hoy == null || nacimiento.isBlank()){
            throw new IllegalArgumentException();
        }

        String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[1-9])/([0-9]{4})$";

        if(!Pattern.matches(patron, nacimiento)){
            throw new IllegalArgumentException();
        }

        String[] arrayFecha = nacimiento.split("/");
        String cumpleString = arrayFecha[2]+"-"+arrayFecha[1]+"-"+arrayFecha[0];

        LocalDate cumple;
        try {
            cumple = LocalDate.parse(cumpleString);
        } catch(Exception DateTimeParseException) {
            throw new IllegalArgumentException();
        }

        if(hoy.isBefore(cumple)){
            throw new IllegalArgumentException();
        }

        Period periodoVivido = Period.between(cumple, hoy);

        int resultado = periodoVivido.getYears();
        return resultado;

    }
    
}
