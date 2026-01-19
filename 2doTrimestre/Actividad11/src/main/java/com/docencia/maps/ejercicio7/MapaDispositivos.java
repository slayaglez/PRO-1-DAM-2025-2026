package com.docencia.maps.ejercicio7;

import com.docencia.herencia.ejercicio7.Dispositivo;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona un mapa de {@link Dispositivo} usando internamente {@link HashMap}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class MapaDispositivos {
    private final Map<UUID, Dispositivo> index = new HashMap<>();

    /** Anad... un elemento a la coleccion. */
    public void anadir(Dispositivo elemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Busca por id. */
    public Dispositivo buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Dispositivo nuevoElemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Devuelve una copia inmutable del conjunto. */
    public java.util.Set<Dispositivo> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
    private void validar(Dispositivo elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El dispositivo no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getFabricante() == null || elemento.getFabricante().isBlank()) {
            throw new IllegalArgumentException("El fabricante no puede ser nulo o en blanco");
        }
    }

}
