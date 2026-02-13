/**
 * @author slayaglez
 * @version 1.0.0.
 * @brief programa que trbaja con logs y fechas
 */
package com.docencia.expresiones.ejercicio5;

import java.time.DateTimeException;
import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio5 {

    private Ejercicio5() {
    }

    public static Instant parseLogInstant(String logLine) {
        if (logLine == null || logLine.isBlank()) {
            throw new IllegalArgumentException();
        }

        Pattern patron1 = Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}[+-][0-9]{2}:[0-9]{2}");
        Matcher encontrado1 = patron1.matcher(logLine);

        Pattern patron2 = Pattern.compile("\\[[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}[+-][0-9]{2}:[0-9]{2}\\]");
        Matcher encontrado2 = patron2.matcher(logLine);

        if (!encontrado2.find()) {
            if(!encontrado1.find()){
                throw new DateTimeException("mal");
            }
            throw new IllegalArgumentException();
        }

        if (encontrado1.find()) {
            String fecha = encontrado1.group();
            return Instant.parse(fecha);
        }

        return null;
    }
}
