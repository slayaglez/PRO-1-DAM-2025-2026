package com.docencia.interfaces.ejercicio10;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Drawable.
 */
public class CirculoDrawable implements Drawable {

    private UUID id;
    private double radio;
    private String color;

    public CirculoDrawable(UUID id, double radio, String color) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public double getRadio() { return radio; }
    public String getColor() { return color; }

    @Override
    public String dibujar() {
        return "Circulo r=" + radio;
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
