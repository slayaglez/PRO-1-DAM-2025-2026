package com.docencia.interfaces.ejercicio4;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Reproducible.
 */
public class Podcast implements Reproducible {

    private UUID id;
    private String nombre;
    private int episodio;

    public Podcast(UUID id, String nombre, int episodio) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEpisodio() { return episodio; }

    @Override
    public String reproducir() {
        return "Reproduciendo podcast: " + nombre + " #" + episodio;
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
