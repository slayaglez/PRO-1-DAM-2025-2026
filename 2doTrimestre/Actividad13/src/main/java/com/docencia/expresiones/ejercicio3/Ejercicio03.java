/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida un correo electronico
 */
package com.docencia.expresiones.ejercicio3;

import java.util.regex.Pattern;

/**
* 3) EMAIL 
 *    - Validar email basico: sin espacios, una sola '@', dominio con al menos un '.'.
 *      (No es RFC completo).
 *    Válidos:   "a@b.com", "user.name+tag@sub.domain.es"
 *    Inválidos: "a@@b.com", "a@b", "a b@c.com", "@b.com", "a@.com"
 *
 */
public class Ejercicio03 {

    

  public static boolean isValidEmail(String email) {
    if(email == null || email.isBlank()){
      return false;
    }
    String patron = "^[a-zA-Z0-9+%-*.]+@([a-z]+.)?[a-z]+.[a-z]{2,}$";

    return Pattern.matches(patron, email);
  }
}
