package com.docencia.listas.ejercicio5;

import com.docencia.herencia.ejercicio5.Figura;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Figura} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten figuras con color nulo o en blanco.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaFiguras {

    private final List<Figura> figuras = new ArrayList<>();

    public void anadir(Figura figura) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public Figura buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public void modificar(UUID id, Figura nuevaFigura) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public List<Figura> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    private boolean existeId(UUID id) {
        return figuras.stream().anyMatch(f -> f.getId().equals(id));
    }

    private void validar(Figura figura) {
        if (figura == null) {
            throw new IllegalArgumentException("La figura no puede ser nula");
        }
        if (figura.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (figura.getColor() == null || figura.getColor().isBlank()) {
            throw new IllegalArgumentException("El color no puede ser nulo o en blanco");
        }
    }
}
