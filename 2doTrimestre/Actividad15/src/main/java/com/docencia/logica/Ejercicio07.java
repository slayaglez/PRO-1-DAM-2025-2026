/**
 * @author slayaglez
 * @version 1.0.0
 * @brief suma de digitos
 */
package com.docencia.logica;

public class Ejercicio07 {
  
  public static int sumaDigitos(int n) {
    n = Math.abs(n);
    int suma =0;

    while (n > 0){
      suma = suma + (n % 10);
      n = n / 10;
    }
    return suma;
  }
}
