package com.ejemplo.centro.service;

import java.util.List;

import com.ejemplo.centro.model.Evaluacion;
import com.ejemplo.centro.model.Incidencia;
import com.ejemplo.centro.model.Modulo;
import com.ejemplo.centro.model.Profesor;

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

    /**
     * Metodo que registra un alumno
     * @param alumno El Alumno
     * @param moduloId ID del modulo
     * @param nota nota del alumno en el modulo
     * @return Evaluacion
     */
    Evaluacion registrarEvaluacion(String alumno, String moduloId, double nota);

    /**
     * Lista evaluacion de modulo
     * @param moduloId ID del modulo
     * @return Lista Evaluacion
     */
    List<Evaluacion> listarEvaluacionesDeModulo(String moduloId);

    /**
     * Calcular media por el id del modulo
     * @param moduloId ID del modulo
     * @return media double
     */
    double calcularMediaDeModulo(String moduloId);

    /**
     * Devuelve la media id del profesor
     * @param profesorId ID profesor
     * @return media double
     */
    double calcularMediaDeProfesor(String profesorId);

    /**
     * Registra una incidencia
     * @param profesorId ID profesor
     * @param descripcion descripcion de la incidencia
     * @param fecha fecha incidencia String
     * @return Incidencia
     */
    Incidencia registrarIncidencia(String profesorId, String descripcion, String fecha);

    /**
     * Lista incidencias por profesor dado el ID
     * @param profesorId ID profesor
     * @return Lista de Incidencias
     */
    List<Incidencia> listarIncidenciasDeProfesor(String profesorId);
}
