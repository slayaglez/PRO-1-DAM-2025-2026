/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que encuentra fechas en una cadena de texto
 */
package regexfechas;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise09 {
  // Encontrar fechas en texto con / o - (separador consistente)
  private static final Pattern P =
      Pattern.compile("");

  public static List<String> findAll(String text) {
    String patron = "(\\(?(3[0-1]||[1-2][0-9]||0[1-9])/(1[0-2]||0[1-9])/([0-9]{4})\\)?(.)?)||(\\(?(3[0-1]||[1-2][0-9]||0[1-9])-(1[0-2]||0[1-9])-([0-9]{4})\\)?(.)?)";
    List<String> resultado = new ArrayList<>();
    if(text == null || text.isBlank()){
      return resultado;
    }

    String[] textArray;
    //Si tiene un semicolon
    String patronSemicolon =".*;.*";
    if(Pattern.matches(patronSemicolon, text)){
      textArray = text.split(";");
    } else {
      textArray = text.split(" ");
    }

    for (int i = 0; i < textArray.length; i++) {
      String palabra = textArray[i];
      if(Pattern.matches(patron, palabra)){
        //si tiene punto
        if(palabra.length() == 11){
          palabra = palabra.substring(0,10);
        }
        //si esta entre parentesis
        if(palabra.length() >= 12){
          palabra = palabra.substring(1,11);
        }        
        resultado.add(palabra);
      }
    }
    
    return resultado;
  }
}
