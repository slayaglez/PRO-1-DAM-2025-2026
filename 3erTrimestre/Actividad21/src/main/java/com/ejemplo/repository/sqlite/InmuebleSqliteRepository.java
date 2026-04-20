package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Inmueble;
import com.ejemplo.repository.IInmuebleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InmuebleSqliteRepository extends SQLiteConnectionManager implements IInmuebleRepository {

    public InmuebleSqliteRepository() {
        super(rutaDb);
    }

    @Override
    public boolean create(Inmueble inmueble) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("INSERT INTO inmueble VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            sentencia.setLong(1, inmueble.getId());
            sentencia.setString(2, inmueble.getReferencia());
            sentencia.setString(3, inmueble.getTipo());
            sentencia.setString(4, inmueble.getDireccion());
            sentencia.setString(5, inmueble.getCiudad());
            sentencia.setInt(6, inmueble.getAnioConstruccion());
            sentencia.setInt(7, inmueble.getMetrosCuadrados());
            sentencia.setDouble(8, inmueble.getPrecio());
            sentencia.setBoolean(9, inmueble.isVendido());
            sentencia.setString(10, inmueble.getDniPropietario());
            return true;
        } catch (Exception e) {
            System.err.println("No se pudo introducir el inmueble");
            return false;
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Inmueble> findAll() {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM inmuebles");
            ResultSet resultado = sentencia.executeQuery();
            List<Inmueble> inmuebles = new ArrayList<>();

            while (resultado.next()) {
                Long id = resultado.getLong("id");
                String referencia = resultado.getString("referencia");
                String tipo = resultado.getString("tipo");
                String direccion = resultado.getString("direccion");
                String ciudad = resultado.getString("ciudad");
                Integer anioConstruccion = resultado.getInt("anio_contruccion");
                Integer metrosCuadrados = resultado.getInt("metros_cuadrados");
                Double precio = resultado.getDouble("precio");
                boolean vendido = resultado.getBoolean("vendido");
                String dniPropietario = resultado.getString("dni_propietario");
                Inmueble inmueble = new Inmueble(id, referencia, tipo, direccion, ciudad, anioConstruccion,
                        metrosCuadrados, precio, vendido, dniPropietario);
                inmuebles.add(inmueble);
                return inmuebles;
            }
        } catch (Exception e) {
            System.err.println("No se pudo conseguir los inmuebles");
            return null;
        } finally {
            closeConnection(connection);
        }
        return null;
    }

    @Override
    public Inmueble findById(Long id) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement(String.format("SELECT * FROM inmuebles WHERE id = %s", id));
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) {
                return null;
            }

            String referencia = resultado.getString("referencia");
            String tipo = resultado.getString("tipo");
            String direccion = resultado.getString("direccion");
            String ciudad = resultado.getString("ciudad");
            Integer anioConstruccion = resultado.getInt("anio_contruccion");
            Integer metrosCuadrados = resultado.getInt("metros_cuadrados");
            Double precio = resultado.getDouble("precio");
            boolean vendido = resultado.getBoolean("vendido");
            String dniPropietario = resultado.getString("dni_propietario");
            Inmueble inmueble = new Inmueble(id, referencia, tipo, direccion, ciudad, anioConstruccion, metrosCuadrados,
                    precio, vendido, dniPropietario);
            return inmueble;

        } catch (Exception e) {
            System.err.println("No se pudo encontrar el inmueble");
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean update(Inmueble inmueble) {
        Connection connection = null;

        try {
             connection = getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("UPDATE inmueble SET (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) WHERE id=?");
            
            sentencia.setString(1, inmueble.getReferencia());
            sentencia.setString(2, inmueble.getTipo());
            sentencia.setString(3, inmueble.getDireccion());
            sentencia.setString(4, inmueble.getCiudad());
            sentencia.setInt(5, inmueble.getAnioConstruccion());
            sentencia.setInt(6, inmueble.getMetrosCuadrados());
            sentencia.setDouble(7, inmueble.getPrecio());
            sentencia.setBoolean(8, inmueble.isVendido());
            sentencia.setString(9, inmueble.getDniPropietario());
            sentencia.setLong(10, inmueble.getId());
            return true;
        } catch (Exception e) {
            System.err.println("No se pudo actualizar el inmueble");
            return false;
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(String.format("DELETE FROM inmueble WHERE id=%s", id));
            return sentencia.execute();
        
        } catch (Exception e) {
            System.err.println("No se pudo eliminar el inmueble");
            return false;
        } finally {
            closeConnection(connection);
        }
    }
}
