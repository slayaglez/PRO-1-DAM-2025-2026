package com.docencia.herencia.ejercicio5;

import java.util.UUID;

public class Rectangulo extends Figura {

    private double ancho;
    private double alto;

    public Rectangulo(UUID id, String color, double ancho, double alto) {
        super(id, color);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public double getAncho() { return ancho; }
    public double getAlto() { return alto; }

    @Override
    public double area() {
        return getAncho() * getAlto();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
