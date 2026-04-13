package com.ejemplo.repository;

import com.ejemplo.model.Proveedor;
import java.util.List;

public interface IProveedorRepository {
    boolean create(Proveedor proveedor);
    List<Proveedor> findAll();
    Proveedor findById(Long id);
    boolean update(Proveedor proveedor);
    boolean deleteById(Long id);
}
