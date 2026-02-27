/**
 * @author slayaglez
 * @version 1.0.0
 * @brief quicksort
 */
package com.docencia.recursividad;

import java.util.ArrayList;

public class Ejercicio21 {
  // quicksort se basa en escoger un pivote dividir lo que este por
  // encima y lo que este por debajo
  // ordenar por separado y sumarlo todo
  public static int[] quickSort(int[] arreglo) {

    //? caso base
    if (arreglo.length <= 1) {
      return arreglo;
    }

    int pivote = arreglo[0];

    ArrayList<Integer> menores = new ArrayList<>();
    ArrayList<Integer> mayores = new ArrayList<>();

    for (int i = 1; i < arreglo.length; i++) {
      if (arreglo[i] <= pivote) {
        menores.add(arreglo[i]);
      } else {
        mayores.add(arreglo[i]);
      }
    }

    // menores
    int[] arrayMenores = new int[menores.size()];
    for (int i = 0; i < menores.size(); i++) {
      arrayMenores[i] = menores.get(i);
    }
    int[] menoresOrdenados = quickSort(arrayMenores);

    // mayores
    int[] arrayMayores = new int[mayores.size()];
    for (int i = 0; i < mayores.size(); i++) {
      arrayMayores[i] = mayores.get(i);
    }
    int[] mayoresOrdenados = quickSort(arrayMayores);

    int[] pivoteArray = {pivote};
    int[] menoresMasPivote = concatenarArrays(menoresOrdenados, pivoteArray);
    return concatenarArrays(menoresMasPivote, mayoresOrdenados);
  }

  // reciclo codigo de nuevo
  public static int[] concatenarArrays(int[] a, int[] b) {

    int[] concatenado = new int[a.length + b.length];

    for (int i = 0; i < a.length; i++) {
      concatenado[i] = a[i];
    }
    for (int i = 0; i < b.length; i++) {
      concatenado[i + a.length] = b[i];
    }

    return concatenado;
  }
}
