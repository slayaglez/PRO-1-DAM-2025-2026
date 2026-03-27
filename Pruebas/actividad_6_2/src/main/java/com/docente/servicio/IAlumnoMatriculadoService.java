package com.docente.servicio;

import java.util.List;
import com.docente.modelo.AlumnoMatriculado;

public interface IAlumnoMatriculadoService {
    /**
     * Lee alumnos matriculados
     * @return lista String
     */
    List<String> read();
    /**
     * Crea alumnos matriculados
     * @param identificador id alumno
     * @param nombre nombre alumno
     * @param edad edad
     * @param curso curso alumno
     * @return true / false
     */
    boolean crearAlumnoMatriculado(String identificador, String nombre, int edad, String curso);

    /**
     * Actualiza alumnos matriculados
     * @param identificador id alumno
     * @param nombre nombre alumno
     * @param edad edad
     * @param curso curso alumno
     * @return true / false
     */
    boolean actualizarAlumnoMatriculado(String identificador, String nombre, int edad, String curso);
    
    /**
     * Elimina alumnos matriculados
     * @param identificador id alumno
     * @return true / false
     */
    boolean deleteAlumnoMatriculado(String identificador);

    /**
     * Busca alumnos matriculados
     * @param identificador id alumno
     * @return El alumno
     */
    AlumnoMatriculado buscarAlumnoMatriculado(String identificador);

    /**
     * Matricula una asignatura en un alumno
     * @param identificadorAlumno id alumno
     * @param codigoAsignatura codigo asignatura
     * @return true / false
     */
    boolean matricularAsignatura(String identificadorAlumno, String codigoAsignatura);

    /**
     * Elimina una asignatura del alumno
     * @param identificadorAlumno id alumno
     * @param codigoAsignatura id asignatura
     * @return true / false
     */
    boolean desmatricularAsignatura(String identificadorAlumno, String codigoAsignatura);

    /**
     * Devuelve las asignatura matriculadas por alumno
     * @param identificadorAlumno id alumno
     * @return numero int
     */
    int getNumeroAsignaturas(String identificadorAlumno);

    /**
     * Devuelve si un alumno esta matriculado o no en cierta asignatura
     * @param identificadorAlumno id alumno
     * @param codigoAsignatura asignatura
     * @return
     */
    boolean estaMatriculadoEn(String identificadorAlumno, String codigoAsignatura);
}
