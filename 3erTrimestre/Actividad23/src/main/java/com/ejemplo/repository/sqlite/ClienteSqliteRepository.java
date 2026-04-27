package com.ejemplo.repository.sqlite;

import com.ejemplo.model.*;
import com.ejemplo.repository.IClienteRepository;
import java.sql.*;
import java.util.*;

public class ClienteSqliteRepository extends SQLiteConnectionManager implements IClienteRepository {

    public ClienteSqliteRepository() {
        super();
    }

    // validaciones
    // finds
    // mirar el esquema
    // comprobar consultas

    @Override
    public boolean create(Cliente cliente) {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement("INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?)")) {
            sentencia.setString(1, cliente.getDni());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getTelefono());
            sentencia.setString(4, cliente.getEmail());
            sentencia.setString(5, cliente.getCiudad());
            sentencia.setInt(6, cliente.getActivo());
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("Error creando cliente" + e);
            return false;
        }
    }

    @Override
    public List<Cliente> findAll() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente")) {
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String email = resultado.getString("email");
                String ciudad = resultado.getString("ciudad");
                Integer activo = resultado.getInt("activo");
                clientes.add(new Cliente(dni, nombre, telefono, email, ciudad, activo));
            }
            return clientes;

        } catch (Exception e) {
            System.err.println("Error buscando clientes" + e);
            return null;
        }
    }

    @Override
    public Cliente findByDni(String dni) {

        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente")) {
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            String nombre = resultado.getString("nombre");
            String telefono = resultado.getString("telefono");
            String email = resultado.getString("email");
            String ciudad = resultado.getString("ciudad");
            Integer activo = resultado.getInt("activo");
            return new Cliente(dni, nombre, telefono, email, ciudad, activo);

        } catch (Exception e) {
            System.err.println("Error buscando cliente" + e);
            return null;
        }
    }

    @Override
    public boolean update(Cliente cliente) {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement(
                                "INSERT INTO cliente (nombre, telefono, email, ciudad, activo) VALUES (?, ?, ?, ?, ?) WHERE id = ?")) {

            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getTelefono());
            sentencia.setString(3, cliente.getEmail());
            sentencia.setString(4, cliente.getCiudad());
            sentencia.setInt(5, cliente.getActivo());
            sentencia.setString(6, cliente.getDni());
            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error actualizando cliente" + e);
            return false;
        }
    }

    @Override
    public boolean deleteByDni(String dni) {
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection
                        .prepareStatement("DELETE FROM cliente WHERE dni = ?")) {
            sentencia.setString(1, dni);

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error eliminando cliente" + e);
            return false;
        }
    }

    @Override
    public List<Cliente> findActive() {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente WHERE activo = 1")) {
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String email = resultado.getString("email");
                String ciudad = resultado.getString("ciudad");
                Integer activo = resultado.getInt("activo");
                clientes.add(new Cliente(dni, nombre, telefono, email, ciudad, activo));
            }
            return clientes;

        } catch (Exception e) {
            System.err.println("Error buscando clientes activos" + e);
            return null;
        }
    }

    @Override
    public List<Cliente> findByCity(String ciudad) {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente WHERE ciudad = ?")) {
            sentencia.setString(1, ciudad);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String email = resultado.getString("email");
                Integer activo = resultado.getInt("activo");
                clientes.add(new Cliente(dni, nombre, telefono, email, ciudad, activo));
            }
            return clientes;

        } catch (Exception e) {
            System.err.println("Error buscando clientes por ciudad" + e);
            return null;
        }
    }

    @Override
    public Cliente findByMail(String email) {
        List<Cliente> clientes = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM cliente WHERE email = ?")) {
            sentencia.setString(1, email);
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            String dni = resultado.getString("dni");
            String nombre = resultado.getString("nombre");
            String telefono = resultado.getString("telefono");
            String ciudad = resultado.getString("ciudad");
            Integer activo = resultado.getInt("activo");
            return new Cliente(dni, nombre, telefono, email, ciudad, activo);

        } catch (Exception e) {
            System.err.println("Error buscando clientes por su correo" + e);
            return null;
        }
    }



}
