/**
 * @author slayaglez
 * @version 1.0.0
 * @brief devuelve el indice de un objetivo
 */
package com.docencia.logica;

public class Ejercicio13 {
  
  public static int buscarLineal(int[] arreglo, int objetivo) {
    for (int i = 0; i < arreglo.length; i++) {
      if(arreglo[i] == objetivo){
        return i;
      }
    }
    return -1;
    
  }
}
