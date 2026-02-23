/**
 * @author slayaglez
 * @version 1.0.0
 * @brief programa que prueba si una palabra es palindromo
 */
package com.docencia.logica;

public class Ejercicio14 {
  
  public static boolean esPalindromo(String texto) {

    for (int i = 0; i < texto.length()/2; i++) {
      char letra1 = texto.charAt(i);
      char letra2 = texto.charAt(texto.length()-1-i);

      if(letra1 != letra2){
        return false;
      }
    }
    return true;
    
  }
}
