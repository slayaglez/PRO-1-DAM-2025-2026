/**
 * @author slayaglez
 * @version 1.0.0
 * @brief vamos a ver
 */
package com.docencia.recursividad;

import java.util.Arrays;

public class Ejercicio30 {

  public static boolean existeSubconjuntoSuma(int[] arreglo, int objetivo) {

    // dos opciones por elemento, incluirlo o no
    if(objetivo == 0){
      return true;
    }

    if(arreglo.length == 0) {
        return false;
    }

    // si lo incluyo busco en lo que quede del conjunto algo 
    // que sume lo que me falta para el objetivo
    boolean incluyo = existeSubconjuntoSuma(Arrays.copyOfRange(arreglo, 1, arreglo.length), objetivo - arreglo[0]);
    
    // si no lo incluyo busco si existe en lo que quede del conjunto 
    // algo que sume lo que me falta para el objetivo
    boolean NOincluyo = existeSubconjuntoSuma(Arrays.copyOfRange(arreglo, 1, arreglo.length), objetivo);
    
    return incluyo || NOincluyo;
  }
}
