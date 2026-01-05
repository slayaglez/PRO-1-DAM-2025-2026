package com.docencia.condiciones.ejercicio3;

public class Ejercicio3 {
    /**
     * Usa switch con '+','-','*','/'. En división entera. Si op no válido lanza IllegalArgumentException.
     */
    public static int calculadora(int a, int b, char op) {
        
        switch(op){
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            case '/': return a/b;
            default: throw new IllegalArgumentException();
        }
        
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio3 listo para implementar.");
    }
}
