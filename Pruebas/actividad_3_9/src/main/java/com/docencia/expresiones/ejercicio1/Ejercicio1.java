/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida fechas
 */
package com.docencia.expresiones.ejercicio1;

import java.util.regex.Pattern;

public final class Ejercicio1 {



    public static boolean esFechaDdMmAaaaValida(String texto) {

        if(texto == null || texto.isBlank()){
            return false;
        }

        String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[1-9])/([0-9]{4})$";
        return Pattern.matches(patron, texto);
    }

   
}
