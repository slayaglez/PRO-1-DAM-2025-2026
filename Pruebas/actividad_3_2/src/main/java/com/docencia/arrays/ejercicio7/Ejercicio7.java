/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que compara dos arrays y devuelve si son iguales o no
 */
package com.docencia.arrays.ejercicio7;

public class Ejercicio7 {
    
    /**
     * Devuelve true si ambos arrays tienen la misma longitud y mismos valores en cada posición.
     * @param array1 el primer array
     * @param array2 el segundo array
     * @return verdadero o falso
     */
    public static boolean sonIguales(int[] array1, int[] array2) {
        if(array1.length == array2.length){
            for (int i = 0; i < array2.length; i++) {
                if(array1[i] != array2[i]){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio7 listo para implementar.");
    }
}
