/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con Tareas
 */
package com.docencia.composicion.ejercicio1;


import java.util.ArrayList;
import java.util.List;


public class ListaTareas {
    private final List<Tarea> tareas = new ArrayList<>();

    /**
     * Aniade una tarea a la lista de tareas
     * @param descripcion descripcion de la tarea
     */
    public void anadirTarea(String descripcion) {
        if(descripcion == null || descripcion.isBlank()){
            return;
        }
        tareas.add(new Tarea(descripcion));
    }

    /**
     * Marca como completada una tarea
     * @param descripcion descripcion de la tarea
     * @return si se pudo añadir o no la tarea
     */
    public boolean marcarComoCompletada(String descripcion) {
        for (int i = 0; i < tareas.size(); i++) {
            if(tareas.get(i).getDescripcion().equals(descripcion)){
                tareas.get(i).marcarCompletada();
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene las tareas pendientes
     * @return Lista de tareas pedientes
     */
    public List<Tarea> obtenerPendientes() {
        
        List<Tarea> tareasPendientes = new ArrayList<>();
        for (int i = 0; i < tareas.size(); i++) {
            if(tareas.get(i).isCompletada() == false){
                tareasPendientes.add(tareas.get(i));
            }
        }

        return tareasPendientes;
    }
}
