package com.docencia.interfaces.ejercicio2;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Volador.
 */
public class Avion implements Volador {

    private UUID id;
    private String modelo;
    private int motores;

    public Avion(UUID id, String modelo, int motores) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getModelo() { return modelo; }
    public int getMotores() { return motores; }

    @Override
    public int altitudMaxima() {
        return 12000;
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
