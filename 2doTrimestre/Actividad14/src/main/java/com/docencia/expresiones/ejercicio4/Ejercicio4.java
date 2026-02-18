/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con zonas horarias y su ids
 */
package com.docencia.expresiones.ejercicio4;

import java.time.ZoneId;
import java.util.regex.Pattern;

public final class Ejercicio4 {

    private Ejercicio4() {}


    public static ZoneId parseZoneCommand(String input) {

        if(input == null || input.isBlank()){
            throw new IllegalArgumentException();
        }

        String patron = "^(SET TZ=)(.)+$";

        if(Pattern.matches(patron, input)){
            String[] cadena = input.split("=");
            String zona = cadena[1];
            ZoneId idZona = ZoneId.of(zona);
            return idZona;
        }
        throw new IllegalArgumentException();
    }
}
