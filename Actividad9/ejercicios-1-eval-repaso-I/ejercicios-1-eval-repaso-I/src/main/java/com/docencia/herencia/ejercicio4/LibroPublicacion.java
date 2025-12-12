package com.docencia.herencia.ejercicio4;

/**
 * Libro: se considera reciente si tiene 5 años o menos.
 */
public class LibroPublicacion extends Publicacion {

    public LibroPublicacion(String titulo, int anioPublicacion) {
        super(titulo, anioPublicacion);
    }

    @Override
    public boolean esReciente(int anioActual) {
        // TODO: reciente si tiene 5 años o menos.
        return false;
    }
}
