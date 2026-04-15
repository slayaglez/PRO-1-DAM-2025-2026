package com.ejemplo.repository;

import com.ejemplo.model.LineaPedido;
import java.util.List;

public interface ILineaPedidoRepository {
    boolean create(LineaPedido lineaPedido);
    List<LineaPedido> findAll();
    LineaPedido findById(Long id);
    boolean update(LineaPedido lineaPedido);
    boolean deleteById(Long id);
}
