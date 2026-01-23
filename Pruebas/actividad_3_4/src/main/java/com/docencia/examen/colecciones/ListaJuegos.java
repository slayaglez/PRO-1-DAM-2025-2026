/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase con herencias e interfaces que trabaja con distintos
 * juegos de mesa y arcade.
 */
package com.docencia.examen.colecciones;

import java.util.ArrayList;
import java.util.List;

import com.docencia.examen.herencia.Juego;

public class ListaJuegos {

    private final List<Juego> juegos = new ArrayList<>();

    /**
     * Agrega un juego a la lista
     * @param juego Juego
     * @return true / false
     */
    public boolean crearJuego(Juego juego) {
        if (validarJuego(juego)) {
            juegos.add(juego);
            return true;
        }
        return false;
    }

    /**
     * Busca un juego por su id
     * @param id id
     * @return true / false
     */
    public Juego buscarId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id no puede ser nulo");
        }
        for (Juego juego : juegos) {
            if (juego.getId().equals(id)) {
                return juego;
            }
        }
        return null;
    }

    /**
     * Busca un juego por su totalidad
     * @param juego Juego
     * @return el Juego de la lista
     */
    public Juego buscarJuego(Juego juego) {
        validarJuego(juego);
        for (Juego elemento : juegos) {
            if (elemento.equals(juego)) {
                return elemento;
            }
        }
        buscarId(juego.getId());
        return null;
    }

    /**
     * Actualiza un juego
     * @param juego el juego a actualizar
     * @return true / false
     */
    public boolean actualizarJuego(Juego juego) {
        validarJuego(juego);
        Juego existente = buscarJuego(juego);
        if(existente == null){
            return false;
        }
        if(!existente.equals(juego)){
            throw new IllegalArgumentException("No puede cambiar el id");
        }
        int indice = juegos.indexOf(existente);
        juegos.set(indice, juego);
        return true;
    }

    /**
     * Elimina un juego por su ID
     * @param id identificador
     * @return true / false
     */
    public boolean eliminarId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id no puede ser nulo");
        }
        return juegos.removeIf(juego -> juego.getId().equals(id));
    }

    /**
     * Comprueba si el juego existe o no
     * @param id identificador
     * @return true / false
     */
    public boolean existeJuego(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Id no puede ser nulo");
        }
        Juego juego = buscarId(id);
        return juego.getId().equals(id);
    }

    /**
     * Calcula el precio total de cierto tipo de juego
     * @param tipo el tipo de juego
     * @return el total
     */
    public double calcularPrecio(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Id no puede ser nulo");
        }
        double precio = 0;
        for (Juego juego : juegos) {
            if(juego.tipoJuego().equals(tipo)){
                precio += juego.precio();
            }
        }
        return precio;
    }

    /**
     * Calcula el precio total de todos los juegos
     * @return precio total
     */
    public double calcularPrecioTotal() {
        double precioTotal=0;
        for (Juego juego : juegos) {
            precioTotal += juego.precio();
        }
        return precioTotal;
    }

    /**
     * Devuelve el numero de juego del tipo dado
     * @param tipo tipo de juego
     * @return numero total
     */
    public int contarPorTipo(String tipo) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException("Id no puede ser nulo");
        }
        int numeroJuegos = 0;
        for (Juego juego : juegos) {
            if(juego.tipoJuego().equals(tipo)){
                numeroJuegos++;
            }
        }
        return numeroJuegos;
    }

    /**
     * Valida si un juego es valido o no
     * @param juego el juego a validar
     * @return true / false
     */
    public boolean validarJuego(Juego juego) {
        if (juegos.contains(juego)){
            return false;
        }
        if (juego == null) {
            throw new IllegalArgumentException("El juego no puede ser nulo");
        }
        if (juego.getId() == null) {
            throw new IllegalArgumentException("El id no puede ser nulo");
        }

        return true;
    }

    /**
     * Cuenta cuantos juegos hay
     * @return numero de juegos totales
     */
    public int contar() {
        return juegos.size();
    }

    /**
     * Crea una copia de la lista inmutable
     * @return copia de la lista inmutable
     */
    public List<Juego> listar() {
        return List.copyOf(juegos);
    }
}
