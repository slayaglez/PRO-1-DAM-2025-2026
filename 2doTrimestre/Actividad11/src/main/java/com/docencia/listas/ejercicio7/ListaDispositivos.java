package com.docencia.listas.ejercicio7;

import com.docencia.herencia.ejercicio7.Dispositivo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Dispositivo} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten dispositivos con fabricante nulo o en blanco.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaDispositivos {

    private final List<Dispositivo> dispositivos = new ArrayList<>();

    public void anadir(Dispositivo dispositivo) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public Dispositivo buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public void modificar(UUID id, Dispositivo nuevoDispositivo) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public List<Dispositivo> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    private boolean existeId(UUID id) {
        return dispositivos.stream().anyMatch(d -> d.getId().equals(id));
    }

    private void validar(Dispositivo dispositivo) {
        if (dispositivo == null) {
            throw new IllegalArgumentException("El dispositivo no puede ser nulo");
        }
        if (dispositivo.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (dispositivo.getFabricante() == null || dispositivo.getFabricante().isBlank()) {
            throw new IllegalArgumentException("El fabricante no puede ser nulo o en blanco");
        }
    }
}
