/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Invierte un numero  
 */
package com.docencia.logica;

public class Ejercicio10 {
  
  public static String invertirCadena(String texto) {
    
    if (texto == null || texto.isBlank()) {
      return "";
    }

    if(texto.length() == 1){
      return texto;
    }

    String inversa = "";

    for (int i = texto.length()-1; i >= 0 ; i--) {
      char letra = texto.charAt(i);
      inversa += String.valueOf(letra);
    }

    return inversa;
  }
}
