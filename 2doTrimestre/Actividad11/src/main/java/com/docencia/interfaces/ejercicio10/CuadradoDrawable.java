package com.docencia.interfaces.ejercicio10;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Drawable.
 */
public class CuadradoDrawable implements Drawable {

    private UUID id;
    private double lado;
    private String color;

    public CuadradoDrawable(UUID id, double lado, String color) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public double getLado() { return lado; }
    public String getColor() { return color; }

    @Override
    public String dibujar() {
        return "Cuadrado l=" + lado;
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
