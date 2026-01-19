package com.docencia.listas.ejercicio2;

import com.docencia.herencia.ejercicio2.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Vehiculo} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten vehiculos con marca/modelo nulos o en blanco.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaVehiculos {

    private final List<Vehiculo> vehiculos = new ArrayList<>();

    public void anadir(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public Vehiculo buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public void modificar(UUID id, Vehiculo nuevoVehiculo) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public List<Vehiculo> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    private boolean existeId(UUID id) {
        return vehiculos.stream().anyMatch(v -> v.getId().equals(id));
    }

    private void validar(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehiculo no puede ser nulo");
        }
        if (vehiculo.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (vehiculo.getMarca() == null || vehiculo.getMarca().isBlank()) {
            throw new IllegalArgumentException("La marca no puede ser nula o en blanco");
        }
        if (vehiculo.getModelo() == null || vehiculo.getModelo().isBlank()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o en blanco");
        }
    }
}
