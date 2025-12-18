/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que suma todos los elementos de un array
 */

package com.docencia.arrays.ejercicio1;

public class Ejercicio1 {
    /**
     * Suma todos los elementos del array. Si es null o vacío, devuelve 0.
     * @param numeros array de numeros
     * @return la suma total
     */
    public static int sumar(int[] numeros) {
        if(numeros == null || numeros.length == 0){
            return 0;
        }
        
        int total = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            total += numeros[i];
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio1 listo para implementar.");
    }
}
