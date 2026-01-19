package com.docencia.maps.ejercicio6;

import com.docencia.herencia.ejercicio6.CuentaBancaria;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona un mapa de {@link CuentaBancaria} usando internamente {@link HashMap}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class MapaCuentasBancarias {
    private final Map<UUID, CuentaBancaria> index = new HashMap<>();

    /** Anad... un elemento a la coleccion. */
    public void anadir(CuentaBancaria elemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Busca por id. */
    public CuentaBancaria buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, CuentaBancaria nuevoElemento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    /** Devuelve una copia inmutable del conjunto. */
    public java.util.Set<CuentaBancaria> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
    private void validar(CuentaBancaria elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getTitular() == null || elemento.getTitular().isBlank()) {
            throw new IllegalArgumentException("El titular no puede ser nulo o en blanco");
        }
        if (elemento.getSaldo() < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
    }

}
