package com.docencia.condiciones.ejercicio1;

public class Ejercicio1 {
    /**
     * Devuelve "SUSPENSO", "APROBADO", "NOTABLE" o "SOBRESALIENTE" según la nota (0-10).
     */
    public static String clasificarNota(int nota) {

        return switch (nota) {
            case 0, 1, 2, 3, 4 -> "SUSPENSO";
            case 5, 6 -> "APROBADO";
            case 7, 8 -> "NOTABLE";
            case 9, 10 -> "SOBRESALIENTE";
            default -> "";
        };
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio1 listo para implementar.");
    }
}
