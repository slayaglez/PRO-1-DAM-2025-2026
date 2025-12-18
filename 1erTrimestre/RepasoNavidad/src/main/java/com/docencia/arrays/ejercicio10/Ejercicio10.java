/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que sustituye los elementos negativos por cero
 */
package com.docencia.arrays.ejercicio10;

public class Ejercicio10 {
    /**
     * Devuelve un nuevo array donde los negativos se sustituyen por 0.
     * @param numeros array de numeros
     * @return array con negativos sustituidos por cero
     */
    public static int[] normalizarNegativos(int[] numeros) {
        if(numeros == null || numeros.length == 0){
            return null;
        }

        int[] resultado = new int[numeros.length];

        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i] < 0){
                resultado[i] = 0;
            } else {
                resultado[i] = numeros[i];
            }    
            
        }
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio10 listo para implementar.");
    }
}
