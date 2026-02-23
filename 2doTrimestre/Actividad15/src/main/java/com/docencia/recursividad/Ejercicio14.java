/**
 * @author slayaglez
 * @version 1.0.0
 * @brief programa que prueba si una palabra es palindromo
 */
package com.docencia.recursividad;

public class Ejercicio14 {

  public static boolean esPalindromo(String texto) {

    if(texto == null || texto.isBlank()){
      return true;
    }

    if(texto.length() == 1){
      return true;
    }

    char letra1 = texto.charAt(0);
    char letra2 = texto.charAt(texto.length() - 1);

    if (letra1 != letra2) {
      return false;
    }

    return esPalindromo(texto.substring(1, texto.length()-1));
  }
}
