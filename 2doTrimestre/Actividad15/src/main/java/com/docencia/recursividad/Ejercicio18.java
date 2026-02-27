/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que ordena dos arrays en uno
 */
package com.docencia.recursividad;

import java.util.Arrays;

public class Ejercicio18 {

  public static int[] fusionarOrdenados(int[] a, int[] b) {

    if (a == null || b == null) {
      return new int[] {};
    }
    if (a.length == 0) {
      return b;
    }
    if (b.length == 0) {
      return a;
    }

    if (a[0] <= b[0]) {
      return concatenarArrays(Arrays.copyOf(a, 1), fusionarOrdenados(Arrays.copyOfRange(a, 1, a.length), b));
    } else {
      return concatenarArrays(Arrays.copyOf(b, 1), fusionarOrdenados(Arrays.copyOfRange(b, 1, b.length), a));
    }
  }

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
