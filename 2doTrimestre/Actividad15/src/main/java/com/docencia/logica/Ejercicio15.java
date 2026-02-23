/**
 * @author slayaglez 
 * @version 1.0.0
 * @brief programa que cuenta ocurrencias de un caracter
 */
package com.docencia.logica;

public class Ejercicio15 {
  
  public static int contarCaracter(String texto, char c) {

    if(texto == null || texto.isBlank()){
      return 0;
    }

    int resultado = 0;
    for (int i = 0; i < texto.length(); i++) {
      if (texto.charAt(i) == c) {
          resultado++;
      }
    }

    return resultado;
  }
}
