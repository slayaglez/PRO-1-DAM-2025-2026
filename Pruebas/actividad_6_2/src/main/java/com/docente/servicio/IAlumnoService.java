package com.docente.servicio;

import java.util.List;

import com.docente.modelo.Alumno;

public interface IAlumnoService {

    /**
     * Lee los alumnos
     * @return lista String
     */
    public List<String> read();

    /**
     * crea alumnos
     * @param identificador id alumno
     * @param nombre nombre alumno
     * @param edad edad
     * @param curso curso alumno
     * @return true / false
     */
    public boolean crearAlumno(String identificador, String nombre, int edad, String curso);

    /**
     * crea alumnos
     * @param identificador id alumno
     * @param nombre nombre alumno
     * @param edad edad
     * @param curso curso alumno
     * @return true / false
     */
    public boolean actualizarAlumno(String identificador, String nombre, int edad, String curso);

    /**
     * Elimina alumnos
     * @param indentificador id alumno
     * @return true / false
     */
    public boolean deleteAlumno(String indentificador);

    /**
     * Busca un alumno por su id
     * @param identificador
     * @return el alumno
     */
    public Alumno buscarAlumno(String identificador);

}
