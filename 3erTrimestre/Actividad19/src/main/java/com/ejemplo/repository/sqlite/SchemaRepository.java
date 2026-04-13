package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.Statement;

public class SchemaRepository {

    private SQLiteConnectionManager connectionManager;

    public SchemaRepository(SQLiteConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public boolean createSchema() throws Exception {
        try (Connection connection = connectionManager.getConnection();
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("""
                CREATE TABLE IF NOT EXISTS cliente (
                    id INTEGER PRIMARY KEY,
                    nif TEXT NOT NULL,
                    nombre TEXT NOT NULL,
                    email TEXT,
                    telefono TEXT,
                    ciudad TEXT,
                    pais TEXT,
                    activo INTEGER NOT NULL
                )
            """);

            statement.executeUpdate("""
                CREATE TABLE IF NOT EXISTS producto (
                    id INTEGER PRIMARY KEY,
                    sku TEXT NOT NULL,
                    nombre TEXT NOT NULL,
                    categoria TEXT,
                    precio REAL NOT NULL,
                    stock INTEGER NOT NULL,
                    activo INTEGER NOT NULL
                )
            """);

            statement.executeUpdate("""
                CREATE TABLE IF NOT EXISTS proveedor (
                    id INTEGER PRIMARY KEY,
                    codigo TEXT NOT NULL,
                    nombre TEXT NOT NULL,
                    contacto TEXT,
                    email TEXT,
                    pais TEXT
                )
            """);

            statement.executeUpdate("""
                CREATE TABLE IF NOT EXISTS inventario (
                    id INTEGER PRIMARY KEY,
                    producto_id INTEGER NOT NULL,
                    proveedor_id INTEGER NOT NULL,
                    ubicacion TEXT,
                    stock_disponible INTEGER NOT NULL,
                    stock_minimo INTEGER NOT NULL,
                    fecha_actualizacion TEXT
                )
            """);

            statement.executeUpdate("""
                CREATE TABLE IF NOT EXISTS pedido (
                    id INTEGER PRIMARY KEY,
                    numero TEXT NOT NULL,
                    cliente_id INTEGER NOT NULL,
                    fecha TEXT NOT NULL,
                    estado TEXT NOT NULL,
                    total REAL NOT NULL
                )
            """);

            statement.executeUpdate("""
                CREATE TABLE IF NOT EXISTS linea_pedido (
                    id INTEGER PRIMARY KEY,
                    pedido_id INTEGER NOT NULL,
                    producto_id INTEGER NOT NULL,
                    cantidad INTEGER NOT NULL,
                    precio_unitario REAL NOT NULL,
                    subtotal REAL NOT NULL
                )
            """);

            return true;
        }
    }
}
