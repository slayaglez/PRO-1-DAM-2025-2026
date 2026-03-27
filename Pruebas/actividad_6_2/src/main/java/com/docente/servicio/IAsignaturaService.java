package com.docente.servicio;

import java.util.List;
import com.docente.modelo.Asignatura;

public interface IAsignaturaService {
    /**
     * lee las asignaturas
     * @return lista asignaturas
     */
    List<String> read();

    /**
     * Crea asignaturas 
     * @param codigo codigo asig
     * @param nombre nombre asignatura
     * @param horasSemanales horas semanales por asignatura
     * @return
     */
    boolean crearAsignatura(String codigo, String nombre, int horasSemanales);

    /**
     * actualiza asignaturas
     * @param codigo codigo asignaturas
     * @param nombre nombvre asignatura
     * @param horasSemanales horas semanales
     * @return true / false
     */
    boolean actualizarAsignatura(String codigo, String nombre, int horasSemanales);

    /**
     * borra una asignatura
     * @param codigo codigo asignatura
     * @return true / false
     */
    boolean deleteAsignatura(String codigo);

    /**
     * busca una asignatura
     * @param codigo codigo asignatura
     * @return la asignatura
     */
    Asignatura buscarAsignatura(String codigo);
}
