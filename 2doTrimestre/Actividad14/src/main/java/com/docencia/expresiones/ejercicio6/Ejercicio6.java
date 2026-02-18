/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con fechas
 */
package com.docencia.expresiones.ejercicio6;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Ejercicio6 {

    private Ejercicio6() {}

    public static LocalDateTime applyDeltaCommand(LocalDateTime base, String command) {
        if(base == null || command == null || command.isBlank()){
            throw new IllegalArgumentException();
        }
        
        String patron = "(\\+||\\-)([0-9]+)(d||h)";
        if(Pattern.matches(patron, command)){
            String operador = command.substring(0,1);
            int numero = Integer.parseInt(command.substring(1,2));
            String formato = command.substring(2,3);

            if(formato.equals("d")){
                if(operador.equals("+")){
                    return base.plusDays(numero);
                }
                return base.minusDays(numero);
            }
            if(operador.equals("+")){
                return base.plusHours(numero);
            }
            return base.minusHours(numero);
        }

        throw new IllegalArgumentException();
    }
}
