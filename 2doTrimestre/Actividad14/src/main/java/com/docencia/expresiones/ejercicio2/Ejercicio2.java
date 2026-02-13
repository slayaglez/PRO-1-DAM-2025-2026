/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con fechas y strings
 */
package com.docencia.expresiones.ejercicio2;

import java.time.LocalTime;
import java.util.regex.Pattern;

public final class Ejercicio2 {

    private Ejercicio2() {}


    public static LocalTime extractFirstTime(String text) {
        if(text == null || text.isBlank()){
            throw new IllegalArgumentException();
        }

        String patron = "^(2[0-4]||[0-1][0-9]):([0-5][0-9])$";
        String[] arrayPalabras = text.split(" ");

        for (String palabra : arrayPalabras) {
            if(Pattern.matches(patron, palabra)){
                return LocalTime.parse(palabra);
            }
        }
        throw new IllegalArgumentException();
    }
}
