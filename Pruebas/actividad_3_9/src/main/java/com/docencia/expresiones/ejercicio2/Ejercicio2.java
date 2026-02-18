/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja validando URLs
 */
package com.docencia.expresiones.ejercicio2;

import java.time.LocalTime;
import java.util.regex.Pattern;


public final class Ejercicio2 {


    public static boolean esUrlHttpValida(String texto) {

        if(texto == null || texto.isBlank()){
            return false;
        }

        String patron = "^http(s)?:\\/\\/(.)+(\\.[a-z]+)(\\/.*)?$";
        return Pattern.matches(patron, texto);
    }

}
