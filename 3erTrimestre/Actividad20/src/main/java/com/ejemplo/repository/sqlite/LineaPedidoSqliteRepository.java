package com.ejemplo.repository.sqlite;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.repository.ILineaPedidoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LineaPedidoSqliteRepository extends SQLiteConnectionManager implements ILineaPedidoRepository {

    LineaPedidoSqliteRepository() {
        super(rutaDB);
    }

    LineaPedidoSqliteRepository(String rutaDB) {
        super(rutaDB);
    }

    @Override
    public boolean create(LineaPedido lineaPedido) {
        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(
                    "INSERT INTO linea_pedido VALUES (?, ?, ?, ?, ?, ?);");
            sentencia.setLong(1, lineaPedido.getId());
            sentencia.setLong(2, lineaPedido.getPedidoId());
            sentencia.setLong(3, lineaPedido.getProductoId());
            sentencia.setInt(4, lineaPedido.getCantidad());
            sentencia.setDouble(5, lineaPedido.getPrecioUnitario());
            sentencia.setDouble(6, lineaPedido.getSubtotal());
            sentencia.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("No se pudo almacenar la Linea Pedido: " + lineaPedido.getId());
            return false;

        } finally {
            this.closeConnection(connection);

        }
    }

    @Override
    public List<LineaPedido> findAll() {

        Connection connection = null;
        ArrayList<LineaPedido> lineaPedidos = new ArrayList<LineaPedido>();

        try {

            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM linea_pedido");
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                long id = resultado.getLong("id");
                long pedidoId = resultado.getLong("pedido_id");
                long productoId = resultado.getLong("producto_id");
                int cantidad = resultado.getInt("cantidad");
                double precioUnitario = resultado.getDouble("precio_unitario");
                double subtotal = resultado.getDouble("subtotal");
                LineaPedido lineaPedido = new LineaPedido(id, pedidoId, productoId, cantidad, precioUnitario,
                        subtotal);
                lineaPedidos.add(lineaPedido);
            }

        } catch (SQLException e) {
            System.err.println("No se pudieron conseguir las lineas de pedidos");
            return null;

        } finally {
            this.closeConnection(connection);

        }
        return lineaPedidos;
    }

    @Override
    public LineaPedido findById(Long id) {
        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("SELECT * FROM linea_pedido WHERE id=" + id);
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            long miId = resultado.getLong("id");
            long pedidoId = resultado.getLong("pedido_id");
            long productoId = resultado.getLong("producto_id");
            int cantidad = resultado.getInt("cantidad");
            double precioUnitario = resultado.getDouble("precio_unitario");
            double subtotal = resultado.getDouble("subtotal");
            
            LineaPedido lineaPedido = new LineaPedido(miId, pedidoId, productoId, cantidad, precioUnitario, subtotal);
            return lineaPedido;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean update(LineaPedido lineaPedido) {
        
        Connection connection = null;
        LineaPedido lineaPedidoExiste = findById(lineaPedido.getId());

        if (lineaPedidoExiste == null) {
            return false;
        }

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(String.format(
                    "UPDATE linea_pedido SET pedido_id = '%s', producto_id = '%s', cantidad = '%s', precio_unitario = '%s', subtotal = '%s' WHERE id="+lineaPedido.getId(),
                    lineaPedido.getPedidoId(), lineaPedido.getProductoId(), lineaPedido.getCantidad(), lineaPedido.getPrecioUnitario(), lineaPedido.getSubtotal()));
            sentencia.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.err.println("No se pudo actualizar el lineaPedido: "+lineaPedido.getId());
            return false;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean deleteById(Long id) {
        String sql = "DELETE FROM linea_pedido AS i WHERE i.id ="+id;
        return super.deleteById(sql);
    }

}
