package com.docencia.logica;

public class Ejercicio02 {
  
  public static long potencia(long base, int exponente) {
    if(base == 0){
      return 0;
    }
    if(exponente == 0){
      return 1;
    }

    long resultado = 1;
    for (int i = 0; i < exponente; i++) {
      resultado *= base;
    }
    return resultado;
  }

  public static void main(String[] args) {
    System.out.println(potencia(2, 3));
  }
}
