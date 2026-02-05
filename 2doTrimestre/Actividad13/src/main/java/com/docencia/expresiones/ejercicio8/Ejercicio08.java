/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida una IPv4
 */
package com.docencia.expresiones.ejercicio8;

import java.util.regex.Pattern;

/**
 * 8) VALIDAR IPv4 (0–255) EXACTO
 *    - Validar una IPv4 donde cada octeto está en 0..255:
 *      A.B.C.D, cada parte sin salirse del rango.
 *    Válidos:   "0.0.0.0", "255.255.255.255", "192.168.1.10"
 *    Inválidos: "256.0.0.1", "192.168.1", "1.2.3.4.5", "192.168.01.1"
 * 
 */
public class Ejercicio08 {

  public static boolean isValidIPv4(String ip) {

    if(ip == null || ip.isBlank()){
      return false;
    }

    String patron = "^((2[0-5][0-5]||2[0-4][0-9]||1([0-9]){2}||[1-9][0-9]||[0-9])\\.){3}(2[0-5][0-5]||2[0-4][0-9]||1([0-9]){2}||[1-9][0-9]||[0-9])$";
    return Pattern.matches(patron, ip);

  }
}
