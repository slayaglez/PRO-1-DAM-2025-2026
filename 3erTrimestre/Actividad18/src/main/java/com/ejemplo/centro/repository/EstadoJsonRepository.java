package com.ejemplo.centro.repository;

import java.util.List;

import com.ejemplo.centro.model.Evaluacion;
import com.ejemplo.centro.model.Incidencia;

public interface EstadoJsonRepository {

    /**
     * Guarda una evaluacion en el JSON
     * @param evaluacion evaluacion
     */
    void saveEvaluacion(Evaluacion evaluacion);

    /**
     * Devuelve todas las evaluaciones
     * @return Lista de Evaluacion
     */
    List<Evaluacion> findAllEvaluaciones();

    /**
     * Devuelve todas las evaluaciones por el Id de su modulo
     * @param moduloId ID modulo
     * @return Lista Evaluacion
     */
    List<Evaluacion> findEvaluacionesByModuloId(String moduloId);

    /**
     * Guarda incidencia en JSON
     * @param incidencia Incidencia
     */
    void saveIncidencia(Incidencia incidencia);

    /**
     * Devuelve todas las incidencias
     * @return Lista incidencia
     */
    List<Incidencia> findAllIncidencias();

    /**
     * Busca incidencia por el id de su profesor
     * @param profesorId ID profesor
     * @return Lista Incidencia
     */
    List<Incidencia> findIncidenciasByProfesorId(String profesorId);
}
