/**
 * @authors slayaglez
 * @version 1.0.0
 * @brief
 */
package com.docencia.recursividad;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio27 {

  public static List<List<Integer>> generarSubconjuntos(int[] arreglo) {

    // eso es caso base solo
    if (arreglo.length == 0) {
      List<List<Integer>> resultado = new ArrayList<>();
      resultado.add(new ArrayList<>());
      return resultado;
    }

    //todo

    throw new UnsupportedOperationException("Pendiente de implementar");
  }
}
