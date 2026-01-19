package com.docencia.interfaces.ejercicio4;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Reproducible.
 */
public class Cancion implements Reproducible {

    private UUID id;
    private String titulo;
    private String artista;

    public Cancion(UUID id, String titulo, String artista) {        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public UUID getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }

    @Override
    public String reproducir() {
        return "Reproduciendo cancion: " + titulo;
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
