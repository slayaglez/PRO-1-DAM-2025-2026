package com.docencia.herencia.ejercicio25;

/**
 * Ejercicio 25 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí la jerarquía de clases, clases base abstractas,
 * subclases concretas y métodos polimórficos correspondientes
 * al enunciado.
 */
public class Ejercicio25 {
    
    public static void main(String[] args) {

        Animal shaggy = new Animal("mamifero");
        Perro scooby = new Perro("mamifero", "canino");
        Gato misifu = new Gato("mamifero", "felino");
        Vaca queRie = new Vaca("mamifero", "bovino");

        System.out.println(shaggy.hacerSonido());
        System.out.println(scooby.hacerSonido());
        System.out.println(misifu.hacerSonido());
        System.out.println(queRie.hacerSonido());

    }
    
}
