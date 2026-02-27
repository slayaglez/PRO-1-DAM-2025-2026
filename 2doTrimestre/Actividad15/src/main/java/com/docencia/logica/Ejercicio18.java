/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que ordena dos arrays en uno
 */
package com.docencia.logica;

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

    int[] resultado = new int[a.length + b.length];
    int aux1 = 0;
    int aux2 = 0;
    int aux3 = 0;

    while (aux1 < a.length && aux2 < b.length) {
      if (a[aux1] <= b[aux2]) {
        resultado[aux3] = a[aux1];
        aux3++;
        aux1++;
      } else {
        resultado[aux3] = b[aux2];
        aux3++;
        aux2++;
      }
    }

    while (aux1 < a.length) {
      resultado[aux3] = a[aux1];
      aux3++;
      aux1++;
    }

    while (aux2 < b.length) {
      resultado[aux3] = b[aux2];
      aux3++;
      aux2++;
    }

    return resultado;

  }
}
