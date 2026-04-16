package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;

public class ClienteSqliteRepository extends SQLiteConnectionManager implements IClienteRepository {

    private static String rutaDB = "src/main/resources/data/sqlite/demo.db";

    public ClienteSqliteRepository(String rutaDB) {
        super(rutaDB);
    }

    public ClienteSqliteRepository() {
        super(rutaDB);
    }

    @Override
    public boolean create(Cliente cliente) {

        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(
                    "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?, ?, ?);");
            sentencia.setLong(1, cliente.getId());
            sentencia.setString(2, cliente.getNif());
            sentencia.setString(3, cliente.getNombre());
            sentencia.setString(4, cliente.getEmail());
            sentencia.setString(5, cliente.getTelefono());
            sentencia.setString(6, cliente.getCiudad());
            sentencia.setString(7, cliente.getPais());
            sentencia.setBoolean(8, cliente.isActivo());
            sentencia.execute();
            return true;

        } catch (Exception e) {
            System.err.println("No se pudo almacenar el Cliente: " + cliente.getId());
            return false;

        } finally {
            // ? this.closeConnection(connection)
            closeConnection(connection);

        }
    }

    @Override
    public List<Cliente> findAll() {

        Connection connection = null;
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente");
            ResultSet resultado = sentencia.executeQuery();

            // Cliente 100|00000000Z|Cliente Demo|demo@demo.com|600000000|Madrid|Espana|1

            while (resultado.next()) {

                long id = resultado.getInt("id");
                String nif = resultado.getString("nif");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                String ciudad = resultado.getString("ciudad");
                String pais = resultado.getString("pais");
                int activo = resultado.getInt("activo");
                boolean miActivo = Boolean.parseBoolean(String.valueOf(activo));
                Cliente cliente = new Cliente(id, nif, nombre, email, telefono, ciudad, pais, miActivo);
                clientes.add(cliente);
            }

        } catch (Exception e) {
            return Collections.emptyList();

        } finally {
            closeConnection(connection);

        }

        return clientes;
    }

    @Override
    public Cliente findById(Long id) {
        Connection connection = null;

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("SELECT * FROM cliente WHERE id=" + id);
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            long miId = resultado.getInt("id");
            String nif = resultado.getString("nif");
            String nombre = resultado.getString("nombre");
            String email = resultado.getString("email");
            String telefono = resultado.getString("telefono");
            String ciudad = resultado.getString("ciudad");
            String pais = resultado.getString("pais");
            boolean activo = resultado.getBoolean("activo");
            Cliente cliente = new Cliente(miId, nif, nombre, email, telefono, ciudad, pais, activo);
            return cliente;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean update(Cliente cliente) {

        Connection connection = null;
        Cliente clienteExiste = findById(cliente.getId());

        if (clienteExiste == null) {
            return false;
        }

        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(String.format(
                    "UPDATE cliente SET nif = '%s', nombre = '%s', email = '%s', telefono = '%s', ciudad = '%s', pais = '%s', activo = '%s' WHERE id="+cliente.getId(),
                    cliente.getNif(), cliente.getNombre(), cliente.getEmail(), cliente.getTelefono(), cliente.getCiudad(), cliente.getPais(), (cliente.isActivo()) ? "1" : "0"));
            sentencia.execute();
            return true;

        } catch (SQLException e) {
            System.err.println("No se pudo actualizar el cliente: "+cliente.getId());
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
            String sql = "DELETE FROM cliente AS c WHERE c.id ="+id;
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.execute();
            return true;
        
        } catch (SQLException e){
            System.err.println("No se pudo eliminar el cliente: "+id);
            return false;

        } finally {
            closeConnection(connection);
        }
    }

}
