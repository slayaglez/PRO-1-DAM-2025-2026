package com.docencia.herencia.ejercicio4;

/**
 * Publicación con título y año de publicación.
 */
public abstract class Publicacion {
    private final String titulo;
    private final int anioPublicacion;

    protected Publicacion(String titulo, int anioPublicacion) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public abstract boolean esReciente(int anioActual);
}
