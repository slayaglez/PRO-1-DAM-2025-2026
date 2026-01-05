package com.docencia.condiciones.ejercicio10;

public class Ejercicio10 {
    /**
     * Usa switch sobre color ("ROJO","AMARILLO","VERDE"). Devuelve "PARAR","PRECAUCION","AVANZAR". Si otro, "ERROR".
     */
    public static String accionSemaforo(String color) {
        switch(color){
            case "ROJO": return "PARAR";
            case "AMARILLO": return "PRECAUCION";
            case "VERDE": return "AVANZAR";
            default: return "ERROR";
        }
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio10 listo para implementar.");
    }
}
