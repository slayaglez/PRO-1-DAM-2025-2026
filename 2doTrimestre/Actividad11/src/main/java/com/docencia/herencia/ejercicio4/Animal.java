package com.docencia.herencia.ejercicio4;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Animal {

    private UUID id;
    private String nombre;

    protected Animal(UUID id, String nombre) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract String sonido();

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
