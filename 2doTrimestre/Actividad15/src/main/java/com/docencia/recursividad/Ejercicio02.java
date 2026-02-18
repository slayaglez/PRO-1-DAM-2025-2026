package com.docencia.recursividad;

public class Ejercicio02 {
  public static long potencia(long base, int exponente) {
    if(base == 0){
      return 0;
    }
    if(exponente == 0){
      return 1;
    }

    return base * potencia(base, exponente-1);
  }

  public static void main(String[] args) {
    System.out.println(potencia(2, 4));
  }
}
