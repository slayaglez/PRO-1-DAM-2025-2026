package com.ejemplo.repository;

import java.util.List;

import com.ejemplo.model.*;

public interface IClienteRepository {

    boolean create(Cliente cliente);
    List<Cliente> findAll();
    Cliente findByDni(String dni);
    boolean update(Cliente cliente);
    boolean deleteByDni(String dni);

    /**
     * Encuentra los clientes activos
     * @return List Cliente
     */
    java.util.List<Cliente> findActive();

    /**
     * Encuentra clientes por su ciudad
     * @param ciudad String Ciudad
     * @return List Cliente
     */
    java.util.List<Cliente> findByCity(String ciudad);

    /**
     * Encuentra clientes por su email
     * @param email email String
     * @return Cliente
     */
    Cliente findByMail(String email);
}
