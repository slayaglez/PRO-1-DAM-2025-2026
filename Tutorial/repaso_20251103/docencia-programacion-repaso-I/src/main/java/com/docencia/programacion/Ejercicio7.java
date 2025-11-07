package com.docencia.programacion;
/** 
 * Clase que trabaja de forma segura con Strings calculando largo, pasando a mayusculas
 * y devolviendo el primer caracter.
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio7 {
    
    /**
     * Funcion que devuelve el tamanio de una cadena de texto
     * @param text cadena de texto
     * @return entero con el tamanio de la cadena
     */
    public static int lengthSafe(String text) {
        if(text == null || text == ""){
            return 0;
        }
        return text.length();
    }

    /**
     * Funcion que devuelve la cadena en mayusculas
     * @param text la cadena de texto
     * @return la cadena en mayusculas
     */
    public static String toUpperSafe(String text) {
        if(text == null || text == ""){
            return "";
        }
        return text.toUpperCase();
    }

    /**
     * Funcion que devuelve el primer caracter de la cadena
     * @param text la cadena 
     * @return el primer caracter de la cadena
     */
    public static char firstCharOrNullChar(String text) {
        if(text == null || text == ""){
            return '\0';
        }
        return text.charAt(0);
    }
}
