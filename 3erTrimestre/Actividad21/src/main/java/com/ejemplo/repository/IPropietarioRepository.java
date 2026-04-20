package com.ejemplo.repository;

import com.ejemplo.model.Propietario;
import java.util.List;

public interface IPropietarioRepository {
    /**
     * Crea un nuevo propietario en la base de datos.
     * @param propietario propietario a crear
     * @return true si se creo correctamente,
     */
    boolean create(Propietario propietario);
    List<Propietario> findAll();
    Propietario findById(String dni);
    boolean update(Propietario propietario);
    boolean deleteById(String dni);
}
