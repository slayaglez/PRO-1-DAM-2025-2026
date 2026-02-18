package com.docencia.expresiones.ejercicio1;

import java.time.LocalDate;
import java.util.regex.Pattern;

public final class Ejercicio1 {

    private Ejercicio1() {}

    

    public static LocalDate parseIsoDate(String input) {
        if(input == null || input.isBlank()){
            throw new IllegalArgumentException();
        }

        String patron = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";

        if(Pattern.matches(patron, input)){
            return LocalDate.parse(input);
        }
        throw new IllegalArgumentException();
    }
}
