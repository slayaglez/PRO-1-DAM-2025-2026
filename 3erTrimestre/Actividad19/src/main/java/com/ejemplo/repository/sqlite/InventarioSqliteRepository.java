package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Inventario;
import com.ejemplo.repository.IInventarioRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InventarioSqliteRepository implements IInventarioRepository {

    private SQLiteConnectionManager connectionManager;

    public InventarioSqliteRepository(SQLiteConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public boolean create(Inventario inventario) {
        if (inventario == null || inventario.getId() == null || findById(inventario.getId()) != null) {
            return false;
        }
        String sql = "INSERT INTO inventario (id, producto_id, proveedor_id, ubicacion, stock_disponible, stock_minimo, fecha_actualizacion) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, inventario.getId());
            ps.setLong(2, inventario.getProductoId());
            ps.setLong(3, inventario.getProveedorId());
            ps.setString(4, inventario.getUbicacion());
            ps.setInt(5, inventario.getStockDisponible());
            ps.setInt(6, inventario.getStockMinimo());
            ps.setString(7, inventario.getFechaActualizacion());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo insertar el inventario en SQLite", e);
        }
    }

    public List<Inventario> findAll() {
        List<Inventario> inventarios = new ArrayList<>();
        String sql = "SELECT * FROM inventario ORDER BY id";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                inventarios.add(mapRow(resultSet));
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el inventario de SQLite", e);
        }
        return inventarios;
    }

    public Inventario findById(Long id) {
        String sql = "SELECT * FROM inventario WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return mapRow(resultSet);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo buscar el inventario por id en SQLite", e);
        }
        return null;
    }

    public boolean update(Inventario inventarioActualizado) {
        String sql = "UPDATE inventario SET producto_id=?, proveedor_id=?, ubicacion=?, stock_disponible=?, stock_minimo=?, fecha_actualizacion=? WHERE id=?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, inventarioActualizado.getProductoId());
            ps.setLong(2, inventarioActualizado.getProveedorId());
            ps.setString(3, inventarioActualizado.getUbicacion());
            ps.setInt(4, inventarioActualizado.getStockDisponible());
            ps.setInt(5, inventarioActualizado.getStockMinimo());
            ps.setString(6, inventarioActualizado.getFechaActualizacion());
            ps.setLong(7, inventarioActualizado.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo actualizar el inventario en SQLite", e);
        }
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM inventario WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo eliminar el inventario de SQLite", e);
        }
    }

    private Inventario mapRow(ResultSet resultSet) throws java.sql.SQLException {
        return new Inventario(resultSet.getLong("id"), resultSet.getLong("producto_id"), resultSet.getLong("proveedor_id"), resultSet.getString("ubicacion"), resultSet.getInt("stock_disponible"), resultSet.getInt("stock_minimo"), resultSet.getString("fecha_actualizacion"));
    }
}
