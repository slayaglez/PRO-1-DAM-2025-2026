package com.docencia.interfaces.ejercicio5;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Medible.
 */
public class SensorTemperatura implements Medible {

    private UUID id;
    private String ubicacion;
    private double celsius;

    public SensorTemperatura(UUID id, String ubicacion, double celsius) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getUbicacion() { return ubicacion; }
    public double getCelsius() { return celsius; }

    @Override
    public double medir() {
        return celsius;
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
