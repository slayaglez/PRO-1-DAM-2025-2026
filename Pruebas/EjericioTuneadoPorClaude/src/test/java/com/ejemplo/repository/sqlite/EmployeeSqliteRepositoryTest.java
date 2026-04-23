package com.ejemplo.repository.sqlite;

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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeSqliteRepositoryTest {

    private EmployeeSqliteRepository repository;
    private TestDatabaseSupport support;

    @BeforeEach
    void setUp() {
        try {
            Files.copy(Path.of(TestBackupManager.rutaBackupDb), Path.of(TestBackupManager.rutaDb), StandardCopyOption.REPLACE_EXISTING);
            support = new TestDatabaseSupport();
            support.insertarCatalogosBase();
            repository = new EmployeeSqliteRepository();
        } catch (IOException e) {
            fail("No se pudo restaurar la base de datos de prueba: " + e.getMessage());
        }
    }

    private void crearBase() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        assertTrue(repository.create(TestDataFactory.employee1()));
        assertTrue(repository.create(TestDataFactory.employee2()));
    }

    @Test
    void createEmpleadoValidoPersisteCorrectamente() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        Employee employee = repository.findById(1);
        assertNotNull(employee);
        assertEquals("Laura", employee.getName());
    }

    @Test
    void createConReportsToNullSeMapeaComoNull() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        assertNull(repository.findById(1).getReportsTo());
    }

    @Test
    void createConManagerExistentePersisteRelacion() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        assertTrue(repository.create(TestDataFactory.employee1()));
        assertEquals(1, repository.findById(2).getReportsTo());
    }

    @Test
    void createConIdDuplicadoDevuelveFalse() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        assertFalse(repository.create(TestDataFactory.manager1()));
    }

    @Test
    void createConRolInexistenteFallaPorIntegridad() {
        Employee employee = TestDataFactory.employee1();
        employee.setReportsTo(null);
        employee.setRolId(999);
        assertFalse(repository.create(employee));
    }

    @Test
    void createConManagerInexistenteFallaPorIntegridad() {
        assertFalse(repository.create(TestDataFactory.employee1()));
    }

    @Test
    void findByIdInexistenteDevuelveNull() {
        assertNull(repository.findById(999));
    }

    @Test
    void findAllEmpiezaVacio() {
        assertTrue(repository.findAll().isEmpty());
    }

    @Test
    void findAllDevuelveTodosOrdenadosPorId() {
        crearBase();
        List<Integer> ids = repository.findAll().stream().map(Employee::getId).toList();
        assertEquals(List.of(1, 2, 3), ids);
    }

    @Test
    void updateEmpleadoExistenteModificaDatos() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        Employee manager = repository.findById(1);
        manager.setSurname("Garcia");
        assertTrue(repository.update(manager));
        assertEquals("Garcia", repository.findById(1).getSurname());
    }

    @Test
    void updatePermiteCambiarManagerANull() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        assertTrue(repository.create(TestDataFactory.employee1()));
        Employee employee = repository.findById(2);
        employee.setReportsTo(null);
        assertTrue(repository.update(employee));
        assertNull(repository.findById(2).getReportsTo());
    }

    @Test
    void updateEmpleadoInexistenteDevuelveFalse() {
        assertFalse(repository.update(TestDataFactory.employee1()));
    }

    @Test
    void updateConRolInexistenteDevuelveFalse() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        Employee employee = repository.findById(1);
        employee.setRolId(999);
        assertFalse(repository.update(employee));
    }

    @Test
    void updateConManagerInexistenteDevuelveFalse() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        Employee employee = repository.findById(1);
        employee.setReportsTo(999);
        assertFalse(repository.update(employee));
    }

    @Test
    void deleteEmpleadoExistenteDevuelveTrue() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        assertTrue(repository.deleteById(1));
        assertNull(repository.findById(1));
    }

    @Test
    void deleteEmpleadoInexistenteDevuelveFalse() {
        assertFalse(repository.deleteById(999));
    }

    @Test
    void deleteManagerConSubordinadosFallaPorIntegridad() {
        crearBase();
        assertFalse(repository.deleteById(1));
        assertNotNull(repository.findById(1));
    }

    @Test
    void deleteEmpleadoConResumeFallaPorIntegridad() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        support.insertarResume(1, "resume", 10, 1);
        assertFalse(repository.deleteById(1));
    }

    @Test
    void findByIdMapeaCorrectamenteTodosLosCampos() {
        crearBase();
        Employee employee = repository.findById(2);
        assertAll(
                () -> assertEquals(2, employee.getId()),
                () -> assertEquals("Carlos", employee.getName()),
                () -> assertEquals("Sanchez", employee.getSurname()),
                () -> assertEquals("2020-04-01", employee.getStartDate()),
                () -> assertEquals(1, employee.getReportsTo()),
                () -> assertEquals(2, employee.getRolId())
        );
    }

    @Test
    void updatePuedeCambiarRol() {
        assertTrue(repository.create(TestDataFactory.manager1()));
        Employee employee = repository.findById(1);
        employee.setRolId(3);
        assertTrue(repository.update(employee));
        assertEquals(3, repository.findById(1).getRolId());
    }
}
