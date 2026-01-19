package com.docencia.herencia.ejercicio5;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Figura {

    private UUID id;
    private String color;

    protected Figura(UUID id, String color) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.color = color;
    }

    public UUID getId() { return id; }
    public String getColor() { return color; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract double area();

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
