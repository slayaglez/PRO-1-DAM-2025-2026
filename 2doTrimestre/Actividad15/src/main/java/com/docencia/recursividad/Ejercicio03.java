package com.docencia.recursividad;

public class Ejercicio03 {
  public static long sumaHastaN(int n) {
    if(n < 0){
      throw new IllegalArgumentException();
    }
    if(n == 1){
      return 1;
    }

    return n + sumaHastaN(n-1);
  }
  public static void main(String[] args) {
    System.out.println(sumaHastaN(5));
  }
}
