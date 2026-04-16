package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Inventario;
import com.ejemplo.repository.IInventarioRepository;

public class InventarioSqliteRepository extends SQLiteConnectionManager implements IInventarioRepository {

    public InventarioSqliteRepository(String rutaDB) {
        super(rutaDB);
    }

    public InventarioSqliteRepository() {
        super(rutaDB);
    }

    @Override
    public boolean create(Inventario inventario) {
        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(
                    "INSERT INTO inventario VALUES (?, ?, ?, ?, ?, ?, ?);");
            sentencia.setLong(1, inventario.getId());
            sentencia.setLong(2, inventario.getProductoId());
            sentencia.setLong(3, inventario.getProveedorId());
            sentencia.setString(4, inventario.getUbicacion());
            sentencia.setInt(5, inventario.getStockDisponible());
            sentencia.setInt(6, inventario.getStockMinimo());
            sentencia.setString(7, inventario.getFechaActualizacion());
            sentencia.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("No se pudo almacenar el Inventario: " + inventario.getId());
            return false;

        } finally {
            this.closeConnection(connection);

        }
    }

    @Override
    public List<Inventario> findAll() {

        Connection connection = null;
        ArrayList<Inventario> inventarios = new ArrayList<Inventario>();

        try {

            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM inventario");
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                long id = resultado.getInt("id");
                long productoId = resultado.getLong("producto_id");
                long proveedorId = resultado.getLong("proveedor_id");
                String ubicacion = resultado.getString("ubicacion");
                int stockDisponible = resultado.getInt("stock_disponible");
                int stockMinimo = resultado.getInt("stock_minimo");
                String fechaActualizacion = resultado.getString("fecha_actualizacion");
                Inventario inventario = new Inventario(id, productoId, proveedorId, ubicacion, stockDisponible,
                        stockMinimo, fechaActualizacion);
                inventarios.add(inventario);
            }

        } catch (SQLException e) {
            System.err.println("No se pudieron conseguir los inventarios");
            return null;

        } finally {
            this.closeConnection(connection);

        }
        return inventarios;
    }

    @Override
    public Inventario findById(Long id) {
        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("SELECT * FROM inventario WHERE id=" + id);
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            long miId = resultado.getInt("id");
            long productoId = resultado.getLong("producto_id");
            long proveedorId = resultado.getLong("proveedor_id");
            String ubicacion = resultado.getString("ubicacion");
            int stockDisponible = resultado.getInt("stock_disponible");
            int stockMinimo = resultado.getInt("stock_minimo");
            String fechaActualizacion = resultado.getString("fecha_actualizacion");
            Inventario inventario = new Inventario(id, productoId, proveedorId, ubicacion, stockDisponible, stockMinimo, fechaActualizacion);
            return inventario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean update(Inventario inventario) {
        
        Connection connection = null;
        Inventario inventarioExiste = findById(inventario.getId());

        if (inventarioExiste == null) {
            return false;
        }

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(String.format(
                    "UPDATE inventario SET producto_id = '%s', proveedor_id = '%s', ubicacion = '%s', stock_disponible = '%s', stock_minimo = '%s', fecha_actualizacion = '%s' WHERE id="+inventario.getId(),
                    inventario.getProductoId(), inventario.getProveedorId(), inventario.getUbicacion(), inventario.getStockDisponible(), inventario.getStockMinimo(), inventario.getFechaActualizacion()));
            sentencia.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("No se pudo actualizar el inventario: "+inventario.getId());
            return false;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            String sql = "DELETE FROM inventario AS i WHERE i.id ="+id;
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.execute();
            return true;
        
        } catch (SQLException e){
            System.err.println("No se pudo eliminar el inventario: "+id);
            return false;

        } finally {
            closeConnection(connection);
        }
    }

}
