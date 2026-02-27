/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que cuenta ocurrencias de un char de forma recursiva
 */
package com.docencia.recursividad;

public class Ejercicio15 {
  
  public static int contarCaracter(String texto, char c) {

    if(texto.length() == 0){
      return 0;
    }

    int ocurrencias = 0;
    if(texto.charAt(0) == c){
      ocurrencias++;
    }

    String textoNuevo = texto.substring(1, texto.length());
    return ocurrencias + contarCaracter(textoNuevo, c);
  }
}
