package com.ejemplo.service;

import com.ejemplo.model.Employee;
import java.util.List;

public interface IEmployeeService {

    boolean crear(Employee employee);
    Employee buscarPorId(Integer id);
    List<Employee> listarTodos();
    boolean actualizar(Employee employee);
    boolean eliminar(Integer id);
    List<Employee> listarPorRol(Integer rolId);
    List<Employee> listarManagers();
    boolean cambiarManager(Integer employeeId, Integer managerId);
    int contarSubordinados(Integer managerId);
    List<Employee> buscarPorApellido(String surname);

}
