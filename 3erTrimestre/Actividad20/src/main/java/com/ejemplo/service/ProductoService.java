package com.ejemplo.service;

import com.ejemplo.model.Producto;
import com.ejemplo.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {

    private IProductoRepository repository;

    public ProductoService(IProductoRepository repository) {
        this.repository = repository;
    }

    public boolean crear(Producto entity) {
        if (!validar(entity) || repository.findById(entity.getId()) != null) {
            return false;
        }
        return repository.create(entity);
    }

    public Producto buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Producto> listarTodos() {
        return repository.findAll();
    }

    public boolean actualizar(Producto entity) {
        if (!validar(entity) || repository.findById(entity.getId()) == null) {
            return false;
        }
        return repository.update(entity);
    }

    public boolean eliminar(Long id) {
        return repository.deleteById(id);
    }

    private boolean validar(Producto entity) {
        return entity != null && entity.getId() != null && entity.getNombre() != null && !entity.getNombre().trim().isEmpty() && entity.getPrecio() >= 0 && entity.getStock() >= 0;
    }


    public List<Producto> listarActivos() {
        List<Producto> resultado = new ArrayList<>();
        for (Producto item : repository.findAll()) {
            if (item.isActivo()) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public List<Producto> buscarPorCategoria(String categoria) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto item : repository.findAll()) {
            if (item.getCategoria() != null && item.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public List<Producto> stockBajo(int minimo) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto item : repository.findAll()) {
            if (item.getStock() < minimo) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public double calcularPrecioMedio() {
        List<Producto> items = repository.findAll();
        if (items.isEmpty()) {
            return 0.0;
        }
        double suma = 0.0;
        for (Producto item : items) {
            suma += item.getPrecio();
        }
        return suma / items.size();
    }

    public double calcularValorTotalStock() {
        double total = 0.0;
        for (Producto item : repository.findAll()) {
            total += item.getPrecio() * item.getStock();
        }
        return total;
    }

    public int calcularStockTotal() {
        int total = 0;
        for (Producto item : repository.findAll()) {
            total += item.getStock();
        }
        return total;
    }

}
