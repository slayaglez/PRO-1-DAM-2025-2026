package com.ejemplo.support;

import com.ejemplo.repository.sqlite.SQLiteConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDatabaseSupport {

    private Connection getConnection() throws SQLException {
        return SQLiteConnectionManager.openConnection();
    }

    public void insertarCatalogosBase() {
        insertarRol(1, "Junior Developer", 24000);
        insertarRol(2, "Developer", 32000);
        insertarRol(3, "Senior Developer", 42000);
        insertarRol(5, "Project Manager", 48000);
        insertarCategoria(1, "Programming");
        insertarCategoria(2, "Database");
        insertarCategoria(3, "Cloud");
    }

    public void insertarRol(int id, String name, int salary) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO rol (id, name, salary) VALUES (?, ?, ?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, salary);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo insertar rol", e);
        }
    }

    public void insertarCategoria(int id, String name) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO category (id, name) VALUES (?, ?)")) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo insertar categoria", e);
        }
    }

    public void insertarResume(int id, String summary, int years, int employeeId) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO resume (id, summary, experience_years, employee_id) VALUES (?, ?, ?, ?)") ) {
            ps.setInt(1, id);
            ps.setString(2, summary);
            ps.setInt(3, years);
            ps.setInt(4, employeeId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo insertar resume", e);
        }
    }

    public String obtenerLevelAsignado(int employeeId, int skillId) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT level_id FROM employee_skill WHERE employee_id = ? AND skill_id = ?")) {
            ps.setInt(1, employeeId);
            ps.setInt(2, skillId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getString(1) : null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("No se pudo obtener el level asignado", e);
        }
    }

    public int contarFilas(String tableName) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM " + tableName);
             ResultSet rs = ps.executeQuery()) {
            return rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException e) {
            throw new RuntimeException("No se pudieron contar filas", e);
        }
    }
}
