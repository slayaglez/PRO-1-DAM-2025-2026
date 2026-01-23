/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.maps.ejercicio4;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;

import com.docencia.herencia.ejercicio4.Animal;

/**
 * Gestiona un mapa de {@link Animal} usando internamente {@link HashMap}.
 *
 * Reglas:
 * - No se permiten elementos nulos.
 * - No se permiten elementos con campos "vacios" segun la validacion del ejercicio.
 * - No se permiten ids nulos ni duplicados.
 */
public class MapaAnimales {
    private final Map<UUID, Animal> index = new HashMap<>();

    /** Anad... un elemento a la coleccion. */
    public void anadir(Animal elemento) {
        validar(elemento);
        if(index.containsValue(elemento)){
            throw new IllegalArgumentException("Ya existe");
        }
        index.put(elemento.getId(), elemento);
    }

    /** Busca por id. */
    public Animal buscarPorId(UUID id) {
        if(id == null){
            throw new IllegalArgumentException("id nulo");
        }
        return index.get(id);
    }
    /** Elimina por id. */
    public boolean eliminarPorId(UUID id) {
        return index.remove(id) != null;
    }

    /** Reemplaza el elemento con ese id por otro (mismo id). */
    public void modificar(UUID id, Animal nuevoElemento) {
        validar(nuevoElemento);
        Animal elemento = buscarPorId(id);
        if(elemento == null){
            throw new NoSuchElementException("me copié de sebas");
        }
        if(!elemento.equals(nuevoElemento)){
            throw new IllegalArgumentException();
        }
        index.replace(id, nuevoElemento);
    }

    /** Devuelve una copia inmutable del conjunto. */
    public java.util.Set<Animal> listar() {
        return Set.copyOf(index.values());
    }

    public int tamanio() {
        return index.size();
    }
    
    private void validar(Animal elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El animal no puede ser nulo");
        }
        if (elemento.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }
        if (elemento.getNombre() == null || elemento.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o en blanco");
        }
    }

}
