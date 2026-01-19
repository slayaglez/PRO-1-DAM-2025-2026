package com.docencia.sets.ejercicio10;

import com.docencia.herencia.ejercicio10.Documento;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Documento} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoDocumentos {

    private final Set<Documento> set = new HashSet<>();

    /** Anad... un elemento a la coleccion. */
    public void anadir(Documento elemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Busca por id. */
public Documento buscarPorId(UUID id) {
    throw new UnsupportedOperationException("El metodo no esta implementado");
}

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Documento nuevoElemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Documento> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
    private void validar(Documento elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El documento no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getTitulo() == null || elemento.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El titulo no puede ser nulo o en blanco");
        }
    }

}
