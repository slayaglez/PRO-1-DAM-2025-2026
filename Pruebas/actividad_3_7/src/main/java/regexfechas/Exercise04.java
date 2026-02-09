/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida fechas incluso tolerando las 00
 */
package regexfechas;

import java.util.regex.Pattern;

public class Exercise04 {
  // dd-MM-yyyy rechazando 00 (ya lo rechazan los rangos)
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if(text == null || text.isBlank()){
      return false;
    }
    String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])-(1[0-2]||0[1-9])-([0-9]{4})$";
    return Pattern.matches(patron, text);
  }
}
