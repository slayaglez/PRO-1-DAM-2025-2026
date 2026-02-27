/**
 * @author slayaglez
 * @version 1.0.0
 * @brief merge sort
 */
package com.docencia.logica;

import java.util.Arrays;

public class Ejercicio20 {

    public static int[] mergeSort(int[] arreglo) {
        if (arreglo == null || arreglo.length <= 1) {
            return arreglo;
        }

        for (int i = 1; i < arreglo.length; i *= 2) {
            for (int inicio = 0; inicio < arreglo.length - i; inicio += i * 2) {
                int mitad = inicio + i;
                int fin = Math.min(inicio + i * 2, arreglo.length);
                fusionar(arreglo, inicio, mitad, fin);
            }
        }
        return arreglo;
    }

    private static void fusionar(int[] arreglo, int inicio, int mitad, int fin) {
        int[] temp = Arrays.copyOfRange(arreglo, inicio, fin);
        int i = 0;
        int j = mitad - inicio;
        int k = inicio;

        while (i < mitad - inicio && j < fin - inicio) {
            if (temp[i] <= temp[j]) {
                arreglo[k++] = temp[i++];
            } else {
                arreglo[k++] = temp[j++];
            }
        }
        while (i < mitad - inicio) {
            arreglo[k++] = temp[i++];
        }
        while (j < fin - inicio) {
            arreglo[k++] = temp[j++];
        }
    }
}
