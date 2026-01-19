package com.docencia.listas.ejercicio6;

import com.docencia.herencia.ejercicio6.CuentaBancaria;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link CuentaBancaria} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten cuentas con titular nulo o en blanco.
 * - No se permiten saldos negativos.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaCuentasBancarias {

    private final List<CuentaBancaria> cuentas = new ArrayList<>();

    public void anadir(CuentaBancaria cuenta) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public CuentaBancaria buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public void modificar(UUID id, CuentaBancaria nuevaCuenta) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public List<CuentaBancaria> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    private boolean existeId(UUID id) {
        return cuentas.stream().anyMatch(c -> c.getId().equals(id));
    }

    private void validar(CuentaBancaria cuenta) {
        if (cuenta == null) {
            throw new IllegalArgumentException("La cuenta no puede ser nula");
        }
        if (cuenta.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (cuenta.getTitular() == null || cuenta.getTitular().isBlank()) {
            throw new IllegalArgumentException("El titular no puede ser nulo o en blanco");
        }
        if (cuenta.getSaldo() < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo");
        }
    }
}
