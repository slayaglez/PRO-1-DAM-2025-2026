package com.docencia.condiciones.ejercicio2;

public class Ejercicio2 {
    /**
     * Usa switch: 1=Lunes ... 7=Domingo. Si no es válido devuelve "ERROR".
     */
    public static String nombreDia(int dia) {

        return switch(dia) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            case 4 -> "Jueves";
            case 5 -> "Viernes";
            case 6 -> "Sábado";
            case 7 -> "Domingo";
            default -> "ERROR";
        };
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio2 listo para implementar.");
    }
}
