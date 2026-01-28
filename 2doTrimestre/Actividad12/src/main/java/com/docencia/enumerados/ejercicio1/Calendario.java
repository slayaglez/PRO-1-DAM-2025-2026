package com.docencia.enumerados.ejercicio1;

public final class Calendario {

  /**
   * Devuelve si es fin de semana o no
   * @param dia el dia de la semana
   * @return true or false
   */
  public boolean isFinDeSemana(DiaSemana dia) {
    return dia == DiaSemana.Sabado || dia == DiaSemana.Domingo;
  }

  /**
   * Devuelve si es dia de la semana o no
   * @param dia el dia de la semana
   * @return true or false
   */
  public boolean isLaboral(DiaSemana dia) {
    return !isFinDeSemana(dia);
  }

  public DiaSemana siguienteDia(DiaSemana dia) {
    DiaSemana[] v = DiaSemana.values();

    return v[(dia.ordinal() + 1) % v.length];
  }

  public int numeroIso(DiaSemana dia) {
    return dia.ordinal() + 1;
  }
}
