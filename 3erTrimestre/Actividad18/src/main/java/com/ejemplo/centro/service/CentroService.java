package com.ejemplo.centro.service;

import com.ejemplo.centro.model.Evaluacion;
import com.ejemplo.centro.model.Incidencia;
import com.ejemplo.centro.model.Modulo;
import com.ejemplo.centro.model.Profesor;
import java.util.List;

public interface CentroService {

    /**
     * Busca profesor por su ID
     * @param profesorId ID
     * @return el Profesor
     */
    Profesor buscarProfesor(String profesorId);

    /**
     * Busca modulo por su ID
     * @param moduloId ID
     * @return el Modulo
     */
    Modulo buscarModulo(String moduloId);

    /**
     * Lista todos los modulos pertenecientes a un profesor
     * @param profesorId El ID del profesor
     * @return Lista de modulos
     */
    List<Modulo> listarModulosDeProfesor(String profesorId);

    
    Evaluacion registrarEvaluacion(String alumno, String moduloId, double nota);
    List<Evaluacion> listarEvaluacionesDeModulo(String moduloId);
    double calcularMediaDeModulo(String moduloId);
    double calcularMediaDeProfesor(String profesorId);
    Incidencia registrarIncidencia(String profesorId, String descripcion, String fecha);
    List<Incidencia> listarIncidenciasDeProfesor(String profesorId);
}
