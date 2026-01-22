/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.sets.ejercicio1;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import com.docencia.herencia.ejercicio1.Alumno;
import com.docencia.herencia.ejercicio1.Persona;

/**
 * Gestiona un conjunto de {@link Persona} usando internamente {@link HashSet}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class ConjuntoPersonas {

    private final Set<Persona> set = new HashSet<>();

    /** Anad... un elemento a la coleccion. */
    public void anadir(Persona elemento) {
        validar(elemento);
        if(set.contains(elemento)){
            throw new IllegalArgumentException("Este id ya existe");
        }
        set.add(elemento);
    }

    /** Busca por id. */
public Persona buscarPorId(UUID id) {
    if(id == null){
        throw new IllegalArgumentException("El id no puede ser nulo");
    }
    Persona personaBuscar = new Alumno(id);
    return buscar(personaBuscar);
}

    /** Busca por Persona */
public Persona buscar(Persona personaBuscar) {
    if(personaBuscar == null){
        throw new IllegalArgumentException("La persona no puede ser nula");
    }

    for (Persona persona : set) {
        if(persona.equals(personaBuscar)){
            return persona;
        }
    }
    return null;
}

    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        if(id == null){
            throw new IllegalArgumentException("Id no puede ser nulo");
        }
        return set.removeIf(persona -> persona.getId().equals(id));
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Persona nuevoElemento) {
        
        validar(nuevoElemento);
        Persona existe = buscarPorId(id);
        if(existe == null){
            throw new NoSuchElementException("Id inexistente");
        }
        if(!existe.equals(nuevoElemento)){
            throw new IllegalArgumentException("El id no puede ser igual al de otra Persona");
        }

        set.add(nuevoElemento);
        
    }

    /** Devuelve una copia inmutable del conjunto. */
    public Set<Persona> listar() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    public int tamanio() {
        return set.size();
    }
    private void validar(Persona elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getNombre() == null || elemento.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
        if (elemento.getEdad() < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
    }

}
