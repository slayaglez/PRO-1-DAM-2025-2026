package com.docencia.expresionesregulares.ejercicio3;

import java.util.regex.Pattern;

public final class RegexCodigoProducto {

  private static final Pattern PATRON = Pattern.compile("\"^[A-Z]{3}-[0-9]{4}$\"");

  private RegexCodigoProducto() {}

  public static boolean esValido(String texto) {
    String patron = "^[A-Z]{3}-[0-9]{4}$";
    return Pattern.matches(patron, texto);
  }

  public static Pattern patron() {
    return PATRON;
  }


}
