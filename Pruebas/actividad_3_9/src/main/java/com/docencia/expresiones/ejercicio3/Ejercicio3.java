package com.docencia.expresiones.ejercicio3;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public final class Ejercicio3 {

    public static boolean esContrasenaFuerteValida(String texto) {
        if(texto == null || texto.isBlank()){
            return false;
        }

        String patron = "((?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*\\!))";
        String patron1 = "([A-Z]+[a-z]+[0-9]+(!)+)";

        return Pattern.matches(patron1, texto);

    }


   
}
