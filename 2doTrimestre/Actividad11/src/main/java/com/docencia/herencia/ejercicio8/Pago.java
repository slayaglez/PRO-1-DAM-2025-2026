package com.docencia.herencia.ejercicio8;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Pago {

    private UUID id;
    private double importe;

    protected Pago(UUID id, double importe) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.importe = importe;
    }

    public UUID getId() { return id; }
    public double getImporte() { return importe; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract boolean requiereValidacion();

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
