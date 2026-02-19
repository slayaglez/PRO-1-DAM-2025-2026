/**
 * @author slayaglez
 * @version 1.0.0
 * @brief factorial de un numero
 */
package com.docencia.logica;

public class Ejercicio01 {
  public static long factorial(int n) {
    if(n < 0){
      throw new IllegalArgumentException();
    }
    if (n == 1){
      return 1;
    }

    long resultado = 1;
    for (int i = 1; i <= n; i++) {
      resultado *= i;
    }


    return resultado;
  }

  public static void main(String[] args) {
    System.out.println(factorial(5));
  }
}
