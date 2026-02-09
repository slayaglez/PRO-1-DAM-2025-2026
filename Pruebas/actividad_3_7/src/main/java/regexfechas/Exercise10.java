/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida fechas siempre que el anio este
 * entre 2000 y 2099
 */
package regexfechas;

import java.util.regex.Pattern;

public class Exercise10 {
  // dd/MM/yyyy con ao >= 2000 (2000..2099)
  private static final Pattern P =
      Pattern.compile("^(3[0-1]||[1-2][0-9]||0[0-9])/(1[0-2]||0[0-9])/([0-9]{4})$");

  public static boolean isValid(String text) {
    if(text == null || text.isBlank()){
      return false;
    }

    String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[1-9])/(20[0-9]{2})$";
    return Pattern.matches(patron, text);    
  }
}
