/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que calcula la media entera de un array
 */
package com.docencia.arrays.ejercicio6;

public class Ejercicio6 {
    /**
     * Devuelve la media entera (suma/longitud). Si es null o vacío, devuelve 0.
     * @param numeros array de numeros
     * @return media entera del array
     */
    public static int mediaEntera(int[] numeros) {
        if(numeros == null || numeros.length == 0){
            return 0;
        }
        int media=numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            media += numeros[i];
        }
        media /= numeros.length;

        return media;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio6 listo para implementar.");
    }
}
