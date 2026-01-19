package com.docencia.listas.ejercicio9;

import com.docencia.herencia.ejercicio9.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Producto} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten productos con nombre nulo o en blanco.
 * - No se permiten precios negativos.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaProductos {

    private final List<Producto> productos = new ArrayList<>();

    public void anadir(Producto producto) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public Producto buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public void modificar(UUID id, Producto nuevoProducto) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public List<Producto> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    private boolean existeId(UUID id) {
        return productos.stream().anyMatch(p -> p.getId().equals(id));
    }

    private void validar(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        if (producto.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (producto.getNombre() == null || producto.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
        if (producto.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }
}
