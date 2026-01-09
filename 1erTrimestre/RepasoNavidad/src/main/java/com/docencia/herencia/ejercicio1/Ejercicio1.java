package com.docencia.herencia.ejercicio1;


import java.util.List;


/**
 * Ejercicio 1
 *
 * Clase lanzadora (opcional) y contenedor de métodos del enunciado.
 */

public class Ejercicio1 {

    private Ejercicio1() {
    }

    public static void main(String[] args) {
        // Puedes ejecutar aquí pruebas manuales rápidas si lo deseas.
    }


public static class Circulo extends Figura {
        private final double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public double area() {
            return 3.14159 * radio * radio;
        }
    }

    public static class Rectangulo extends Figura {
        private final double ancho;
        private final double alto;

        public Rectangulo(double ancho, double alto) {
            this.ancho = ancho;
            this.alto = alto;
        }

        @Override
        public double area() {
            return ancho * alto;
        }
    }

    public static double areaTotal(List<Figura> figuras) {
        // TODO: sumar áreas de todas las figuras no nulas.
        float area = 0;
        if(figuras != null){
            for (int i = 0; i < figuras.size(); i++) {
                if(figuras.get(i) != null){
                    area += figuras.get(i).area();
                }
            }
        }
        return area;
    }

}
