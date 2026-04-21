package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnectionManager {

    public static String rutaDb = "src/main/resources/data/sqlite/employee.db";

    public SQLiteConnectionManager(String rutaDb) {
        SQLiteConnectionManager.rutaDb = rutaDb;
    }

    public static Connection openConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + rutaDb);
        try (Statement statement = connection.createStatement()) {
            statement.execute("PRAGMA foreign_keys = ON");
        }
        return connection;
    }

    public Connection getConnection() throws SQLException {
        return openConnection();
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
