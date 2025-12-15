/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que devuelve true si dos arrays son iguales
 */
package com.docencia.arrays.ejercicio7;

public class Ejercicio7 {
    /**
     * Devuelve true si ambos arrays tienen la misma longitud y mismos valores en cada posición.
     * @param a array numero 1
     * @param b array numero 2
     * @return si son iguales o no
     */
    public static boolean sonIguales(int[] a, int[] b) {
        if(a.length != b.length){
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio7 listo para implementar.");
    }
}
