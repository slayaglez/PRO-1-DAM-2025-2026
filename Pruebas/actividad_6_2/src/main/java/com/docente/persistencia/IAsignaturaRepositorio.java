package com.docente.persistencia;

import java.util.List;
import com.docente.modelo.Asignatura;

public interface IAsignaturaRepositorio {
    /**
     * Obtiene todas las asignaturas
     * @return Lista de asignaturas
     */
    List<Asignatura> obtenerAsignaturas();

    /**
     * Guarda todas las asignaturas
     * @param asignaturas Lista de asignaturas
     * @return true / false
     */
    boolean guardarAsignaturas(List<Asignatura> asignaturas);
}
