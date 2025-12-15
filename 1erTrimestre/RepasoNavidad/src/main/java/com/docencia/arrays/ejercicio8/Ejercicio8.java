/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que cuenta el numero de apariciones de un valor en un array
 */

package com.docencia.arrays.ejercicio8;

public class Ejercicio8 {
    /**
     * Cuenta cuántas veces aparece 'valor' en el array.
     * @param numeros array
     * @param valor numero que se busca
     * @return numero de apariciones del numero buscado
     */
    public static int contarOcurrencias(int[] numeros, int valor) {
        
        int resultado=0;
        
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] == valor){
                resultado++;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio8 listo para implementar.");
    }
}
