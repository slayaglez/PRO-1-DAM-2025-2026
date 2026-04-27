package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.*;
import com.ejemplo.repository.*;
import com.ejemplo.repository.sqlite.*;
import com.ejemplo.validation.ValidationUtils;

public class ClienteService implements IClienteService {
    private final IClienteRepository repository;
    public ClienteService() { this.repository = new ClienteSqliteRepository(); }
    @Override
    public boolean create(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public Cliente findByDni(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByDni'");
    }
    @Override
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    @Override
    public boolean update(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public boolean deleteByDni(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByDni'");
    }
    @Override
    public List<Cliente> findActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findActivos'");
    }
    @Override
    public List<Cliente> findByCiudad(String ciudad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCiudad'");
    }
    @Override
    public Cliente findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

   }
