package com.ejemplo.repository.sqlite;

import com.ejemplo.model.*;
import com.ejemplo.repository.ICompraRepository;
import java.sql.*;
import java.util.*;

public class CompraSqliteRepository extends SQLiteConnectionManager implements ICompraRepository {

    public CompraSqliteRepository() {
        super();
    }

    @Override
    public boolean create(Compra compra) {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement("INSERT INTO compra VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            sentencia.setInt(1, compra.getId());
            sentencia.setString(2, compra.getFecha());
            sentencia.setString(3, compra.getNumeroFactura());
            sentencia.setString(4, compra.getCifProveedor());
            sentencia.setDouble(5, compra.getSubtotal());
            sentencia.setDouble(6, compra.getIva());
            sentencia.setDouble(7, compra.getTotal());
            sentencia.setString(8, compra.getEstado());
            sentencia.setString(9, compra.getObservaciones());
            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error creando compra" + e);
            return false;
        }
    }

    @Override
    public Compra findById(Integer id) {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM compra WHERE id = ?")) {
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            String fecha = resultado.getString("fecha");
            String numeroFactura = resultado.getString("numero_factura");
            String cifProveedor = resultado.getString("cif_proveedor");
            Double subtotal = resultado.getDouble("subtotal");
            Double iva = resultado.getDouble("iva");
            Double total = resultado.getDouble("total");
            String estado = resultado.getString("estado");
            String observaciones = resultado.getString("observaciones");

            return new Compra(id, fecha, numeroFactura, cifProveedor, subtotal, iva, total, estado, observaciones);

        } catch (Exception e) {
            System.err.println("Error buscando compra" + e);
            return null;
        }
    }

    @Override
    public List<Compra> findAll() {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM compra")) {
            ResultSet resultado = sentencia.executeQuery();
            List<Compra> compras = new ArrayList<>();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String fecha = resultado.getString("fecha");
                String numeroFactura = resultado.getString("numero_factura");
                String cifProveedor = resultado.getString("cif_proveedor");
                Double subtotal = resultado.getDouble("subtotal");
                Double iva = resultado.getDouble("iva");
                Double total = resultado.getDouble("total");
                String estado = resultado.getString("estado");
                String observaciones = resultado.getString("observaciones");

                compras.add(new Compra(id, fecha, numeroFactura, cifProveedor, subtotal, iva, total, estado,
                        observaciones));
            }

            return compras;

        } catch (Exception e) {
            System.err.println("Error buscando compras" + e);
            return null;
        }
    }

    @Override
    public boolean update(Compra compra) {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement("INSERT INTO compra VALUES (?, ?, ?, ?, ?, ?, ?, ?) WHERE id = ?")) {
            sentencia.setInt(9, compra.getId());
            sentencia.setString(1, compra.getFecha());
            sentencia.setString(2, compra.getNumeroFactura());
            sentencia.setString(3, compra.getCifProveedor());
            sentencia.setDouble(4, compra.getSubtotal());
            sentencia.setDouble(5, compra.getIva());
            sentencia.setDouble(6, compra.getTotal());
            sentencia.setString(7, compra.getEstado());
            sentencia.setString(8, compra.getObservaciones());
            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error actualizando compra" + e);
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Connection connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("DELETE FROM compra WHERE id = ?")) {
                sentencia.setInt(1, id);

                return sentencia.executeUpdate() > 0;
            
        } catch (Exception e) {
            System.err.println("Error eliminando compra" + e);
            return false;
        }
    }

    @Override
    public List<Compra> findByProveedor(String cifProveedor) {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM compra WHERE cif_proveedor = ?")) {
                    sentencia.setString(1, cifProveedor);
            ResultSet resultado = sentencia.executeQuery();
            List<Compra> compras = new ArrayList<>();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                String fecha = resultado.getString("fecha");
                String numeroFactura = resultado.getString("numero_factura");
                Double subtotal = resultado.getDouble("subtotal");
                Double iva = resultado.getDouble("iva");
                Double total = resultado.getDouble("total");
                String estado = resultado.getString("estado");
                String observaciones = resultado.getString("observaciones");

                compras.add(new Compra(id, fecha, numeroFactura, cifProveedor, subtotal, iva, total, estado,
                        observaciones));
            }

            return compras;

        } catch (Exception e) {
            System.err.println("Error buscando compras" + e);
            return null;
        }
    }

    @Override
    public Compra findByNumeroFactura(String numeroFactura) {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM compra WHERE numero_factura = ?")) {
            sentencia.setString(1, numeroFactura);
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            Integer id = resultado.getInt("id");
            String fecha = resultado.getString("fecha");
            String cifProveedor = resultado.getString("cif_proveedor");
            Double subtotal = resultado.getDouble("subtotal");
            Double iva = resultado.getDouble("iva");
            Double total = resultado.getDouble("total");
            String estado = resultado.getString("estado");
            String observaciones = resultado.getString("observaciones");

            return new Compra(id, fecha, numeroFactura, cifProveedor, subtotal, iva, total, estado, observaciones);

        } catch (Exception e) {
            System.err.println("Error buscando compra" + e);
            return null;
        }
    }

    @Override
    public List<CompraDetalle> findDetallesByCompra(Integer idCompra) {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM compra_detalle WHERE id_compra = ?")) {
                    sentencia.setInt(1, idCompra);
            ResultSet resultado = sentencia.executeQuery();
            List<CompraDetalle> compras = new ArrayList<>();

            while (resultado.next()) {
                Integer id = resultado.getInt("id");
                Integer idProducto = resultado.getInt("id_producto");
                String numeroFactura = resultado.getString("numero_factura");
                Double cantidad = resultado.getDouble("cantidad");
                Double precioUnitario = resultado.getDouble("precio_unitario");
                Double descuento = resultado.getDouble("descuento");
                Double totalLinea = resultado.getDouble("total_linea");
                
                compras.add(new CompraDetalle(id, idCompra, idProducto, cantidad, precioUnitario, descuento, totalLinea));
            }

            return compras;

        } catch (Exception e) {
            System.err.println("Error buscando compras" + e);
            return null;
        }
    }

}
