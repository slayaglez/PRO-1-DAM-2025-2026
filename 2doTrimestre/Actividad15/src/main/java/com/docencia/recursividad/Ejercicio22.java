/**
 * @author slayaglez
 * @version 1.0.0
 * @brief 1.0.0
 */
package com.docencia.recursividad;

public class Ejercicio22 {
  public static long potenciaRapida(long base, int exponente) {

    if(exponente == 0){
      return 1;
    }

    if(exponente % 2 == 0){
      return potenciaRapida(base, exponente/2) * potenciaRapida(base, exponente/2);
    }
    else {
      return base * potenciaRapida(base, exponente-1);
    }
  }
}
