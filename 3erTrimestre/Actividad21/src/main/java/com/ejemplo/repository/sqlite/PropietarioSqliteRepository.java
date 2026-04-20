package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Propietario;
import com.ejemplo.repository.IPropietarioRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PropietarioSqliteRepository extends SQLiteConnectionManager implements IPropietarioRepository {

    public PropietarioSqliteRepository() {
        super(rutaDb);
    }

    @Override
    public boolean create(Propietario propietario) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("INSERT INTO propietario VALUES (?, ?, ?, ?, ?, ?)");

            sentencia.setString(1, propietario.getDni());
            sentencia.setString(2, propietario.getNombre());
            sentencia.setString(3, propietario.getEmail());
            sentencia.setString(4, propietario.getTelefono());
            sentencia.setString(5, propietario.getCiudad());
            sentencia.setBoolean(6, propietario.isActivo());

            sentencia.execute();
            return true;

        } catch (Exception e) {
            System.err.println("No se pudo introducir el propietario");
            return false;
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Propietario> findAll() {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM propietario");
            ResultSet resultado = sentencia.executeQuery();
            List<Propietario> propietarios = new ArrayList<>();

            while (resultado.next()) {
                String dni = resultado.getString("dni");
                String nombre = resultado.getString("nombre");
                String email = resultado.getString("email");
                String telefono = resultado.getString("telefono");
                String ciudad = resultado.getString("ciudad");
                boolean activo = resultado.getBoolean("activo");

                propietarios.add(new Propietario(dni, nombre, email, telefono, ciudad, activo));
            }

            return propietarios;

        } catch (Exception e) {
            System.err.println("No se pudo conseguir los propietarios");
            return null;
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public Propietario findById(String dni) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement(String.format("SELECT * FROM propietario WHERE dni = '%s'", dni));
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            String myDni = resultado.getString("dni");
            String nombre = resultado.getString("nombre");
            String email = resultado.getString("email");
            String telefono = resultado.getString("telefono");
            String ciudad = resultado.getString("ciudad");
            boolean activo = resultado.getBoolean("activo");

            return new Propietario(myDni, nombre, email, telefono, ciudad, activo);

        } catch (Exception e) {
            System.err.println("No se pudo encontrar el propietario");
            return null;
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean update(Propietario propietario) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("UPDATE propietario SET nombre=?, email=?, telefono=?, ciudad=?, activo=? WHERE dni=?");

            sentencia.setString(1, propietario.getNombre());
            sentencia.setString(2, propietario.getEmail());
            sentencia.setString(3, propietario.getTelefono());
            sentencia.setString(4, propietario.getCiudad());
            sentencia.setBoolean(5, propietario.isActivo());
            sentencia.setString(6, propietario.getDni());

            sentencia.execute();
            return true;

        } catch (Exception e) {
            System.err.println("No se pudo actualizar el propietario");
            return false;
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean deleteById(String dni) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement(String.format("DELETE FROM propietario WHERE dni='%s'", dni));

            return sentencia.execute();

        } catch (Exception e) {
            System.err.println("No se pudo eliminar el propietario");
            return false;
        } finally {
            closeConnection(connection);
        }
    }
}