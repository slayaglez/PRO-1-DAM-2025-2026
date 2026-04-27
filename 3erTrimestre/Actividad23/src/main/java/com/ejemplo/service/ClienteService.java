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
        if (!validarCliente(cliente)) return false;

        return repository.create(cliente);
    }
    @Override
    public Cliente findByDni(String dni) {
        if(dni == null) {
            return null;
        }
        return repository.findByDni(dni);
    }
    @Override
    public List<Cliente> findAll() {
        return repository.findAll();
    }
    @Override
    public boolean update(Cliente cliente) {
        if(!validarCliente(cliente)) return false;

        return repository.update(cliente);
    }
    @Override
    public boolean deleteByDni(String dni) {
        if(dni == null) {
            return false;
        }
        return repository.deleteByDni(dni);
    }
    @Override
    public List<Cliente> findActivos() {
        return repository.findActive();
    }
    @Override
    public List<Cliente> findByCiudad(String ciudad) {
        if(ciudad == null || ciudad.isBlank()){
            return null;
        }
        return repository.findByCity(ciudad);
    }
    @Override
    public Cliente findByEmail(String email) {
        if(email == null || email.isBlank()){
            return null;
        }
        return repository.findByMail(email);
    }

    public boolean validarCliente(Cliente cliente){

        if(cliente == null){
            return false;
        }
        if(cliente.getNombre() == null || cliente.getNombre().isBlank()){
            return false;
        }
        if(cliente.getTelefono() == null || cliente.getTelefono().isBlank()){
            return false;
        }
        if(cliente.getEmail() == null || cliente.getEmail().isBlank()){
            return false;
        }
        if(cliente.getCiudad() == null || cliente.getCiudad().isBlank()){
            return false;
        }
        if(cliente.getActivo() == null || cliente.getNombre().isBlank()){
            return false;
        }

        return true;
    }

   }
