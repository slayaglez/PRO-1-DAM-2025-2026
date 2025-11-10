package org.docencia.ejercicio.calificable;

/**
 * Clase que devuelve el numero de caracteres de una palabra si dicha palabra
 * esta en el String
 * 
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio4 {

    /**
     * Funcion que cuenta el numero de caracteres de una palabra si se encuentra en
     * el String
     * 
     * @param frase   El String
     * @param palabra La palabra que se busca
     * @return El numero de caracteres de la palabra
     */
    public static int tamPalabraEnFrase(String frase, String palabra) {

        if (frase == null || frase.isEmpty() || palabra == null || palabra.isEmpty()) {
            return 0;
        }

        frase = frase.trim().toLowerCase();
        palabra = palabra.trim().toLowerCase();
        int resultado = 0;
        String caracterStr = "";
        String fraseAlfanumerica = "";

        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            caracterStr = String.valueOf(caracter);

            if (caracter == ' ' || (caracter >= 'a' && caracter <= 'z') || (caracter >= '0' && caracter <= '9') 
                    || caracter == 'ó' || caracter == 'é' || caracter == 'í'
                    || caracter == 'á' || caracter == 'ú') {
                fraseAlfanumerica += caracterStr;
            } else {
                fraseAlfanumerica += ' ';
            }

        }

        fraseAlfanumerica = fraseAlfanumerica.replaceAll("🙂", " ");
        String[] palabras = fraseAlfanumerica.split(" ");
        for (String palabraFrase : palabras) {
            if (palabraFrase.equals(palabra)) {
                resultado = palabraFrase.length();
            }
        }

        return resultado;
    }
}
