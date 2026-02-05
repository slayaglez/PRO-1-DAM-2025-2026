/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida una hora ISO-8601
 */
package com.docencia.expresiones.ejercicio9;

import java.util.regex.Pattern;

/**
 * 9) ISO-8601 DATETIME CON ZONA Y MILISEGUNDOS "OPCIONALES"
 *    - Validar datetimes ISO-8601 tipo:
 *      "2025-01-02T03:04:05Z"
 *      "2025-01-02T03:04:05.123+02:00"
 *      Reglas:
 *      - milisegundos opcionales (1 a 3 dígitos)
 *      - zona obligatoria: 'Z' o ±HH:MM
 *    Válidos:   "2025-12-31T23:59:59Z", "2025-12-31T23:59:59.9-03:30"
 *    Inválidos: "2025-12-31 23:59:59Z", "2025-12-31T23:59:59", "2025-12-31T23:59:59+2:00"
 * 
 */
public class Ejercicio09 {

  public static boolean isValidIsoDateTimeWithZone(String text) {
    if(text == null || text.isBlank()){
      return false;
    }

    // YYYY-MM-DDTHH:MM:SSZ || YYYY-MM-DDTHH:MM:SS.S-HH:MM //? Que es esto hermano???

    String patron3 = "^[0-9]{4}-(1[0-2]||0[1-9])-(3[0-1]||[1-2][0-9]||0[1-9])T(2[0-3]||1[0-9]||0[0-9]):([0-5][0-9]):([0-5][0-9])(\\.[0-9]+)?(Z||([+-](2[0-3]||1[0-9]||[1-9]||00):([0-5][0-9])))$";
    String patron4 = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])T([01]\\d|2[0-3]):([0-5]\\d):([0-5]\\d)(\\.\\d{1,3})?(Z|[+-]([01]\\d|2[0-3]):[0-5]\\d)$";
    return Pattern.matches(patron4, text);
  }
}
