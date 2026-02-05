/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida un código postal
 */
package com.docencia.expresiones.ejercicio4;

import java.util.regex.Pattern;

/**
* 4) CÓDIGO POSTAL ESPAÑOL (01–52 + 3 dígitos)
 *    - Validar 5 dígitos donde los dos primeros sean 01–52.
 *    Válidos:   "01001", "28013", "52001"
 *    Inválidos: "00000", "53000", "1234", "ABCDE"
 */
public class Ejercicio04 {


  public static boolean isValidCodigoPostalES(String cp) {
    if(cp == null || cp.isBlank()){
      return false;
    }
    String patron = "^([0-5][1-2][0-9]{3}||[0-4][1-9][0-9]{3})$";
    return Pattern.matches(patron, cp);
  }

}
