package com.ejemplo.service;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {

    private IClienteRepository repository;

    public ClienteService(IClienteRepository repository) {
        this.repository = repository;
    }

    public boolean crear(Cliente entity) {
        if (!validar(entity) || repository.findById(entity.getId()) != null) {
            return false;
        }
        return repository.create(entity);
    }

    public Cliente buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Cliente> listarTodos() {
        return repository.findAll();
    }

    public boolean actualizar(Cliente entity) {
        if (!validar(entity) || repository.findById(entity.getId()) == null) {
            return false;
        }
        return repository.update(entity);
    }

    public boolean eliminar(Long id) {
        return repository.deleteById(id);
    }

    private boolean validar(Cliente entity) {
        return entity != null && entity.getId() != null && entity.getNombre() != null && !entity.getNombre().trim().isEmpty();
    }


    public List<Cliente> listarActivos() {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente item : repository.findAll()) {
            if (item.isActivo()) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public List<Cliente> buscarPorPais(String pais) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente item : repository.findAll()) {
            if (item.getPais() != null && item.getPais().equalsIgnoreCase(pais)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public int contarActivos() {
        return listarActivos().size();
    }

}
