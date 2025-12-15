package com.docencia.herencia.ejercicio4;

/**
 * Artículo: se considera reciente si tiene 2 años o menos.
 */
public class ArticuloPublicacion extends Publicacion {

    public ArticuloPublicacion(String titulo, int anioPublicacion) {
        super(titulo, anioPublicacion);
    }

    @Override
    public boolean esReciente(int anioActual) {
        // TODO: reciente si tiene 2 años o menos.
        return false;
    }
}
