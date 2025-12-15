/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que invierte un array
 */
package com.docencia.arrays.ejercicio4;

public class Ejercicio4 {
    /**
     * Devuelve un nuevo array con los elementos en orden inverso (sin modificar el original).
     * @param numeros array de numeros
     * @return el array al reves
     */
    public static int[] invertir(int[] numeros) {
        int[] resultado = new int[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            resultado[i] = numeros[numeros.length-1-i];           
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio4 listo para implementar.");
    }
}
