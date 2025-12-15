package com.docencia.herencia.ejercicio21;

/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Un programa de clases y herencias que trabaja calculando areas
 * de figuras geométricas.
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
