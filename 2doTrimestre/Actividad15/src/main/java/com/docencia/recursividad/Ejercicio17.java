package com.docencia.recursividad;

public class Ejercicio17 {
  
  public static boolean estaOrdenadoAsc(int[] arreglo) {

    if(arreglo == null){
      throw new IllegalArgumentException();
    }
    
    return ordenado(arreglo, 0);
  }

  public static boolean ordenado(int[] arreglo, int n){

    if(n >= arreglo.length -1){
      return true;
    }
    
    if(arreglo[n] > arreglo[n+1]){
      return false;
    }

    return ordenado(arreglo, n+1);
  }
}
