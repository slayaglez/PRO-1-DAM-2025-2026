package com.ejemplo.service;

import com.ejemplo.model.Propietario;
import java.util.List;

/**
 * API de servicios para la gestion de propietarios.
 */
public interface IPropietarioService {

    boolean crear(Propietario propietario);

    Propietario buscarPorDni(String dni);

    List<Propietario> listarTodos();

    boolean actualizar(Propietario propietario);

    boolean eliminar(String dni);

    List<Propietario> listarActivos();

    List<Propietario> buscarPorCiudad(String ciudad);

    int contarActivos();
}
