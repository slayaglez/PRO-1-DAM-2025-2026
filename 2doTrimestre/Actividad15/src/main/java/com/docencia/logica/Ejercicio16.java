/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que 
 */
package com.docencia.logica;

public class Ejercicio16 {
  
  public static String eliminarCaracter(String texto, char c) {

    if(texto == null || texto.isBlank()){
      throw new IllegalArgumentException();
    }

    String resultado = "";
    for (int i = 0; i < texto.length(); i++) {
      if(texto.charAt(i) != c){
        resultado += texto.charAt(i);
      }
    }

    return resultado;
  }
}
