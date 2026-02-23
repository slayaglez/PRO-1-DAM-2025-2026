/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Cuenta digitos  
 */
package com.docencia.logica;

public class Ejercicio08 {
  
  public static int contarDigitos(int n) {
    n = Math.abs(n);

    if(n == 0){
      return 1;
    }
    int resultado = 0;

    while(n>0){
      resultado++;
      n = n/10;
    }
    return resultado;
  }
}
