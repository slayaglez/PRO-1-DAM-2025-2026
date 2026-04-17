package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.model.Producto;
import com.ejemplo.repository.IProductoRepository;

public class ProductoSqliteRepository extends SQLiteConnectionManager implements IProductoRepository {

    public ProductoSqliteRepository(String rutaDB) {
        super(rutaDB);
    }

    public ProductoSqliteRepository() {
        super(rutaDB);
    }

    @Override
    public boolean create(Producto producto) {

        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("INSERT INTO producto VALUES (?, ?, ?, ?, ?, ?, ?)");
            sentencia.setLong(1, producto.getId());            
            sentencia.setString(2, producto.getSku());        
            sentencia.setString(3, producto.getNombre());        
            sentencia.setString(4, producto.getCategoria());        
            sentencia.setDouble(5, producto.getPrecio());        
            sentencia.setInt(6, producto.getStock());        
            sentencia.setBoolean(7, producto.isActivo());                    
            sentencia.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("No se pudo insertar el producto en la BBDD");
            return false;

        } finally {
            this.closeConnection(connection);

        }

    }

    @Override
    public List<Producto> findAll() {
        Connection connection = null;
        List<Producto> productos = new ArrayList<Producto>();

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM producto");
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Long id = resultado.getLong("id");
                String sku = resultado.getString("sku");
                String nombre = resultado.getString("nombre");
                String categoria = resultado.getString("categoria");
                double precio = resultado.getDouble("precio");
                int stock = resultado.getInt("stock");
                boolean activo = resultado.getBoolean("activo");
                Producto producto = new Producto(id, sku, nombre, categoria, precio, stock, activo);
                productos.add(producto);
            }
            return productos;

        } catch (Exception e) {
            System.err.println("No se pudo hacer la consulta");
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public Producto findById(Long id) {
        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM producto WHERE id=" + id);
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            Long myId = resultado.getLong("id");
            String sku = resultado.getString("sku");
            String nombre = resultado.getString("nombre");
            String categoria = resultado.getString("categoria");
            double precio = resultado.getDouble("precio");
            int stock = resultado.getInt("stock");
            boolean activo = resultado.getBoolean("activo");
            Producto producto = new Producto(id, sku, nombre, categoria, precio, stock, activo);
            return producto;

        } catch (Exception e) {
            System.err.println("No se pudo encontrar el producto");
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean update(Producto producto) {

        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(String.format(
                    "UPDATE producto SET sku = '%s', nombre = '%s', categoria = '%s', precio = '%s', stock = '%s', activo = '%s' WHERE id = %s;",
                    producto.getSku(), producto.getNombre(), producto.getCategoria(), producto.getPrecio(),
                    producto.getStock(), producto.isActivo(), producto.getId()));
            sentencia.executeUpdate();
            return true;

        } catch (Exception e) {
            System.err.println("No se pudo actualizar el producto");
            return false;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean deleteById(Long id) {

        String sentencia = "DELETE FROM producto WHERE id="+id;
        return super.deleteById(sentencia);
    }

}
