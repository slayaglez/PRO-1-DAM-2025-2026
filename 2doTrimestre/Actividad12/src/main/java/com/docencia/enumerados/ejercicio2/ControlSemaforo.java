package com.docencia.enumerados.ejercicio2;

public final class ControlSemaforo {

  /**
   * Devuelve si puede avanzar o no
   * @param color color del semaforo
   * @return true or false
   */
  public boolean puedeAvanzar(ColorSemaforo color) {
    return color == ColorSemaforo.Verde;
  }

  /**
   * Devuelve el color siguiente
   * @param color color actual
   * @return color
   */
  public ColorSemaforo siguienteColor(ColorSemaforo color) {
    return switch (color) {
      case Rojo -> ColorSemaforo.Verde;
      case Verde -> ColorSemaforo.Ambar;
      case Ambar -> ColorSemaforo.Rojo;
    };
  }

  /**
   * Devuelve los segundos hasta el cambio
   * @param color color actual
   * @return numero de segundos para el cambio
   */
  public int segundosHastaCambio(ColorSemaforo color) {
    return switch (color) {
      case Rojo -> 45;
      case Verde -> 40;
      case Ambar -> 5;
    };
  }
}
