package com.docencia.logica;

import java.util.Arrays;

public class Ejercicio30 {
  public static boolean existeSubconjuntoSuma(int[] arreglo, int objetivo) {

    if(objetivo == 0){
      return true;
    }

    int resultado = 0;
    for (int i = 0; i < arreglo.length; i++) {
      resultado += arreglo[i];
    }
    if(resultado == objetivo){
      return true;
    }

    int indice = 0;
    int comparador = arreglo[indice];

    for (int i = 0; i < arreglo.length; i++) {
      int[] subConjunto = Arrays.copyOfRange(arreglo, i, arreglo.length);
      //Todo
    }

    throw new UnsupportedOperationException("Pendiente de implementar");
  }
}
