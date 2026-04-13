package com.ejemplo.repository.sqlite;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.repository.ILineaPedidoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LineaPedidoSqliteRepository implements ILineaPedidoRepository {

    private SQLiteConnectionManager connectionManager;

    public LineaPedidoSqliteRepository(SQLiteConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public boolean create(LineaPedido lineaPedido) {
        if (lineaPedido == null || lineaPedido.getId() == null || findById(lineaPedido.getId()) != null) {
            return false;
        }
        String sql = "INSERT INTO linea_pedido (id, pedido_id, producto_id, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, lineaPedido.getId());
            ps.setLong(2, lineaPedido.getPedidoId());
            ps.setLong(3, lineaPedido.getProductoId());
            ps.setInt(4, lineaPedido.getCantidad());
            ps.setDouble(5, lineaPedido.getPrecioUnitario());
            ps.setDouble(6, lineaPedido.getSubtotal());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar la linea de pedido en SQLite", e);
        }
    }

    public List<LineaPedido> findAll() {
        List<LineaPedido> lineas = new ArrayList<>();
        String sql = "SELECT * FROM linea_pedido ORDER BY id";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                lineas.add(mapRow(resultSet));
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudieron leer las lineas de pedido de SQLite", e);
        }
        return lineas;
    }

    public LineaPedido findById(Long id) {
        String sql = "SELECT * FROM linea_pedido WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet resultSet = ps.executeQuery()) {
                if (resultSet.next()) {
                    return mapRow(resultSet);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo buscar la linea de pedido en SQLite", e);
        }
        return null;
    }

    public boolean update(LineaPedido lineaActualizada) {
        String sql = "UPDATE linea_pedido SET pedido_id=?, producto_id=?, cantidad=?, precio_unitario=?, subtotal=? WHERE id=?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, lineaActualizada.getPedidoId());
            ps.setLong(2, lineaActualizada.getProductoId());
            ps.setInt(3, lineaActualizada.getCantidad());
            ps.setDouble(4, lineaActualizada.getPrecioUnitario());
            ps.setDouble(5, lineaActualizada.getSubtotal());
            ps.setLong(6, lineaActualizada.getId());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo actualizar la linea de pedido en SQLite", e);
        }
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM linea_pedido WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo borrar la linea de pedido en SQLite", e);
        }
    }

    private LineaPedido mapRow(ResultSet resultSet) throws java.sql.SQLException {
        return new LineaPedido(resultSet.getLong("id"), resultSet.getLong("pedido_id"), resultSet.getLong("producto_id"), resultSet.getInt("cantidad"), resultSet.getDouble("precio_unitario"), resultSet.getDouble("subtotal"));
    }
}
