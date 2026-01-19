package com.docencia.sets.ejercicio8;

import com.docencia.herencia.ejercicio8.Pago;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

/**
 * Gestiona un conjunto de {@link Pago} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoPagos {

    private final Set<Pago> set = new HashSet<>();

    /** Anad... un elemento a la coleccion. */
    public void anadir(Pago elemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Busca por id. */
public Pago buscarPorId(UUID id) {
    throw new UnsupportedOperationException("El metodo no esta implementado");
}

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Pago nuevoElemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Pago> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
    private void validar(Pago elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El pago no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getImporte() <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que cero");
        }
    }

}
