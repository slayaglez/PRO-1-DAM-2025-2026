/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con Peliculas
 */
package com.docencia.clases.ejercicio7;

import java.util.Objects;

public class Pelicula {
    private String codigo;
    private String titulo;
    private int duracionMin;

    /**
     * Constructor vacio
     */
    public Pelicula() {}

    /**
     * Constructor con identificador unico
     * @param codigo identificador unico
     */
    public Pelicula(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Constructor con identificador unico
     * @param codigo identificador unico
     */
    public Pelicula(String codigo, String titulo, int duracionMin) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.duracionMin = duracionMin;
    }

    /** Getters y Setters */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pelicula other = (Pelicula) obj;
        return Objects.equals(codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Pelicula [codigo=" + codigo + ", titulo=" + titulo + ", duracionMin=" + duracionMin + "]";
    }

}
