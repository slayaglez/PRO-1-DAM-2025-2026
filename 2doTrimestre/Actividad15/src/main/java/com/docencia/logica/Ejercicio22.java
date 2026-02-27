/**
 * @author slayaglez
 * @verison 1.0.0
 * @brief potencia rapida
 */
package com.docencia.logica;

public class Ejercicio22 {

  public static long potenciaRapida(long base, int exponente) {

    int resultado = 1;

    while (exponente > 0) {

      if (exponente % 2 != 0) {
        resultado *= base;
      }
      base *= base;
      exponente /= 2;
    }
    return resultado;
  }
}
