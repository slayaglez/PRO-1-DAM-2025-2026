package com.docencia.listas.ejercicio10;

import com.docencia.herencia.ejercicio10.Documento;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Documento} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten documentos con titulo nulo o en blanco.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaDocumentos {

    private final List<Documento> documentos = new ArrayList<>();

    public void anadir(Documento documento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public Documento buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public void modificar(UUID id, Documento nuevoDocumento) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public List<Documento> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    private boolean existeId(UUID id) {
        return documentos.stream().anyMatch(d -> d.getId().equals(id));
    }

    private void validar(Documento documento) {
        if (documento == null) {
            throw new IllegalArgumentException("El documento no puede ser nulo");
        }
        if (documento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (documento.getTitulo() == null || documento.getTitulo().isBlank()) {
            throw new IllegalArgumentException("El titulo no puede ser nulo o en blanco");
        }
    }
}
