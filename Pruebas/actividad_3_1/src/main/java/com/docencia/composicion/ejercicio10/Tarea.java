/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase tarea que tiene una descripcion y si esta completada o no
 */
package com.docencia.composicion.ejercicio10;

import java.util.Objects;

public class Tarea {
    private final String descripcion;
    private boolean completada;

    /**
     * Constructor por defecto
     * @param descripcion descripcion de la tarea
     */
    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarCompletada() {
        this.completada = true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarea other = (Tarea) obj;
        return Objects.equals(descripcion, other.descripcion);
    }

    
}
