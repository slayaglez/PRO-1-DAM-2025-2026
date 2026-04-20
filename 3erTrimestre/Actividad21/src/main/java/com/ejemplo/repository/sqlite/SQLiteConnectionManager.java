package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionManager {

    public static String rutaDb = "src/main/resources/data/sqlite/inmuebles.db";

    public SQLiteConnectionManager(String rutaDb) {
        this.rutaDb = rutaDb;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + rutaDb);
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException("No se pudo cerrar la conexion", e);
            }
        }
    }
}
