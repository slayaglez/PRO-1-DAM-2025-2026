/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida fechas siempre que sean entre 1900 y 2099
 */
package regexfechas;

import java.util.regex.Pattern;

public class Exercise03 {
  // dd/MM/yyyy con ao entre 1900 y 2099
  private static final Pattern P =
      Pattern.compile("");

  public static boolean isValid(String text) {
    if(text == null || text.isBlank()){
      return false;
    }
    String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[1-9])/(19[0-9]{2}||20[0-9]{2})$";
    return Pattern.matches(patron, text);
  }
}
