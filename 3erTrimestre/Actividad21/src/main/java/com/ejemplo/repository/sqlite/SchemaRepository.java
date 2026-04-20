package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.Statement;

public class SchemaRepository extends SQLiteConnectionManager {

    public SchemaRepository(String rutaDb) {
        super(rutaDb);
    }

    public void createSchema() {
        Connection connection = null;
        try {
            connection = getConnection();
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS propietario (
                        dni TEXT PRIMARY KEY,
                        nombre TEXT NOT NULL,
                        email TEXT,
                        telefono TEXT,
                        ciudad TEXT,
                        activo INTEGER NOT NULL DEFAULT 1
                    )
                """);
                statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS inmueble (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        referencia TEXT NOT NULL UNIQUE,
                        tipo TEXT NOT NULL,
                        direccion TEXT NOT NULL,
                        ciudad TEXT,
                        anio_construccion INTEGER,
                        metros_cuadrados INTEGER NOT NULL DEFAULT 0,
                        precio REAL NOT NULL,
                        vendido INTEGER NOT NULL DEFAULT 0,
                        dni_propietario TEXT NOT NULL,
                        FOREIGN KEY (dni_propietario) REFERENCES propietario(dni)
                    )
                """);
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear el esquema", e);
        } finally {
            closeConnection(connection);
        }
    }
}
