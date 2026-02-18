/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida fechas y horas no militares
 */
package com.docencia.expresiones.ejercicio5;

import java.util.regex.Pattern;

public final class Ejercicio5 {


    public static boolean esFechaHora12hAmPmValida(String texto) {
        if(texto == null || texto.isBlank()){
            return false;
        }

        String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[1-9])/([0-9]{4})(\\s(1[0-2]||0[1-9]||[0-9]):([0-5][0-9])\\s)((AM)||(PM))$";
        return Pattern.matches(patron, texto);

    }

}
