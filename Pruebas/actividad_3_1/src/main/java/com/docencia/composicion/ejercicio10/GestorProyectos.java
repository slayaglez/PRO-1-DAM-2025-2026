/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase Gestor de proyectos 
 */
package com.docencia.composicion.ejercicio10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestorProyectos {
    private final List<Proyecto> proyectos = new ArrayList<>();

    public Proyecto crearProyecto(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return null;
        }

        Proyecto p = new Proyecto(nombre.trim());
        proyectos.add(p);
        return p;
    }


    /**
     * Anade una tarea al proyecto
     * @param nombreProyecto nombre del proyecto
     * @param descripcionTarea descripcion de la tarea
     * @return si se pudo anadir o no
     */
    public boolean anadirTareaAProyecto(String nombreProyecto, String descripcionTarea) {
        if (nombreProyecto == null || descripcionTarea == null || nombreProyecto.isBlank()
                || descripcionTarea.isBlank()) {
            return false;
        }

        Tarea tarea = new Tarea(descripcionTarea);
   
        for (int i = 0; i < proyectos.size(); i++) {

            String nombreP = proyectos.get(i).getNombre().toLowerCase().trim();
            if (nombreP.equals(nombreProyecto.trim().toLowerCase())) {
                proyectos.get(i).anadirTarea(tarea);
                return true;
            }
        }
        return false;
    }

    /**
     * Cuenta tareas sin completar
     * @param nombreProyecto nombre del proyecto
     * @return numero de tareas
     */
    public int contarTareasPendientes(String nombreProyecto) {
        if(nombreProyecto == null){
            return 0;
        }
        
        int contador=0;

        for (int i = 0; i < proyectos.size(); i++) {
            if(proyectos.get(i).getNombre().toLowerCase().trim().equals(nombreProyecto.toLowerCase().trim())){
                for (int j = 0; j < proyectos.get(i).getTareas().size(); j++) {
                    Tarea tarea = proyectos.get(i).getTareas().get(j);
                    if(!(tarea.isCompletada())){
                        contador++;
                    }
                }
            }
        }
        return contador;
    }


    public List<Proyecto> getProyectos() {
        return new ArrayList<>(proyectos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proyectos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GestorProyectos other = (GestorProyectos) obj;
        return Objects.equals(proyectos, other.proyectos);
    }

    
}
