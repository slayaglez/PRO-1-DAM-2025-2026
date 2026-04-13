package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteConnectionManager {

    private String url;

    public SQLiteConnectionManager(String rutaDB) {
        this.url = "jdbc:sqlite:" + rutaDB;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
