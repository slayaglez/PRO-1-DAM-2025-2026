/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con fechas
 */
package com.docencia.expresiones.ejercicio3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio3 {

    private Ejercicio3() {}


    public static LocalDateTime parseFlexibleLocalDateTime(String input) {
        if(input == null){
            throw new IllegalArgumentException();
        }

        String patronSimple = "[0-9]{4}-[0-9]{2}-[0-9]{2}(\\s||T)[0-9]{2}:[0-9]{2}";
        String patron = "^([0-9]{4}-(1[0-2]||0[1-9])-(3[0-1]||[1-2][0-9]||0[1-9]))(\\s||T)(2[0-4]||[0-1][0-9]):([0-5][0-9])$";

        //? Si la fecha ni se parece a una fecha tiro
        if(!Pattern.matches(patronSimple, input)){
            throw new IllegalArgumentException();
        }

        //? Si la fecha cumple con los limites en horas meses o dias
        if(Pattern.matches(patron, input)){
            String[] arrayFecha = input.split("-");

            int anioNumero = Integer.parseInt(arrayFecha[0]);
            int mesNumero = Integer.parseInt(arrayFecha[1]);
            String diaString = arrayFecha[2].substring(0, 2);
            int diaNumero = Integer.parseInt(diaString);

            String horaString = arrayFecha[2].substring(3, 8);
            String[] arrayHora = horaString.split(":");
            int horaNumero = Integer.parseInt(arrayHora[0]);
            int minutoNumero = Integer.parseInt(arrayHora[1]);

            return LocalDateTime.of(anioNumero, mesNumero, diaNumero, horaNumero, minutoNumero);
        }
        
        throw new DateTimeException("Fecha incorrecta");
    }
}
