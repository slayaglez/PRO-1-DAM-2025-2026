package com.docencia.logica;

public class Ejercicio04 {
  
  public static long fibonacci(int n) {
    
    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }

    long resultado = 0;
    for (int i = 0; i < n; i++) {
      if(i-1 >= 0){
        resultado += (i-2) + (i-1);
      }
    }

    return resultado;
  }

  public static void main(String[] args) {
    System.out.println(fibonacci(7));
  }
  // 0 1 1 2 3 5 8 13
}
