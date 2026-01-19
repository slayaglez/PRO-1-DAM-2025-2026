package com.docencia.sets.ejercicio5;

import com.docencia.herencia.ejercicio5.Figura;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Figura} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoFiguras {

    private final Set<Figura> set = new HashSet<>();

    /** Anad... un elemento a la coleccion. */
    public void anadir(Figura elemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Busca por id. */
public Figura buscarPorId(UUID id) {
    throw new UnsupportedOperationException("El metodo no esta implementado");
}

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Figura nuevoElemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Figura> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
    private void validar(Figura elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("La figura no puede ser nula");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getColor() == null || elemento.getColor().isBlank()) {
            throw new IllegalArgumentException("El color no puede ser nulo o en blanco");
        }
    }

}
