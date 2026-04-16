package com.ejemplo.repository.sqlite;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class SQLiteConnectionManager {

    public static String rutaDB = "src/main/resources/data/sqlite/demo.db";
    private String url;

    SQLiteConnectionManager(String rutaDB) {
        try {
            File file = new File(rutaDB);
            if (!file.exists()) {
                Path path = Path.of(rutaDB);

                file.createNewFile();
                // inicializar la bbd
            }
            this.url = rutaDB;
        } catch (Exception e) {
            System.err.println("No se pudo inicializar / encontrar la BBDD");
        }

        this.url = "jdbc:sqlite:" + rutaDB;

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public boolean closeConnection(Connection connection) {
        try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error cerrando la connection");
            return false;
        }
        return true;
    }


    public boolean deleteById(String sql) {
        
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            sentencia.execute();
            return true;
        
        } catch (SQLException e){
            System.err.println("No se pudo eliminar el cliente: ");
            return false;

        } finally {
            closeConnection(connection);
        }
    }
}
