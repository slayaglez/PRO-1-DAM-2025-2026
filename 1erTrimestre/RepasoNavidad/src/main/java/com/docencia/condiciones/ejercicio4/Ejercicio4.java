package com.docencia.condiciones.ejercicio4;

public class Ejercicio4 {
    /**
     * Con if/else: <4 gratis (0), 4-17 5.0, 18-64 10.0, >=65 6.0.
     */
    public static double precioEntrada(int edad) {
        
        if (edad < 4) {
            return 0.0;
        }
        else if(edad >= 4 && edad <= 17){
            return 5.0;
        }
        else if(edad >= 18 && edad <= 64){
            return 10.0;
        }
        else if(edad >= 65){
            return 6.0;
        }
        throw new UnsupportedOperationException("No implementado");
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio4 listo para implementar.");
    }
}
