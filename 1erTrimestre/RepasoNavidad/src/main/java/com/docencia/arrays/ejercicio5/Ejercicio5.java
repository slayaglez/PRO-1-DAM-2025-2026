/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que devuelve el indice de un elemento de un array
 */
package com.docencia.arrays.ejercicio5;

public class Ejercicio5 {
    /**
     * Devuelve el índice de objetivo o -1 si no está.
     * @param numeros array de numeros
     * @param objetivo numero cuyo indice se busca
     * @return indice del numero
     */
    public static int indiceDe(int[] numeros, int objetivo) {
        
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] == objetivo){
                return i;
            }
        }

        return -1;
        
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio5 listo para implementar.");
    }
}
