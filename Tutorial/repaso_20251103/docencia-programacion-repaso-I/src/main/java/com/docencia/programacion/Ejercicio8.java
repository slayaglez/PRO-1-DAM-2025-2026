package com.docencia.programacion;
/**
 * Clase que devuelve una cadena de texto numerica como entero
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio8 {
    
    /**
     * Funcion que transforma una cadena de texto a un numero entero
     * @param text la cadena de texto
     * @return el numero entero
     */
    public static int safeParseInt(String text) {
        if(text=="" || text == null){
            return 0;
        }
        for (int i = 0; i < text.length(); i++) {
            char caracter = text.charAt(i);
            if (caracter >= 'A' && caracter <= 'z'){
                return 0;
            }
            
        }
        int resultado = Integer.parseInt(text);
        return resultado;
    }
}
