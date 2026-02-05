/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida una matricula espaniola
 */
package com.docencia.expresiones.ejercicio5;

import java.util.regex.Pattern;

/**
 * 5) MATRÍCULA ESPAÑOLA MODERNA (1234ABC, sin vocales típicas)
 *    - Validar 4 dígitos + 3 letras (normalmente sin vocales A,E,I,O,U).
 *    Válidos:   "1234BCD", "0001XYZ"
 *    Inválidos: "123ABC", "1234AEI", "12A4BCD" 
 */
public class Ejercicio05 {


  public static boolean isValidMatriculaES(String plate) {
    if(plate == null || plate.isEmpty()){
      return false;
    }
    String patron = "^[0-9]{4}[^AEIOUa-z0-9]{3}$";
    return Pattern.matches(patron, plate);
  }
}
