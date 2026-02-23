package com.docencia.recursividad;

public class Ejercicio12 {
  public static int maximoArreglo(int[] arreglo) {

    if (arreglo == null || arreglo.length == 0) {
        return 0;
    }

    if(arreglo.length == 1){
      return arreglo[0];
    }

    return maxDesde(arreglo, 0);
  }

  public static int maxDesde(int[] arreglo, int n){
    if(n == arreglo.length-1){
      return arreglo[n];
    }
    int max = maxDesde(arreglo, n+1);
    return Math.max(arreglo[n], max);
  }
}
