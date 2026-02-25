/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que comprueba si un arreglo esta ordenado de forma ascendente
 */
package com.docencia.logica;

public class Ejercicio17 {

  public static boolean estaOrdenadoAsc(int[] arreglo) {

    for (int i = 0; i < arreglo.length-1; i++) {
      if(arreglo[i] > arreglo[i+1]){
        return false;
      }
    }

    return true;
  }
}
