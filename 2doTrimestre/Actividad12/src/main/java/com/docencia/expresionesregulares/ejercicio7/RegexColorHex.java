package com.docencia.expresionesregulares.ejercicio7;

import java.util.regex.Pattern;

public final class RegexColorHex {

  private static final Pattern PATRON = Pattern.compile("\"^#([0-9A-Fa-f]{6})$\"");

  private RegexColorHex() {}

  public static boolean esValido(String texto) {
    String patron = "^#([0-9a-fA-F]){6}$";
    return Pattern.matches(patron, texto);
  }

  public static Pattern patron() {
    return PATRON;
  }


}
