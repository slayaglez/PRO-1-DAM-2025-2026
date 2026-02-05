/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase con herencias e interfaces que trabaja con distintos
 * juegos de mesa y arcade.
 */
package com.docencia.examen.herencia;

import java.util.Objects;

public abstract class Juego {

    protected String id;
    protected String titulo;
    protected double complemento; // porcentaje (0..100)

    /**
     * Constructor vacio
     */
    protected Juego() {}

    /**
     * Constructor por defecto
     * @param id identificador
     * @param titulo titulo del juego
     * @param complemento porcentaje del precio base extra
     */
    protected Juego(String id, String titulo, double complemento) {
        if(id == null || id.isBlank() || titulo == null || titulo.isBlank() || complemento > 100 || complemento < 0){
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.titulo = titulo;
        this.complemento = complemento;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getComplement() {
        return complemento;
    }

    /**
     * Metodo que devuelve el tipo de juego
     */
    public abstract String tipoJuego();

    /**
     * Metodo que devuelve el precio mas su complemento
     */
    public abstract double precio();

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;

        if (this == obj)
            return true;
        
        if (getClass() != obj.getClass())
            return false;
        Juego other = (Juego) obj;
        return Objects.equals(id, other.id);
    }

    
}