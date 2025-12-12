package com.docencia.composicion.ejercicio1;
import java.util.ArrayList;
import java.util.List;


public class ListaTareas {
    private final List<Tarea> tareas = new ArrayList<>();

    
    public void anadirTarea(String descripcion) {
        if(descripcion == null || descripcion.isBlank()){
            return;
        }
        tareas.add(new Tarea(descripcion));
    }

    
    public boolean marcarComoCompletada(String descripcion) {
        if(descripcion == null || descripcion.isBlank()){
            return false;
        }

        for (int i = 0; i < tareas.size(); i++) {
            if(tareas.get(i).getDescripcion().strip().toLowerCase().equals(descripcion)){
                tareas.get(i).marcarCompletada();
                return true;
            }
        }
        return false;
    }

    
    public List<Tarea> obtenerPendientes() {
        List<Tarea> resultado = new ArrayList<>();
        for (Tarea tarea : tareas){
            if(!tarea.isCompletada()){
                resultado.add(tarea);
            }
        }
        return resultado;
    }
}
