package com.docencia.condiciones.ejercicio5;

public class Ejercicio5 {
    /**
     * Devuelve true si el año es bisiesto.
     */
    public static boolean esBisiesto(int anio) {
        return anio % 4 == 0 && anio % 100 != 0 || anio % 400 == 0 && anio % 100 == 0;
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio5 listo para implementar.");
    }
}
