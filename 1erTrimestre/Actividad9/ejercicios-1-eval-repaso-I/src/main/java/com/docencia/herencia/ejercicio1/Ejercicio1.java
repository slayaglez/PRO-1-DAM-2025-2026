package com.docencia.herencia.ejercicio1;

import java.util.List;

/**
 * HERENCIA – Ejercicio 1: Figuras geométricas.
 *
 * - Implementa el cálculo del área para cada tipo de figura.
 * - Implementa el método areaTotal para sumar el área de una lista de figuras.
 *
 * Esta clase incluye un main opcional para pruebas manuales.
 */
public class Ejercicio1 {

    private Ejercicio1() {
    }

    public static void main(String[] args) {
        Figura c = new Circulo(1.0);
        Figura r = new Rectangulo(2.0, 3.0);

        double total = areaTotal(List.of(c, r));
        System.out.println("Área total = " + total);
    }

    public static double areaTotal(List<Figura> figuras) {
        // TODO: sumar áreas de todas las figuras no nulas.
        return 0.0;
    }
}
