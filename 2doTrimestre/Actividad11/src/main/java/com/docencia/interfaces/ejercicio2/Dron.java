package com.docencia.interfaces.ejercicio2;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Volador.
 */
public class Dron implements Volador {

    private UUID id;
    private String marca;
    private int bateriaMinutos;

    public Dron(UUID id, String marca, int bateriaMinutos) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getMarca() { return marca; }
    public int getBateriaMinutos() { return bateriaMinutos; }

    @Override
    public int altitudMaxima() {
        return 500;
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
