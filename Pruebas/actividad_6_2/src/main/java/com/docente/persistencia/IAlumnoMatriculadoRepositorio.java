package com.docente.persistencia;

import java.util.List;
import com.docente.modelo.AlumnoMatriculado;

public interface IAlumnoMatriculadoRepositorio {
    /**
     * Obtiene todos los alumnos matriculados
     * @return Lista de los alumnos matriculados
     */
    List<AlumnoMatriculado> obtenerAlumnosMatriculados();
    /**
     * Guarda los alumnos matriculados
     * @param alumnosMatriculados Lista de alumnos matriculados
     * @return true / false
     */
    boolean guardarAlumnosMatriculados(List<AlumnoMatriculado> alumnosMatriculados);
}
