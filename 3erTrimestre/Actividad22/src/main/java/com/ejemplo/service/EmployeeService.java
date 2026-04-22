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
import java.util.List;

public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository repository;

    public EmployeeService() {
        this.repository = new EmployeeSqliteRepository();
    }

    @Override
    public boolean crear(Employee employee) {
        if(!validarEmployee(employee) && repository.findById(employee.getId()) == null){
            return false;
        } 
        return repository.create(employee);
    }

    @Override
    public Employee buscarPorId(Integer id) {
        if(id == null) return null;
        return repository.findById(id);
    }

    @Override
    public List<Employee> listarTodos() {
        return repository.findAll();
    }

    @Override
    public boolean actualizar(Employee employee) {
        if(!validarEmployee(employee)) return false;
        return repository.update(employee);
    }

    @Override
    public boolean eliminar(Integer id) {
        if(id == null) return false;
        return repository.deleteById(id);
    }

    @Override
    public List<Employee> listarPorRol(Integer rolId) {
        List<Employee> empleados = repository.findAll();
        List<Employee> porRol = new ArrayList<>();

        for (Employee employee : empleados) {
            if(employee.getRolId().equals(rolId)){
                porRol.add(employee);
            }
        }
        return porRol;
    }

    @Override
    public List<Employee> listarManagers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarManagers'");
    }

    @Override
    public boolean cambiarManager(Integer employeeId, Integer managerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarManager'");
    }

    @Override
    public int contarSubordinados(Integer managerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarSubordinados'");
    }

    @Override
    public List<Employee> buscarPorApellido(String surname) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorApellido'");
    }

    public boolean validarEmployee(Employee empleado){

        if(empleado == null) return false;
        if(empleado.getId() == null) return false;
        if(empleado.getName() == null || empleado.getName().isBlank()) return false;
        if(empleado.getSurname() == null || empleado.getSurname().isBlank()) return false;

        return true;
    }
}
