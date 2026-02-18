/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida una fecha formato iso con posible hora
 */
package com.docencia.expresiones.ejercicio4;

import java.util.regex.Pattern;

public final class Ejercicio4 {


    public static boolean esFechaIsoConHoraOpcionalValida(String texto) {
        if(texto == null || texto.isBlank()){
            return false;
        }

        String patron = "^([0-9]{4})-(1[0-2]||0[1-9])-(3[0-1]||[1-2][0-9]||0[1-9])(\\s(2[0-3]||[0-1][0-9]):[0-5][0-9])?$";

        return Pattern.matches(patron, texto);

    }

}
