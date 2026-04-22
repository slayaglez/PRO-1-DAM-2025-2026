package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Employee;
import com.ejemplo.repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSqliteRepository extends SQLiteConnectionManager implements IEmployeeRepository {

    public EmployeeSqliteRepository() {
        super(rutaDb);
    }

    @Override
    public boolean create(Employee employee) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection
                    .prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?)");
            sentencia.setInt(1, employee.getId());
            sentencia.setString(2, employee.getName());
            sentencia.setString(3, employee.getSurname());
            sentencia.setString(4, employee.getStartDate());

            // ! Esta es la forma correcta de manejar el null?
            if (employee.getReportsTo() == null) {
                sentencia.setNull(5, java.sql.Types.INTEGER);
            } else {
                sentencia.setInt(5, employee.getReportsTo());
            }

            sentencia.setInt(6, employee.getRolId());
            sentencia.execute(); // ! Diferencia entre executeQuery()?
            return true;

        } catch (Exception e) {
            System.err.println("Error creando empleado");
            return false;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public Employee findById(Integer id) {

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM employee WHERE id=" + id);
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next())
                return null;

            String name = resultado.getString("name");
            String surname = resultado.getString("surname");
            String startDate = resultado.getString("start_date");
            // ! Es esta la forma correcta de manejar el null???
            Integer reportsTo = (Integer) resultado.getObject("reports_to");
            Integer rolId = resultado.getInt("rol_id");

            Employee empleado = new Employee(id, name, surname, startDate, reportsTo, rolId);

            return empleado;

        } catch (Exception e) {
            System.err.println("Error buscando empleados");
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public List<Employee> findAll() {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM employee");
            ResultSet resultado = sentencia.executeQuery();
            List<Employee> empleados = new ArrayList<>();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String name = resultado.getString("name");
                String surname = resultado.getString("surname");
                String startDate = resultado.getString("start_date");
                Integer reportsTo = (Integer) resultado.getObject("reports_to");
                Integer rolId = resultado.getInt("rol_id");

                Employee empleado = new Employee(id, name, surname, startDate, reportsTo, rolId);
                empleados.add(empleado);
            }
            return empleados;

        } catch (Exception e) {
            System.err.println("Error buscando empleados");
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean update(Employee employee) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(
                    "UPDATE employee SET name=?, surname=?, starts_date=?, reports_to=?, rol_id=? WHERE id=?");
            
            sentencia.setString(1, employee.getName());
            sentencia.setString(2, employee.getSurname());
            sentencia.setString(3, employee.getStartDate());
            
            if (employee.getReportsTo() == null) {
                sentencia.setNull(4, java.sql.Types.INTEGER);
            } else {
                sentencia.setInt(4, employee.getReportsTo());
            }
            
            sentencia.setInt(5, employee.getRolId());
            sentencia.setInt(6, employee.getId());
            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error actualizando empleado");
            return false;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean deleteById(Integer id) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("DELETE FROM employee WHERE id=?");
            sentencia.setInt(1, id);

            sentencia.execute();
            return true;

        } catch (Exception e) {
            System.err.println("Error borrando el cliente");
            return false;

        } finally {
            closeConnection(connection);

        }
    }

}
