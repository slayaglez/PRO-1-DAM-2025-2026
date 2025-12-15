package com.docencia.herencia.ejercicio3;

import java.util.List;

/**
 * HERENCIA – Ejercicio 3: Animales y sonidos.
 *
 * Implementa los sonidos de perro y gato, y concatena los sonidos de una lista.
 * Esta clase incluye un main opcional para pruebas manuales.
 */
public class Ejercicio3 {

    private Ejercicio3() {
    }

    public static void main(String[] args) {
        Animal a1 = new Perro("Bobby");
        Animal a2 = new Gato("Misi");

        String sonidos = concatenarSonidos(List.of(a1, a2));
        System.out.println(sonidos);
    }

    public static String concatenarSonidos(List<Animal> animales) {
        // TODO: concatenar sonidos separados por espacio, ignorando animales null.
        return "";
    }
}
