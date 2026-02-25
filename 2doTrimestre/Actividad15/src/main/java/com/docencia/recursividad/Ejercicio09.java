/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Invierte un numero  
 */
package com.docencia.recursividad;

public class Ejercicio09 {
  public static int invertirNumero(int n) {

    if (n < 0) {
      return -invertirNumero(-n);
    }

    return invertir(n, 0);
  }

  private static int invertir(int n, int acumulado) {
    
    if (n == 0) {
      return acumulado;
    }
    return invertir(n / 10, acumulado * 10 + n % 10);
  }
}