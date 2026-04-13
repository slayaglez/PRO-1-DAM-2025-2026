package com.ejemplo.repository;

import com.ejemplo.model.Pedido;
import java.util.List;

public interface IPedidoRepository {
    boolean create(Pedido pedido);
    List<Pedido> findAll();
    Pedido findById(Long id);
    boolean update(Pedido pedido);
    boolean deleteById(Long id);
}
