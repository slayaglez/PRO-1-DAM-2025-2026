/**
 * @author slayaglez
 * @version 1.0.0
 * @brief una cuenta regresiva
 */
package com.docencia.logica;

import java.util.ArrayList;
import java.util.List;
public class Ejercicio06 {
  public static List<Integer> cuentaRegresiva(int n) {
    if(n<0){
      throw new IllegalArgumentException();
    }

    List<Integer> resultado = new ArrayList<>();
    if(n==0){
      resultado.add(0);
      return resultado;
    }

    for (int i = 0; i <= n; i++) {
      resultado.add(n-i);
    }
    return resultado;
  }
}
