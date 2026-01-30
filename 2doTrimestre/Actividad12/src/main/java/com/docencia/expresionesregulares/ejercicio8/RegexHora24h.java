package com.docencia.expresionesregulares.ejercicio8;

import java.util.regex.Pattern;

public final class RegexHora24h {

  private static final Pattern PATRON = Pattern.compile("\"^([01][0-9]|2[0-3]):[0-5][0-9]$\"");

  private RegexHora24h() {}

  public static boolean esValido(String texto) {
    String patron = "^(00|2[0-3]|1[0-9]|0[0-9]):([0-5][0-9])$";
    return Pattern.matches(patron, texto);
  }

  public static Pattern patron() {
    return PATRON;
  }


}
