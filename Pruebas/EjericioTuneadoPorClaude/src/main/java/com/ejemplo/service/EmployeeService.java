package com.ejemplo.service;

import com.ejemplo.model.Employee;
import com.ejemplo.repository.IEmployeeRepository;
import com.ejemplo.repository.sqlite.EmployeeSqliteRepository;
import com.ejemplo.repository.sqlite.SQLiteConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository repository;

    public EmployeeService() {
        this.repository = new EmployeeSqliteRepository();
    }

    @Override
    public boolean crear(Employee employee) {
        if (!validarEmployee(employee)) return false;
        if (repository.findById(employee.getId()) != null) return false;
        if (!existeEnTabla("rol", employee.getRolId())) return false;
        if (employee.getReportsTo() != null && repository.findById(employee.getReportsTo()) == null) return false;
        trimEmployee(employee);
        return repository.create(employee);
    }

    @Override
    public Employee buscarPorId(Integer id) {
        if (id == null) return null;
        return repository.findById(id);
    }

    @Override
    public List<Employee> listarTodos() {
        return repository.findAll();
    }

    @Override
    public boolean actualizar(Employee employee) {
        if (!validarEmployee(employee)) return false;
        if (!existeEnTabla("rol", employee.getRolId())) return false;
        if (employee.getReportsTo() != null) {
            if (employee.getReportsTo().equals(employee.getId())) return false;
            if (repository.findById(employee.getReportsTo()) == null) return false;
        }
        trimEmployee(employee);
        return repository.update(employee);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (id == null) return false;
        return repository.deleteById(id);
    }

    @Override
    public List<Employee> listarPorRol(Integer rolId) {
        List<Employee> empleados = repository.findAll();
        List<Employee> porRol = new ArrayList<>();
        for (Employee employee : empleados) {
            if (employee.getRolId().equals(rolId)) {
                porRol.add(employee);
            }
        }
        return porRol;
    }

    @Override
    public List<Employee> listarManagers() {
        List<Employee> todos = repository.findAll();
        Set<Integer> idsDeManagers = new HashSet<>();
        for (Employee e : todos) {
            if (e.getReportsTo() != null) {
                idsDeManagers.add(e.getReportsTo());
            }
        }
        List<Employee> managers = new ArrayList<>();
        for (Employee e : todos) {
            if (idsDeManagers.contains(e.getId())) {
                managers.add(e);
            }
        }
        return managers;
    }

    @Override
    public boolean cambiarManager(Integer employeeId, Integer managerId) {
        if (employeeId == null || managerId == null) return false;
        Employee employee = repository.findById(employeeId);
        if (employee == null) return false;
        if (repository.findById(managerId) == null) return false;
        employee.setReportsTo(managerId);
        return repository.update(employee);
    }

    @Override
    public int contarSubordinados(Integer managerId) {
        if (managerId == null) return 0;
        List<Employee> todos = repository.findAll();
        int count = 0;
        for (Employee e : todos) {
            if (managerId.equals(e.getReportsTo())) count++;
        }
        return count;
    }

    @Override
    public List<Employee> buscarPorApellido(String surname) {
        if (surname == null) return new ArrayList<>();
        List<Employee> todos = repository.findAll();
        List<Employee> resultado = new ArrayList<>();
        for (Employee e : todos) {
            if (e.getSurname().equalsIgnoreCase(surname.trim())) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public boolean validarEmployee(Employee empleado) {
        if (empleado == null) return false;
        if (empleado.getId() == null) return false;
        if (empleado.getName() == null || empleado.getName().isBlank()) return false;
        if (empleado.getSurname() == null || empleado.getSurname().isBlank()) return false;
        if (empleado.getStartDate() == null || empleado.getStartDate().isBlank()) return false;
        return true;
    }

    private void trimEmployee(Employee e) {
        e.setName(e.getName().trim());
        e.setSurname(e.getSurname().trim());
        e.setStartDate(e.getStartDate().trim());
    }

    // Comprueba si existe una fila con ese id en una tabla catálogo
    private boolean existeEnTabla(String tabla, Integer id) {
        if (id == null) return false;
        try (Connection connection = SQLiteConnectionManager.openConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT id FROM " + tabla + " WHERE id = ?")) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
