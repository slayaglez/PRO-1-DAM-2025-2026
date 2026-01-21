package com.docencia.listas.ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.docencia.herencia.ejercicio1.Alumno;
import com.docencia.herencia.ejercicio1.Persona;

/**
 * Gestiona una lista de {@link Persona} usando {@link java.util.ArrayList}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten personas con nombre nulo o en blanco.
 * - No se permiten ids nulos ni duplicados dentro de la lista.
 */
public class ListaPersonas {

    private final List<Persona> personas = new ArrayList<>();

    /**
     * Anade una persona a la lista.
     *
     * @param persona persona a anadir
     * @throws IllegalArgumentException si persona es nula, tiene campos invalidos o su id ya existe
     */
    public void anadir(Persona persona) {
        validar(persona);
        if(personas.contains(persona)){
            throw new IllegalArgumentException("La Persona ya existe");
        }
        personas.add(persona);
    }

    /** Busca una persona por id. */
    public Persona buscarPorId(UUID id) {
        if(id == null){
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getId().equals(id)){
                return personas.get(i);
            }
        }
        Alumno persona = new Alumno(id);
        int posicion = personas.indexOf(persona);
        if(posicion < 0){
            return null;
        }
        return personas.get(posicion);
    }

    //! Buscar por el objeto y no por el ID SIEMPRE será mejor
    //? Pues si en el futuro la validación cambia de Id a Id+nombre será
    //? más facil cambiarlo de la primera manera

    /** Elimina una persona por id. */
    public boolean eliminarPorId(UUID id) {
        if(id == null){
            throw new IllegalArgumentException();
        }
        return personas.removeIf(persona -> persona.getId().equals(id));
    }

    /**
     * Reemplaza la persona con ese id por otra.
     *
     * @param id id a modificar
     * @param nuevaPersona nueva persona (debe tener el mismo id)
     */
    public void modificar(UUID id, Persona nuevaPersona) {

        validar(nuevaPersona);
        Persona existente = buscarPorId(id);
        if(existente == null){
            throw new NoSuchElementException("No existe persona con ese id");
        }
        if(!existente.equals(nuevaPersona)){
            throw new IllegalArgumentException("El id de la persona no debe ser el mismo");
        }
        int indice = personas.indexOf(existente);
        personas.set(indice, nuevaPersona);

    }

    /** Devuelve una copia inmutable de la lista. */
    public List<Persona> listar() {
        return List.copyOf(personas);
    }

    public int tamanio() {
        return personas.size();
    }

    private boolean existeId(UUID id) {
        return personas.stream().anyMatch(p -> p.getId().equals(id));
    }

    private void validar(Persona persona) {
        if (persona == null) {
            throw new IllegalArgumentException("La persona no puede ser nula");
        }
        if (persona.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (persona.getNombre() == null || persona.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
        if (persona.getEdad() < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
    }
}
