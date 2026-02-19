/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que suma los elementos de un array
 */
package com.docencia.logica;

public class Ejercicio11 {
  public static long sumaArreglo(int[] arreglo) {
    
    if(arreglo == null){
      throw new IllegalArgumentException();
    }
    if(arreglo.length < 1){
      return 0;
    }
    
    long resultado =0l;
    for (int i : arreglo) {
      resultado += i;
    }

    return resultado;
  }
}
