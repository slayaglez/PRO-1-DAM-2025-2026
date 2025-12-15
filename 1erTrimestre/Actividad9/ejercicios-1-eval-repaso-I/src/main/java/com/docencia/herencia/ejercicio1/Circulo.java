package com.docencia.herencia.ejercicio1;

/**
 * Círculo definido por su radio.
 */
public class Circulo extends Figura {
    private final double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double area() {
        // TODO: implementar fórmula del área del círculo: PI * radio * radio.
        return 0.0;
    }
}
