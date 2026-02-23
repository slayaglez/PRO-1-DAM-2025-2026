/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Cuenta digitos  
 */
package com.docencia.recursividad;

public class Ejercicio08 {
  
  public static int contarDigitos(int n) {

    n = Math.abs(n);
    int resultado=0;

    if(n < 10){
      resultado++;
      return resultado;
    }

    return 1 + contarDigitos(n/10);
  }
}
