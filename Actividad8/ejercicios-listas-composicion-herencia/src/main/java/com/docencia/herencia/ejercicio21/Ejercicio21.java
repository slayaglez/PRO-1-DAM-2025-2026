package com.docencia.herencia.ejercicio21;

/**
 * Ejercicio 21 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí la jerarquía de clases, clases base abstractas,
 * subclases concretas y métodos polimórficos correspondientes
 * al enunciado.
 */
public class Ejercicio21 {
    
    public static void main(String[] args) {
        Circulo circulo = new Circulo(2);

        System.out.println(circulo.area());

        Triangulo triangulo = new Triangulo(10, 8);
        System.out.println(triangulo.area());

        Figura cuadrado = new Figura(4, 4);
        System.out.println(cuadrado.area());

        Figura rectangulo = new Figura(4, 8);
        System.out.println(rectangulo.area());
    }
}
