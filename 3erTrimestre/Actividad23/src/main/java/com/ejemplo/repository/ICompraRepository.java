package com.ejemplo.repository;

import com.ejemplo.model.*;

public interface ICompraRepository {

    /**
     * Crea una compra
     * @param compra Compra
     * @return boolean
     */
    boolean create(Compra compra);

    /**
     * Busca por su id
     * @param id identificador
     * @return Compra
     */
    Compra findById(Integer id);

    /**
     * Busca todas las compras
     * @return Compra List
     */
    java.util.List<Compra> findAll();

    /**
     * Actualiza una compra
     * @param compra compra nueva
     * @return boolean
     */
    boolean update(Compra compra);

    /**
     * Elimina una compra por su id
     * @param id
     * @return
     */
    boolean deleteById(Integer id);

    /**
     * Encuentra compras por su proveedor
     * @param cifProveedor identifiacdor proveedor
     * @return List Compra
     */
    java.util.List<Compra> findByProveedor(String cifProveedor);

    /**
     * Encuentra compras 
     * @param numeroFactura
     * @return
     */
    Compra findByNumeroFactura(String numeroFactura);

    /**
     * Encuentra Detalles de una compra por su id
     * @param idCompra identificador
     * @return Lista compra
     */
    java.util.List<CompraDetalle> findDetallesByCompra(Integer idCompra);
}
