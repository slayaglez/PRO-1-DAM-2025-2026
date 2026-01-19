package com.docencia.interfaces.ejercicio1;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Pagable.
 */
public class Nomina implements Pagable {

    private UUID id;
    private double bruto;
    private double retencion;

    public Nomina(UUID id, double bruto, double retencion) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public double getBruto() { return bruto; }
    public double getRetencion() { return retencion; }

    @Override
    public double total() {
        return bruto - (bruto * retencion);
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
