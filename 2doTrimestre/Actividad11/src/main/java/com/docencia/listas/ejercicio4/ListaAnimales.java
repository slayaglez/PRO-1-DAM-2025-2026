package com.docencia.listas.ejercicio4;

import com.docencia.herencia.ejercicio4.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Animal} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten animales con nombre nulo o en blanco.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaAnimales {

    private final List<Animal> animales = new ArrayList<>();

    public void anadir(Animal animal) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public Animal buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public void modificar(UUID id, Animal nuevoAnimal) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public List<Animal> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    private boolean existeId(UUID id) {
        return animales.stream().anyMatch(a -> a.getId().equals(id));
    }

    private void validar(Animal animal) {
        if (animal == null) {
            throw new IllegalArgumentException("El animal no puede ser nulo");
        }
        if (animal.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (animal.getNombre() == null || animal.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
    }
}
