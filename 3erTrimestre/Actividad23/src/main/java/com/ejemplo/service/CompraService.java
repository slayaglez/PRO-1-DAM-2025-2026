package com.ejemplo.service;

import java.util.List;

import com.ejemplo.model.*;
import com.ejemplo.repository.*;
import com.ejemplo.repository.sqlite.*;
import com.ejemplo.validation.ValidationUtils;

public class CompraService implements ICompraService {
    private final ICompraRepository repository;
    public CompraService() { this.repository = new CompraSqliteRepository(); }
    @Override
    public boolean create(Compra compra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public Compra findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Override
    public List<Compra> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    @Override
    public boolean update(Compra compra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public boolean deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    @Override
    public List<Compra> findByProveedor(String cifProveedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByProveedor'");
    }
    @Override
    public Compra findByNumeroFactura(String numeroFactura) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNumeroFactura'");
    }
    @Override
    public List<CompraDetalle> findDetallesByCompra(Integer idCompra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findDetallesByCompra'");
    }

    }
