package com.docencia.interfaces.ejercicio1;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Pagable.
 */
public class Factura implements Pagable {

    private UUID id;
    private double base;
    private double iva;

    public Factura(UUID id, double base, double iva) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public double getBase() { return base; }
    public double getIva() { return iva; }

    @Override
    public double total() {
        return base + (base * iva);
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
