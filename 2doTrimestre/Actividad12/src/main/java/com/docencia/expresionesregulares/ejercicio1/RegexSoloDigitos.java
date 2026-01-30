package com.docencia.expresionesregulares.ejercicio1;

import java.util.regex.Pattern;

public final class RegexSoloDigitos {

  private static final Pattern PATRON = Pattern.compile("\"^[0-9]+$\"");

  /**
   * Constructor vacío
   */
  private RegexSoloDigitos() {}

  /**
   * Comprueba si una cadena de texto es valida
   * @param texto la cadena de texto
   * @return true or false
   */
  public static boolean esValido(String texto) {
    String patron = "^[0-9]+$";
    return Pattern.matches(patron, texto);
  }

  /**
   * Devuelve el patron
   * @return el patron
   */
  public static Pattern patron() {
    return PATRON;
  }


}
