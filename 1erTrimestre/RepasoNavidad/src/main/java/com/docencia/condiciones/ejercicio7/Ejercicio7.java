package com.docencia.condiciones.ejercicio7;

public class Ejercicio7 {
    /**
     * Usa switch o if: devuelve true si c es vocal (a,e,i,o,u) en mayúscula o minúscula.
     */
    public static boolean esVocal(char c) {
        // TODO: implementar usando condiciones (if/else) y/o switch según se indica
        String letra = String.valueOf(c);
        letra = letra.toLowerCase();
        c = letra.charAt(0);

        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Ejercicio7 listo para implementar.");
    }
}
