package com.docencia.expresionesregulares.ejercicio1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class RegexSoloDigitos {

  private static final Pattern PATRON = Pattern.compile("\"^[0-9]+$\"");

  private RegexSoloDigitos() {}

  public static boolean esValido(String texto) {
    Matcher m = PATRON.matcher(texto);
    return m.matches();
  }

  public static Pattern patron() {
    // TODO: implementar este metodo
    throw new UnsupportedOperationException("TODO");
  }


}
