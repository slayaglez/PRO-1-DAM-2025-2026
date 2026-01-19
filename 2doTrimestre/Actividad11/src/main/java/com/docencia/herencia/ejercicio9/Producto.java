package com.docencia.herencia.ejercicio9;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Producto {

    private UUID id;
    private String nombre;
    private double precio;

    protected Producto(UUID id, String nombre, double precio) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract String categoria();

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
