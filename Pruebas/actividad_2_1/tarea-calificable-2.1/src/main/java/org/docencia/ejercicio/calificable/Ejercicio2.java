package org.docencia.ejercicio.calificable;
/**
 * Una clase que cuenta vocales de un String
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio2 {

    /**
     * Funcion que cuenta vocales en un String
     * @param frase El String
     * @return El numero de vocales del String
     */
    public static int contarVocales(String frase) {

        if(frase == "" || frase == null) {
            return 0;
        }

        int vocal = 0;
        frase = frase.toLowerCase();

        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);

            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u'){
                vocal++;
            }
        }
        return vocal;
    }
}
