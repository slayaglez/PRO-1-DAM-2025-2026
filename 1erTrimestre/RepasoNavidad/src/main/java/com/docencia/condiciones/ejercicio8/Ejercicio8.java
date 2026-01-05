package com.docencia.condiciones.ejercicio8;

public class Ejercicio8 {
    /**
     * Usa switch por zona: 1=5€/kg, 2=7€/kg, 3=10€/kg. Si zona inválida lanza IllegalArgumentException.
     */
    public static double costeEnvio(double pesoKg, int zona) {
        switch(zona){
            case 1: return 5*pesoKg;
            case 2: return 7*pesoKg;
            case 3: return 10*pesoKg;
            default: throw new IllegalArgumentException("Entrada inválida");
        }
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio8 listo para implementar.");
    }
}
