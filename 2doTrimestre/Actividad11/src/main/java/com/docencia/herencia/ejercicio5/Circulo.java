package com.docencia.herencia.ejercicio5;

import java.util.UUID;

public class Circulo extends Figura {

    private double radio;

    public Circulo(UUID id, String color, double radio) {
        super(id, color);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public double getRadio() { return radio; }

    @Override
    public double area() {
        return Math.PI * getRadio() * getRadio();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
