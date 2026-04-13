package com.ejemplo.service;

import com.ejemplo.model.Inventario;
import com.ejemplo.repository.IInventarioRepository;
import java.util.ArrayList;
import java.util.List;

public class InventarioService {

    private IInventarioRepository repository;

    public InventarioService(IInventarioRepository repository) {
        this.repository = repository;
    }

    public boolean crear(Inventario entity) {
        if (!validar(entity) || repository.findById(entity.getId()) != null) {
            return false;
        }
        return repository.create(entity);
    }

    public Inventario buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Inventario> listarTodos() {
        return repository.findAll();
    }

    public boolean actualizar(Inventario entity) {
        if (!validar(entity) || repository.findById(entity.getId()) == null) {
            return false;
        }
        return repository.update(entity);
    }

    public boolean eliminar(Long id) {
        return repository.deleteById(id);
    }

    private boolean validar(Inventario entity) {
        return entity != null && entity.getId() != null && entity.getProductoId() != null && entity.getProveedorId() != null && entity.getStockDisponible() >= 0 && entity.getStockMinimo() >= 0;
    }


    public List<Inventario> buscarPorUbicacion(String ubicacion) {
        List<Inventario> resultado = new ArrayList<>();
        for (Inventario item : repository.findAll()) {
            if (item.getUbicacion() != null && item.getUbicacion().equalsIgnoreCase(ubicacion)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public List<Inventario> stockBajo() {
        List<Inventario> resultado = new ArrayList<>();
        for (Inventario item : repository.findAll()) {
            if (item.getStockDisponible() < item.getStockMinimo()) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public int calcularStockTotal() {
        int total = 0;
        for (Inventario item : repository.findAll()) {
            total += item.getStockDisponible();
        }
        return total;
    }

}
