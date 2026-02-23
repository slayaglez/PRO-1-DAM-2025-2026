/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Invierte un numero  
 */
package com.docencia.logica;

public class Ejercicio09 {
  public static int invertirNumero(int n) {

    int signo = (n<0 ? -1 : 1); // -1 si se cumple
    n = Math.abs(n);
    int resultado = 0;

    while(n > 0){
      resultado = resultado * 10 + (n % 10);
      n = n / 10;
    }
    return signo * resultado;

  }
}
