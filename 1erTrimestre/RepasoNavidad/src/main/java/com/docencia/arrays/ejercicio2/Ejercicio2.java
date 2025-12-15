/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Una clase que encuentra el maximo de un array
 */

package com.docencia.arrays.ejercicio2;

public class Ejercicio2 {
    /**
     * Devuelve el valor máximo del array. Si es null o vacío, lanza IllegalArgumentException.
     * @param numeros el array de numeros
     * @return el maximo del array
     */
    public static int maximo(int[] numeros) {
        if(numeros == null){
            return 0; 
        }
        
        if(numeros.length == 0){
            throw new IllegalArgumentException();   
        }
        
        int maximo = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if(maximo < numeros[i]){
                maximo = numeros[i];
            }
        }
        return maximo;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio2 listo para implementar.");
    }
}
