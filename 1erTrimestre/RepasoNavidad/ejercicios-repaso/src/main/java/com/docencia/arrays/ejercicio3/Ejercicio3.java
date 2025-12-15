/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Una clase que encuentra el numero de elementos pares que hay
 */
package com.docencia.arrays.ejercicio3;

public class Ejercicio3 {
    /**
     * Cuenta cuántos elementos del array son pares.
     * @param numeros el array
     * @return numero de pares
     */
    public static int contarPares(int[] numeros) {

        int pares=0;
        
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i]%2==0){
                pares++;
            }
        }
        return pares;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio3 listo para implementar.");
    }
}
