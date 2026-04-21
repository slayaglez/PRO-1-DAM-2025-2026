package com.ejemplo.repository;

import com.ejemplo.model.Employee;
import java.util.List;

public interface IEmployeeRepository {

    /**
     * Crea un empleado
     * @param Empleado
     * @return boolean
     */
    boolean create(Employee employee);

    /**
     * Encuentra por ID
     * @param id ID
     * @return Empleado
     */
    Employee findById(Integer id);

    /**
     * Lista todos los empleados
     * @return List Empleado
     */
    List<Employee> findAll();

    /**
     * Update de un Empleado
     * @param employee Empleado
     * @return boolean
     */
    boolean update(Employee employee);

    /**
     * Elimina un usuario
     * @param id ID
     * @return boolean
     */
    boolean deleteById(Integer id);
}
