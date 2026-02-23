package com.docencia.logica;

public class Ejercicio12 {
  public static int maximoArreglo(int[] arreglo) {

    if (arreglo == null || arreglo.length == 0) {
        return 0;
    }

    int max = arreglo[0];
    for (int i : arreglo) {
      if(i > max){
        max = i;
      }
    }
    return max;
  }
}
