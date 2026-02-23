/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Invierte un numero  
 */
package com.docencia.recursividad;

public class Ejercicio10 {
  public static String invertirCadena(String texto) {

    if(texto == null || texto.isBlank()){
      return "";
    }

    if (texto.length() == 1) {
        return texto;
    }

    //la ultima letra
    String letra = texto.substring(texto.length()-1, texto.length());

    return letra + invertirCadena(texto.substring(0, texto.length()-1));
  }
}
