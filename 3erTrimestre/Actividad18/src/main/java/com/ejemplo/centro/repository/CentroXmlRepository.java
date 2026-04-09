package com.ejemplo.centro.repository;

import com.ejemplo.centro.model.Modulo;
import com.ejemplo.centro.model.Profesor;
import java.util.List;
import java.util.Optional;

public interface CentroXmlRepository {

    /**
     * Devolver todos los profesores
     * @return Una lista de Profesores
     */
    List<Profesor> findAllProfesores();

    /**
     * Devolver todos los modulos
     * @return Una lista de Modulos
     */
    List<Modulo> findAllModulos();

    /**
     * Encuentra un profesor por ID
     * @param id identificador (P001)
     * @return El Profesor
     */
    Profesor findProfesorById(String id);

    /**
     * Encuentra un modulo por ID
     * @param id identificador (M001)
     * @return El Modulo
     */
    Modulo findModuloById(String id);
}
