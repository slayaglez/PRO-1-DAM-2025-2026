package com.ejemplo.repository;

import com.ejemplo.model.Cliente;
import java.util.List;

public interface IClienteRepository {
    boolean create(Cliente cliente);
    List<Cliente> findAll();
    Cliente findById(Long id);
    boolean update(Cliente cliente);
    boolean deleteById(Long id);
}
