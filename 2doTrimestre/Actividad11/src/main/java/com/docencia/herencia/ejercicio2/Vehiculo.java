package com.docencia.herencia.ejercicio2;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Vehiculo {

    private UUID id;
    private String marca;
    private String modelo;

    protected Vehiculo(UUID id, String marca, String modelo) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.marca = marca;
        this.modelo = modelo;
    }

    public UUID getId() { return id; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract int ruedas();

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
