/**
 * @author slayaglez
 * @version 1.0.0
 * @brief programa que devuelve un índice dado un objetivo
 */
package com.docencia.logica;

public class Ejercicio19 {
  
  public static int busquedaBinaria(int[] arregloOrdenado, int objetivo) {

    if(arregloOrdenado == null){
      return -1;
    }

    for (int i = 0; i < arregloOrdenado.length; i++) {
      if(arregloOrdenado[i] == objetivo){
        return i;
      }
    }

    return -1;
  }
}
