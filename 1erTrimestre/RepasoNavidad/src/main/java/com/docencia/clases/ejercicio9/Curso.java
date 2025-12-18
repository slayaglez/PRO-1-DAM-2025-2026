/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con Cursos
 */
package com.docencia.clases.ejercicio9;

import java.util.Objects;

public class Curso {
    private String codigo;
    private String nombre;
    private int creditos;

    /**
     * Constructor vacio
     */
    public Curso() {}

    /**
     * Constructor con identificador unico
     * @param codigo
     */
    public Curso(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Constructor por defecto
     * @param codigo id unico
     * @param nombre nombre del curso
     * @param creditos creditos que otorga
     */
    public Curso(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    /** Getters y Setters */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
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
        Curso other = (Curso) obj;
        return Objects.equals(codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", creditos=" + creditos + "]";
    }

    
}
