/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida fechas siempre que sean de diciembre
 */
package regexfechas;

import java.util.regex.Pattern;

public class Exercise08 {
  private static final Pattern P =
      Pattern.compile("(3[0-1]||[1-2][0-9]||0[1-9])/(12)/([0-9]{4})");

  public static boolean isValid(String text) {
    if(text == null){
      return false;
    }
    String patron = "(3[0-1]||[1-2][0-9]||0[1-9])/(12)/([0-9]{4})";
    return Pattern.matches(patron, text);
  }
}
