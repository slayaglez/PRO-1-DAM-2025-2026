/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que concatena un array de String con guiones
 */
package com.docencia.arrays.ejercicio9;

public class Ejercicio9 {
    
    /**
     * Concatena un array de String con guiones
     * @param palabras el array de String
     * @return un String concatenado
     */
    public static String concatenarConGuion(String[] palabras) {
        if(palabras == null || palabras.length == 0){
            return "";
        }

        String resultado = palabras[0];

        for (int i = 1; i < palabras.length; i++) {
            resultado+="-"+palabras[i];
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio9 listo para implementar.");
    }
}
