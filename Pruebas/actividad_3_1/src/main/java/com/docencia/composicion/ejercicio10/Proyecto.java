/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase de proyecto con nombre y lista de tareas 
 */
package com.docencia.composicion.ejercicio10;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Proyecto {
    private final String nombre;
    private final List<Tarea> tareas = new ArrayList<>();

    /**
     * Constructor por defecto
     * @param nombre nombre del proyecto
     */
    public Proyecto(String nombre) {
        this.nombre = nombre.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Tarea> getTareas() {
        return new ArrayList<>(tareas);
    }

    void anadirTarea(Tarea t) {
        tareas.add(t);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Proyecto other = (Proyecto) obj;
        return Objects.equals(nombre.toLowerCase().trim(), other.nombre.toLowerCase().trim());
    }

    
}
