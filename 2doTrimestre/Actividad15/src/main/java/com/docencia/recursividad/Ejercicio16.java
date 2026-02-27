/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que elimina un caracter de una cadena
 */
package com.docencia.recursividad;

public class Ejercicio16 {
  
  public static String eliminarCaracter(String texto, char c) {

    if(texto == null || texto.isBlank()){
      return "";
    }

    if(texto.length()==0){
      return "";
    }

    String textoNuevo = "";
    if(texto.charAt(0) != c){
      textoNuevo += texto.charAt(0);
    }

    return textoNuevo + eliminarCaracter(texto.substring(1, texto.length()), c);

  }
}
