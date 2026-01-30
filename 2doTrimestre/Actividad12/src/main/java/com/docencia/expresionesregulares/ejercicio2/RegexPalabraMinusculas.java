package com.docencia.expresionesregulares.ejercicio2;

import java.util.regex.Pattern;

public final class RegexPalabraMinusculas {

  private static final Pattern PATRON = Pattern.compile("\"^[a-z]{3,10}$\"");

  /**
   * Constructor vacio
   */
  private RegexPalabraMinusculas() {}

  /**
   * Devuelve si una cadena cumple con un patron o no
   * @param texto la cadena de texto
   * @return
   */
  public static boolean esValido(String texto) {
    String patron = "^[a-z]{3,10}$";
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
