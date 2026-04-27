package com.ejemplo.service;

import com.ejemplo.model.*;

public interface IClienteService {
    /**
     * Crea un cliente
     * @param cliente cliente
     * @return boolean
     */
    boolean create(Cliente cliente);

    /**
     * Busca por Id
     * @param dni identificador
     * @return Cliente
     */
    Cliente findByDni(String dni);

    /**
     * Busca todos los clientes
     * @return List Cliente
     */
    java.util.List<Cliente> findAll();

    /**
     * Actualiza un cliente por su ID
     * @param cliente Cliente
     * @return boolean
     */
    boolean update(Cliente cliente);

    /**
     * Eliminar un usuario por su ID
     * @param dni Identificador
     * @return boolean
     */
    boolean deleteByDni(String dni);

    /**
     * Encuentra los clientes activos
     * @return List Cliente
     */
    java.util.List<Cliente> findActivos();

    /**
     * Encuentra clientes por su ciudad
     * @param ciudad String Ciudad
     * @return List Cliente
     */
    java.util.List<Cliente> findByCiudad(String ciudad);

    /**
     * Encuentra clientes por su email
     * @param email email String
     * @return Cliente
     */
    Cliente findByEmail(String email);
}
