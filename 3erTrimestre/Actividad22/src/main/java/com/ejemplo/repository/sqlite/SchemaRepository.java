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
                    CREATE TABLE IF NOT EXISTS rol (
                        id INTEGER PRIMARY KEY,
                        name TEXT NOT NULL UNIQUE,
                        salary INTEGER NOT NULL
                    )
                """);
                statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS category (
                        id INTEGER PRIMARY KEY,
                        name TEXT NOT NULL UNIQUE
                    )
                """);
                statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS employee (
                        id INTEGER PRIMARY KEY,
                        name TEXT NOT NULL,
                        surname TEXT NOT NULL,
                        start_date TEXT NOT NULL,
                        reports_to INTEGER,
                        rol_id INTEGER NOT NULL,
                        FOREIGN KEY (reports_to) REFERENCES employee(id),
                        FOREIGN KEY (rol_id) REFERENCES rol(id)
                    )
                """);
                statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS skill (
                        id INTEGER PRIMARY KEY,
                        name TEXT NOT NULL UNIQUE,
                        category_id INTEGER NOT NULL,
                        FOREIGN KEY (category_id) REFERENCES category(id)
                    )
                """);
                statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS resume (
                        id INTEGER PRIMARY KEY,
                        summary TEXT,
                        experience_years INTEGER NOT NULL,
                        employee_id INTEGER NOT NULL UNIQUE,
                        FOREIGN KEY (employee_id) REFERENCES employee(id)
                    )
                """);
                statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS employee_skill (
                        employee_id INTEGER NOT NULL,
                        skill_id INTEGER NOT NULL,
                        level_id TEXT,
                        PRIMARY KEY (employee_id, skill_id),
                        FOREIGN KEY (employee_id) REFERENCES employee(id),
                        FOREIGN KEY (skill_id) REFERENCES skill(id)
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
