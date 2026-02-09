/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que devuelve un array con dias, meses y anios
 * separados en un array de enteros
 */
package regexfechas;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise07 {
  // Extraer da, mes y ao desde dd/MM/yyyy
  private static final Pattern P =
      Pattern.compile("");

  public static int[] extract(String text) {
    String patron = "^(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[0-9])/([0-9]{4})$";
    if(text == null || text.isBlank()){
      return null;
    }

    if(Pattern.matches(patron, text)){

      // dd/mm/aaaa
      int[] resultado = new int[3];
      String diaStr = text.substring(0, 2);
      String mesStr = text.substring(3, 5);
      String anioStr = text.substring(6, 10);

      int dia = Integer.parseInt(diaStr);
      int mes = Integer.parseInt(mesStr);
      int anio = Integer.parseInt(anioStr);

      resultado[0] = dia;
      resultado[1] = mes;
      resultado[2] = anio;

      return resultado;
    }

    return null;
  }
}
