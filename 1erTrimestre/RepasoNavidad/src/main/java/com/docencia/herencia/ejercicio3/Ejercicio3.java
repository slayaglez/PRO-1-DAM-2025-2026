package com.docencia.herencia.ejercicio3;


import java.util.List;


/**
 * Ejercicio 3
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio3 {

    private Ejercicio3() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


public static class Perro extends Animal {
        public Perro(String nombre) {
            super(nombre);
        }

        @Override
        public String sonido() {
            return "guau";
        }
    }

    public static class Gato extends Animal {
        public Gato(String nombre) {
            super(nombre);
        }

        @Override
        public String sonido() {
            return "miau";
        }
    }

    public static String concatenarSonidos(List<Animal> animales) {
        if(animales == null || animales.isEmpty()){
            return "";
        }
        String sonidos = animales.get(0).sonido();
        for (int i = 1; i < animales.size(); i++) {
            if(animales.get(i) != null){
                sonidos += " "+animales.get(i).sonido();
            }
        }
        return sonidos;
    }

}
