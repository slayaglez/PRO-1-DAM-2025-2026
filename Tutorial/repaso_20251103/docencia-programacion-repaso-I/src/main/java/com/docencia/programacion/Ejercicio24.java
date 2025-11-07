package com.docencia.programacion;

/**
 * Clase que convierte cada palabra a minuscula excepto por la primera
 * que la vuelve mayuscula
 * 
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio24 {

    /**
     * Funcion que vuelve mayuscula la primera letra de cada palabra
     * 
     * @param text String de texto
     * @return String de texto con la primera en mayusculas
     */
    public static String titleCase(String text) {
        if (text == null || text == "") {
            return "";
        }

        text = text.trim().toLowerCase(); 

        boolean enPalabra = false;
        String caracterStr = "";
        String resultado = "";
        int espacios=0;

        for (int i = 0; i < text.length(); i++) {
            char caracter = text.charAt(i);
            caracterStr = String.valueOf(caracter);

            
            if (enPalabra == false && caracter != ' ') {
                espacios=0;
                caracterStr = caracterStr.toUpperCase();
                enPalabra = true;
            }
            if (caracter == ' ') {
                enPalabra = false;
                espacios++;
            }
            if(espacios<=1){
                resultado += caracterStr;
            }
            
        }
        return resultado;
    }
}
