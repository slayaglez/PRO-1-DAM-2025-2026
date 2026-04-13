package com.ejemplo.repository;

import com.ejemplo.model.Inventario;
import java.util.List;

public interface IInventarioRepository {
    boolean create(Inventario inventario);
    List<Inventario> findAll();
    Inventario findById(Long id);
    boolean update(Inventario inventario);
    boolean deleteById(Long id);
}
