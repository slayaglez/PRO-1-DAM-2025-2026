/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */

package com.docencia.sets.ejercicio3;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import com.docencia.herencia.ejercicio3.Empleado;

/**
 * Gestiona un conjunto de {@link Empleado} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del
 * ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoEmpleados {

    private final Set<Empleado> set = new HashSet<>();

    /** Anad... un elemento a la coleccion. */
    public void anadir(Empleado elemento) {
        validar(elemento);
        if (set.contains(elemento)) {
            throw new IllegalArgumentException("ellemento ya existe");
        }
        set.add(elemento);
    }

    /** Busca por id. */
    public Empleado buscarPorId(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException();
        }
        for (Empleado empleado : set) {
            if (empleado.getId().equals(id)) {
                return empleado;
            }
        }
        return null;
    }

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        return set.removeIf(elemento -> elemento.getId().equals(id));
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Empleado nuevoElemento) {
        validar(nuevoElemento);
        Empleado existente = buscarPorId(id);
        if(existente == null){
            throw new NoSuchElementException("No existe tal elemento");
        }
        if(!existente.equals(nuevoElemento)){
            throw new IllegalArgumentException("El id no puede ser distinto");
        }
        set.add(nuevoElemento);
    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Empleado> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
    }

    private void validar(Empleado elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El empleado no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getNombre() == null || elemento.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
        if (elemento.getSalarioBase() < 0) {
            throw new IllegalArgumentException("El salario base no puede ser negativo");
        }
    }

}
