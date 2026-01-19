package com.docencia.listas.ejercicio3;

import com.docencia.herencia.ejercicio3.Empleado;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

/**
 * Gestiona una lista de {@link Empleado} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten empleados con nombre nulo o en blanco.
 * - No se permiten salarios base negativos.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaEmpleados {

    private final List<Empleado> empleados = new ArrayList<>();

    public void anadir(Empleado empleado) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public Empleado buscarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public boolean eliminarPorId(UUID id) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public void modificar(UUID id, Empleado nuevoEmpleado) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public List<Empleado> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    private boolean existeId(UUID id) {
        return empleados.stream().anyMatch(e -> e.getId().equals(id));
    }

    private void validar(Empleado empleado) {
        if (empleado == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        if (empleado.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (empleado.getNombre() == null || empleado.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
        if (empleado.getSalarioBase() < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }
    }
}
