/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida una fecha incluso con digitos unicos en 
 * los campos dias y mes
 */
package regexfechas;

import java.util.regex.Pattern;

public class Exercise05 {
  // Permite 1 o 2 dgitos en da y mes: 5/7/2023 o 05/07/2023
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if(text == null || text.isBlank()){
      return false;
    }
    String patron = "^(3[0-1]||[1-2][0-9]||0[1-9]||[1-9])/(1[0-2]||0[1-9]||[1-9])/([0-9]{4})$";
    return Pattern.matches(patron, text);
  }
}
