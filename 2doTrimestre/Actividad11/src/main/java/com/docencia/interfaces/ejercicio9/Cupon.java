package com.docencia.interfaces.ejercicio9;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Descontable.
 */
public class Cupon implements Descontable {

    private UUID id;
    private double importe;
    private String codigo;

    public Cupon(UUID id, double importe, String codigo) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public double getImporte() { return importe; }
    public String getCodigo() { return codigo; }

    @Override
    public double aplicarDescuento(double precio) {
        return Math.max(0.0, precio - importe);
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
