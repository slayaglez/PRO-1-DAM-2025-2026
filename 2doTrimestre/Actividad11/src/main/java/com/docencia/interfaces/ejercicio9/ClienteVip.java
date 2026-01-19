package com.docencia.interfaces.ejercicio9;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Descontable.
 */
public class ClienteVip implements Descontable {

    private UUID id;
    private double porcentaje;
    private String nivel;

    public ClienteVip(UUID id, double porcentaje, String nivel) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public double getPorcentaje() { return porcentaje; }
    public String getNivel() { return nivel; }

    @Override
    public double aplicarDescuento(double precio) {
        return precio - (precio * porcentaje);
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
