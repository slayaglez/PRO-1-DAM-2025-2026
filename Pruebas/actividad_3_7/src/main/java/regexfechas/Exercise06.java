/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida fechas y opcionalmente una hora
 */
package regexfechas;

import java.util.regex.Pattern;

public class Exercise06 {
  // dd/MM/yyyy opcionalmente seguido de " HH:mm" (24h)
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if(text == null || text.isBlank()){
      return false;
    }
    String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[1-9])/([0-9]{4})(\\s(2[0-3]||1[0-9]||0[0-9]):([0-5][0-9]))?$";
    return Pattern.matches(patron, text);

  }
}
