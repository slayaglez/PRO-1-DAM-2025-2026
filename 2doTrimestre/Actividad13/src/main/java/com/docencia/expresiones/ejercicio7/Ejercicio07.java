/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida una contraseña
 */

package com.docencia.expresiones.ejercicio7;

import java.util.regex.Pattern;

/**
 * 7) VALIDAR CONTRASEÑA “MÍNIMA”
 *    - Debe tener entre 8 y 32 caracteres
 *    - Sin espacios
 *    - Al menos 1 mayúscula
 *    - Al menos 1 minúscula
 *    - Al menos 1 dígito
 *
 *    Válidos:   "Abcdefg1", "XyZ12345", "PassWord9"
 *    Inválidos: "abcdefg1" (sin mayúscula),
 *               "ABCDEFG1" (sin minúscula),
 *               "Abcdefgh" (sin dígito),
 *               "Abc 1234" (con espacio),
 *               "Ab1" (demasiado corta)
 */
public class Ejercicio07 {


  public static boolean isValidPasswordMin(String text) {
    if(text == null || text.isEmpty()){
      return false;
    }

    //? "?=" es un lookhead y sirve para asegurar que una condición se cumpla
    String patron = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])\\S{8,32}$";
    return Pattern.matches(patron, text);
  }
}
