package com.docencia.logica;

public class Ejercicio05 {
  public static int mcd(int a, int b) {

    while(b != 0){
      int resto = a%b;
      a = b;
      b = resto;
    }

    return a;
  }

  public static void main(String[] args) {
    System.out.println(mcd(12, 18));
  }
}
