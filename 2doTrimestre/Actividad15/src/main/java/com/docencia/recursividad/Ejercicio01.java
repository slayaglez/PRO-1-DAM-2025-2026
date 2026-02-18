package com.docencia.recursividad;

public class Ejercicio01 {
  
  public static long factorial(int n) { //! EJERCICIO DE EXAMEN
    if(n < 0){
      throw new IllegalArgumentException();
    }
    if(n == 1) {
      return 1;
    }
    return n*factorial(n-1);
  }

  public static void main(String[] args) {
    System.out.println(factorial(4));
  }
}
