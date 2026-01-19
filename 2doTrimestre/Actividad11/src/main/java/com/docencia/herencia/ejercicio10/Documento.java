package com.docencia.herencia.ejercicio10;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Documento {

    private UUID id;
    private String titulo;

    protected Documento(UUID id, String titulo) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.titulo = titulo;
    }

    public UUID getId() { return id; }
    public String getTitulo() { return titulo; }

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
