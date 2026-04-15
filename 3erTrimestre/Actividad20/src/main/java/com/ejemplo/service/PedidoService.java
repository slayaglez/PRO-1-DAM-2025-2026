package com.ejemplo.service;

import com.ejemplo.model.Pedido;
import com.ejemplo.repository.IPedidoRepository;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private IPedidoRepository repository;

    public PedidoService(IPedidoRepository repository) {
        this.repository = repository;
    }

    public boolean crear(Pedido entity) {
        if (!validar(entity) || repository.findById(entity.getId()) != null) {
            return false;
        }
        return repository.create(entity);
    }

    public Pedido buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Pedido> listarTodos() {
        return repository.findAll();
    }

    public boolean actualizar(Pedido entity) {
        if (!validar(entity) || repository.findById(entity.getId()) == null) {
            return false;
        }
        return repository.update(entity);
    }

    public boolean eliminar(Long id) {
        return repository.deleteById(id);
    }

    private boolean validar(Pedido entity) {
        return entity != null && entity.getId() != null && entity.getClienteId() != null && entity.getTotal() >= 0;
    }


    public List<Pedido> listarPorCliente(Long clienteId) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido item : repository.findAll()) {
            if (item.getClienteId().equals(clienteId)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public List<Pedido> listarPorEstado(String estado) {
        List<Pedido> resultado = new ArrayList<>();
        for (Pedido item : repository.findAll()) {
            if (item.getEstado() != null && item.getEstado().equalsIgnoreCase(estado)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public double calcularImporteTotalPedidos() {
        double total = 0.0;
        for (Pedido item : repository.findAll()) {
            total += item.getTotal();
        }
        return total;
    }

    public Pedido obtenerPedidoMayorImporte() {
        Pedido mayor = null;
        for (Pedido item : repository.findAll()) {
            if (mayor == null || item.getTotal() > mayor.getTotal()) {
                mayor = item;
            }
        }
        return mayor;
    }

}
