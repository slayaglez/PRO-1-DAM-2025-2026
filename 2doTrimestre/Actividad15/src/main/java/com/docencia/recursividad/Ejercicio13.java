/**
 * @author slayaglez
 * @version 1.0.0
 * @brief programa que busca un indice por su objetivo
 */
package com.docencia.recursividad;

public class Ejercicio13 {
  
  public static int buscarLineal(int[] arreglo, int objetivo) {
    
    return buscar(arreglo, objetivo, 0);

  }

  public static int buscar(int[] arreglo, int objetivo, int indice) {
    
    if(indice > arreglo.length-1){
      return -1;
    }
    
    if(arreglo[indice] == objetivo){
      return indice;
    }

    return buscar(arreglo, objetivo, indice+1);
  }
}
