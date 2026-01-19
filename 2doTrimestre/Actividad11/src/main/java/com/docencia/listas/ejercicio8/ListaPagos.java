package com.docencia.listas.ejercicio8;

import com.docencia.herencia.ejercicio8.Pago;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Pago} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten pagos con importe menor o igual a cero.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaPagos {

    private final List<Pago> pagos = new ArrayList<>();

    public void anadir(Pago pago) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public Pago buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public void modificar(UUID id, Pago nuevoPago) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public List<Pago> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    private boolean existeId(UUID id) {
        return pagos.stream().anyMatch(p -> p.getId().equals(id));
    }

    private void validar(Pago pago) {
        if (pago == null) {
            throw new IllegalArgumentException("El pago no puede ser nulo");
        }
        if (pago.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (pago.getImporte() <= 0) {
            throw new IllegalArgumentException("El importe debe ser mayor que cero");
        }
    }
}
