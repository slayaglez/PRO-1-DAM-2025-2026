package com.ejemplo.repository;

import com.ejemplo.model.Producto;
import java.util.List;

public interface IProductoRepository {
    boolean create(Producto producto);
    List<Producto> findAll();
    Producto findById(Long id);
    boolean update(Producto producto);
    boolean deleteById(Long id);
}
