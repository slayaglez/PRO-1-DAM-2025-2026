/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */

package com.docencia.sets.ejercicio2;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import com.docencia.herencia.ejercicio2.Vehiculo;

/**
 * Gestiona un conjunto de {@link Vehiculo} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del
 * ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoVehiculos {

    private final Set<Vehiculo> set = new HashSet<>();

    /** Anad... un elemento a la coleccion. */
    public void anadir(Vehiculo elemento) {
        validar(elemento);
        if (set.contains(elemento)) {
            throw new IllegalArgumentException("ellemento ya existe");
        }
        set.add(elemento);
    }

    /** Busca por id. */
    public Vehiculo buscarPorId(UUID id) {
        if(id == null){
            throw new IllegalArgumentException();
        }
        for (Vehiculo vehiculo : set) {
            if(vehiculo.getId().equals(id)){
                return vehiculo;
            }
        }
        return null;
    }

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        return set.removeIf(elemento -> elemento.getId().equals(id));
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Vehiculo nuevoElemento) {
        validar(nuevoElemento);
        Vehiculo existente = buscarPorId(id);
        if(existente == null){
            throw new NoSuchElementException("No existe tal elemento");
        }
        if(!existente.equals(nuevoElemento)){
            throw new IllegalArgumentException("El id no puede ser distinto");
        }
        set.add(nuevoElemento);
    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Vehiculo> listar() {
        return Set.copyOf(set);
    }

    public int tamanio() {
        return set.size();
    }

    private void validar(Vehiculo elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El vehiculo no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getMarca() == null || elemento.getMarca().isBlank()) {
            throw new IllegalArgumentException("La marca no puede ser nula o en blanco");
        }
        if (elemento.getModelo() == null || elemento.getModelo().isBlank()) {
            throw new IllegalArgumentException("El modelo no puede ser nulo o en blanco");
        }
    }

}
