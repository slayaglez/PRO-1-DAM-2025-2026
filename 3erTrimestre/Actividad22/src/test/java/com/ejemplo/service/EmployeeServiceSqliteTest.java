package com.ejemplo.service;

import com.ejemplo.model.Employee;
import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceSqliteTest {

    private IEmployeeService employeeService;
    private TestDatabaseSupport support;

    @BeforeEach
    void setUp() {
        try {
            Files.copy(Path.of(TestBackupManager.rutaBackupDb), Path.of(TestBackupManager.rutaDb), StandardCopyOption.REPLACE_EXISTING);
            support = new TestDatabaseSupport();
            support.insertarCatalogosBase();
            employeeService = new EmployeeService();
        } catch (IOException e) {
            fail("No se pudo restaurar la base de datos de prueba: " + e.getMessage());
        }
    }

    @Test
    void crearEmpleadoValidoFunciona() {
        assertTrue(employeeService.crear(TestDataFactory.manager1()));
        assertNotNull(employeeService.buscarPorId(1));
    }

    @Test
    void noPermiteCrearEmpleadoConNombreNulo() {
        Employee employee = TestDataFactory.employee1();
        employee.setName(null);
        assertFalse(employeeService.crear(employee));
    }

    @Test
    void noPermiteCrearEmpleadoConApellidoVacio() {
        Employee employee = TestDataFactory.employee1();
        employee.setSurname(" ");
        assertFalse(employeeService.crear(employee));
    }

    @Test
    void noPermiteCrearEmpleadoSinRolExistente() {
        Employee employee = TestDataFactory.employee1();
        employee.setRolId(999);
        assertFalse(employeeService.crear(employee));
    }

    @Test
    void noPermiteCrearEmpleadoConManagerInexistente() {
        Employee employee = TestDataFactory.employee1();
        employee.setReportsTo(999);
        assertFalse(employeeService.crear(employee));
    }

    @Test
    void listarTodosEmpiezaVacio() {
        assertEquals(0, employeeService.listarTodos().size());
    }

    @Test
    void actualizarEmpleadoExistenteFunciona() {
        employeeService.crear(TestDataFactory.manager1());
        Employee employee = TestDataFactory.employee1();
        employeeService.crear(employee);
        employee.setSurname("Garcia");
        assertTrue(employeeService.actualizar(employee));
        assertEquals("Garcia", employeeService.buscarPorId(2).getSurname());
    }

    @Test
    void noPermiteActualizarEmpleadoInexistente() {
        assertFalse(employeeService.actualizar(TestDataFactory.employee1()));
    }

    @Test
    void eliminarEmpleadoExistenteFunciona() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        assertTrue(employeeService.eliminar(2));
        assertNull(employeeService.buscarPorId(2));
    }

    @Test
    void listarPorRolDevuelveCoincidencias() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        employeeService.crear(TestDataFactory.employee2());
        employeeService.crear(TestDataFactory.employee3OtroRol());
        assertEquals(2, employeeService.listarPorRol(2).size());
    }

    @Test
    void listarManagersSoloIncluyeManagers() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        employeeService.crear(TestDataFactory.employee2());
        assertEquals(1, employeeService.listarManagers().size());
    }

    @Test
    void cambiarManagerFuncionaSiExiste() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        employeeService.crear(TestDataFactory.employee2());
        assertTrue(employeeService.cambiarManager(3, 2));
        assertEquals(2, employeeService.buscarPorId(3).getReportsTo());
    }

    @Test
    void contarSubordinadosFunciona() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        employeeService.crear(TestDataFactory.employee2());
        assertEquals(2, employeeService.contarSubordinados(1));
    }

    @Test
    void buscarPorApellidoIgnoraMayusculas() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee2());
        assertEquals(1, employeeService.buscarPorApellido("lopez").size());
    }

    @Test
    void restauracionDeBackupAislaLosTests() {
        employeeService.crear(TestDataFactory.manager1());
        assertEquals(1, employeeService.listarTodos().size());
    }
}
