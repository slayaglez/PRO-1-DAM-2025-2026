/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida fechas con meses en espaniol
 */
package regexfechas;

import java.util.regex.Pattern;

public class Exercise02 {
  // dd-mes-yyyy (mes en espaol, case-insensitive)
  // Acepta septiembre/setiembre.
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if(text == null || text.isBlank()){
      return false;
    }
    // este te va a encantar
    String patron = "^(3[0-1]||[1-2][0-9]||0[1-9]||[1-9])-([a-zA-Z]{5,})-([0-9]{4})(\\s(2[0-3]||1[0-9]||0[0-9]):([0-5][0-9]))?$";
    return Pattern.matches(patron, text);
  }
}
