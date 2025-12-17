/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que une un array de String contatenando con un guion
 */

package com.docencia.arrays.ejercicio9;

public class Ejercicio9 {
    /**
     * Devuelve un String uniendo con '-' usando for. Si null o vacío, devuelve "".
     * @param palabras Array de String
     * @return String concatenado
     */
    public static String concatenarConGuion(String[] palabras) {
        if(palabras == null || palabras.length == 0){
            return "";
        }

        String resultado = palabras[0];
        for (int i = 1; i < palabras.length; i++) {
            String palabra = palabras[i];
            resultado+="-"+palabra;
        }

        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio9 listo para implementar.");
    }
}
