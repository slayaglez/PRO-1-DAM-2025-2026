/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que suma los elementos de un array
 */
package com.docencia.recursividad;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Ejercicio11 {
  public static long sumaArreglo(int[] arreglo) {
    
    if(arreglo == null){
      throw new IllegalArgumentException();
    }
    if(arreglo.length < 1){
      return 0;
    }
    if(arreglo.length == 1){
      return arreglo[0];
    }

    long resultado = arreglo[arreglo.length-1];
    int[] arregloNuevo = Arrays.copyOf(arreglo, arreglo.length-1);
    return resultado + sumaArreglo(arregloNuevo);
  }
}
