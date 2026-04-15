package com.ejemplo.service;

import com.ejemplo.model.Proveedor;
import com.ejemplo.repository.IProveedorRepository;
import java.util.ArrayList;
import java.util.List;

public class ProveedorService {

    private IProveedorRepository repository;

    public ProveedorService(IProveedorRepository repository) {
        this.repository = repository;
    }

    public boolean crear(Proveedor entity) {
        if (!validar(entity) || repository.findById(entity.getId()) != null) {
            return false;
        }
        return repository.create(entity);
    }

    public Proveedor buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Proveedor> listarTodos() {
        return repository.findAll();
    }

    public boolean actualizar(Proveedor entity) {
        if (!validar(entity) || repository.findById(entity.getId()) == null) {
            return false;
        }
        return repository.update(entity);
    }

    public boolean eliminar(Long id) {
        return repository.deleteById(id);
    }

    private boolean validar(Proveedor entity) {
        return entity != null && entity.getId() != null && entity.getNombre() != null && !entity.getNombre().trim().isEmpty();
    }


    public List<Proveedor> buscarPorPais(String pais) {
        List<Proveedor> resultado = new ArrayList<>();
        for (Proveedor item : repository.findAll()) {
            if (item.getPais() != null && item.getPais().equalsIgnoreCase(pais)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

}
