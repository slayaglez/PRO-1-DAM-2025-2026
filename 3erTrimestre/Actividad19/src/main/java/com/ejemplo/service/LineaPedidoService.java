package com.ejemplo.service;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.repository.ILineaPedidoRepository;
import java.util.ArrayList;
import java.util.List;

public class LineaPedidoService {

    private ILineaPedidoRepository repository;

    public LineaPedidoService(ILineaPedidoRepository repository) {
        this.repository = repository;
    }

    public boolean crear(LineaPedido entity) {
        if (!validar(entity) || repository.findById(entity.getId()) != null) {
            return false;
        }
        return repository.create(entity);
    }

    public LineaPedido buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<LineaPedido> listarTodos() {
        return repository.findAll();
    }

    public boolean actualizar(LineaPedido entity) {
        if (!validar(entity) || repository.findById(entity.getId()) == null) {
            return false;
        }
        return repository.update(entity);
    }

    public boolean eliminar(Long id) {
        return repository.deleteById(id);
    }

    private boolean validar(LineaPedido entity) {
        return entity != null && entity.getId() != null && entity.getPedidoId() != null && entity.getProductoId() != null && entity.getCantidad() >= 0 && entity.getPrecioUnitario() >= 0 && entity.getSubtotal() >= 0;
    }


    public List<LineaPedido> listarPorPedido(Long pedidoId) {
        List<LineaPedido> resultado = new ArrayList<>();
        for (LineaPedido item : repository.findAll()) {
            if (item.getPedidoId().equals(pedidoId)) {
                resultado.add(item);
            }
        }
        return resultado;
    }

    public double calcularFacturacionTotal() {
        double total = 0.0;
        for (LineaPedido item : repository.findAll()) {
            total += item.getSubtotal();
        }
        return total;
    }

    public int calcularCantidadTotalVendida() {
        int total = 0;
        for (LineaPedido item : repository.findAll()) {
            total += item.getCantidad();
        }
        return total;
    }

}
