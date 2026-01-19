package com.docencia.herencia.ejercicio7;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Dispositivo {

    private UUID id;
    private String fabricante;

    protected Dispositivo(UUID id, String fabricante) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.fabricante = fabricante;
    }

    public UUID getId() { return id; }
    public String getFabricante() { return fabricante; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract String tipo();

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
