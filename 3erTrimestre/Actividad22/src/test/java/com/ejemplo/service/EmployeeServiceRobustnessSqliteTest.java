package com.ejemplo.service;

import com.ejemplo.model.Employee;
import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import com.ejemplo.support.TestDatabaseSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceRobustnessSqliteTest {

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

    private void crearJerarquiaBase() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        employeeService.crear(TestDataFactory.employee2());
        employeeService.crear(TestDataFactory.employee3OtroRol());
    }

    private Employee empleadoJuniorDependienteDe(int idManager) {
        return new Employee(5, "Lucia", "Prieto", "2023-03-01", idManager, 1);
    }

    @Test
    void crearEmpleadoNullDevuelveFalse() {
        assertFalse(employeeService.crear(null));
    }

    @Test
    void noPermiteCrearEmpleadoConIdNulo() {
        Employee employee = TestDataFactory.employee1();
        employee.setId(null);
        assertFalse(employeeService.crear(employee));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void noPermiteCrearEmpleadoConNombreVacioEnVariantes(String invalidName) {
        Employee employee = TestDataFactory.employee1();
        employee.setName(invalidName);
        assertFalse(employeeService.crear(employee));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void noPermiteCrearEmpleadoConApellidoVacioEnVariantes(String invalidSurname) {
        Employee employee = TestDataFactory.employee1();
        employee.setSurname(invalidSurname);
        assertFalse(employeeService.crear(employee));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void noPermiteCrearEmpleadoConStartDateVaciaEnVariantes(String invalidStartDate) {
        Employee employee = TestDataFactory.employee1();
        employee.setStartDate(invalidStartDate);
        assertFalse(employeeService.crear(employee));
    }

    @Test
    void noPermiteCrearEmpleadoConIdDuplicado() {
        assertTrue(employeeService.crear(TestDataFactory.manager1()));
        Employee duplicado = new Employee(1, "Otra", "Persona", "2024-01-01", null, 1);
        assertFalse(employeeService.crear(duplicado));
    }

    @Test
    void crearEmpleadoHaceTrimDeCamposTexto() {
        assertTrue(employeeService.crear(TestDataFactory.manager1()));
        Employee employee = new Employee(2, "  Carlos  ", "  Sanchez  ", " 2020-04-01 ", 1, 2);
        assertTrue(employeeService.crear(employee));
        Employee guardado = employeeService.buscarPorId(2);
        assertEquals("Carlos", guardado.getName());
        assertEquals("Sanchez", guardado.getSurname());
        assertEquals("2020-04-01", guardado.getStartDate());
    }

    @Test
    void buscarPorIdNullDevuelveNull() {
        assertNull(employeeService.buscarPorId(null));
    }

    @Test
    void buscarPorIdInexistenteDevuelveNull() {
        assertNull(employeeService.buscarPorId(999));
    }

    @Test
    void actualizarNullDevuelveFalse() {
        assertFalse(employeeService.actualizar(null));
    }

    @Test
    void noPermiteActualizarEmpleadoConIdNulo() {
        Employee employee = TestDataFactory.employee1();
        employee.setId(null);
        assertFalse(employeeService.actualizar(employee));
    }

    @Test
    void noPermiteActualizarEmpleadoConRolInexistente() {
        crearJerarquiaBase();
        Employee employee = employeeService.buscarPorId(2);
        employee.setRolId(999);
        assertFalse(employeeService.actualizar(employee));
    }

    @Test
    void noPermiteActualizarEmpleadoConManagerInexistente() {
        crearJerarquiaBase();
        Employee employee = employeeService.buscarPorId(2);
        employee.setReportsTo(999);
        assertFalse(employeeService.actualizar(employee));
    }

    @Test
    void noPermiteActualizarEmpleadoComoSuPropioManager() {
        crearJerarquiaBase();
        Employee employee = employeeService.buscarPorId(2);
        employee.setReportsTo(2);
        assertFalse(employeeService.actualizar(employee));
    }

    @Test
    void actualizarEmpleadoHaceTrimDeCampos() {
        assertTrue(employeeService.crear(TestDataFactory.manager1()));
        assertTrue(employeeService.crear(TestDataFactory.employee1()));
        Employee employee = employeeService.buscarPorId(2);
        employee.setName("  Carlos  ");
        employee.setSurname("  Garcia  ");
        employee.setStartDate(" 2020-05-01 ");
        assertTrue(employeeService.actualizar(employee));
        Employee actualizado = employeeService.buscarPorId(2);
        assertEquals("Carlos", actualizado.getName());
        assertEquals("Garcia", actualizado.getSurname());
        assertEquals("2020-05-01", actualizado.getStartDate());
    }

    @Test
    void eliminarNullDevuelveFalse() {
        assertFalse(employeeService.eliminar(null));
    }

    @Test
    void eliminarInexistenteDevuelveFalse() {
        assertFalse(employeeService.eliminar(999));
    }

    @Test
    void eliminarManagerConSubordinadosFallaPorIntegridadReferencial() {
        crearJerarquiaBase();
        assertFalse(employeeService.eliminar(1));
        assertNotNull(employeeService.buscarPorId(1));
    }

    @Test
    void eliminarEmpleadoConResumeFallaPorIntegridadReferencial() {
        assertTrue(employeeService.crear(TestDataFactory.manager1()));
        support.insertarResume(1, "Manager resume", 12, 1);
        assertFalse(employeeService.eliminar(1));
    }

    @Test
    void listarPorRolNullDevuelveVacio() {
        assertTrue(employeeService.listarPorRol(null).isEmpty());
    }

    @Test
    void listarPorRolSinCoincidenciasDevuelveVacio() {
        crearJerarquiaBase();
        assertTrue(employeeService.listarPorRol(999).isEmpty());
    }

    @Test
    void listarPorRolMantieneTodosLosDelRol() {
        crearJerarquiaBase();
        List<Employee> developers = employeeService.listarPorRol(2);
        assertEquals(2, developers.size());
        assertEquals(List.of(2, 3), developers.stream().map(Employee::getId).toList());
    }

    @Test
    void listarManagersVacioSiNoHayJerarquia() {
        assertTrue(employeeService.crear(new Employee(10, "A", "B", "2024-01-01", null, 1)));
        assertTrue(employeeService.listarManagers().isEmpty());
    }

    @Test
    void listarManagersIncluyeManagersIntermedios() {
        crearJerarquiaBase();
        assertTrue(employeeService.crear(empleadoJuniorDependienteDe(2)));
        List<Integer> managers = employeeService.listarManagers().stream().map(Employee::getId).sorted().toList();
        assertEquals(List.of(1, 2), managers);
    }

    @Test
    void cambiarManagerConEmpleadoNullFalla() {
        assertFalse(employeeService.cambiarManager(null, 1));
    }

    @Test
    void cambiarManagerConManagerNullFalla() {
        assertFalse(employeeService.cambiarManager(1, null));
    }

    @Test
    void cambiarManagerASiMismoFalla() {
        assertFalse(employeeService.cambiarManager(2, 2));
    }

    @Test
    void cambiarManagerConEmpleadoInexistenteFalla() {
        crearJerarquiaBase();
        assertFalse(employeeService.cambiarManager(999, 1));
    }

    @Test
    void cambiarManagerConManagerInexistenteFalla() {
        crearJerarquiaBase();
        assertFalse(employeeService.cambiarManager(2, 999));
    }

    @Test
    void cambiarManagerActualizaNumeroDeSubordinados() {
        crearJerarquiaBase();
        assertTrue(employeeService.cambiarManager(3, 2));
        assertEquals(2, employeeService.contarSubordinados(1));
        assertEquals(1, employeeService.contarSubordinados(2));
    }

    @Test
    void contarSubordinadosNullEsCero() {
        assertEquals(0, employeeService.contarSubordinados(null));
    }

    @Test
    void contarSubordinadosInexistenteEsCero() {
        crearJerarquiaBase();
        assertEquals(0, employeeService.contarSubordinados(999));
    }

    @Test
    void buscarPorApellidoNullDevuelveVacio() {
        assertTrue(employeeService.buscarPorApellido(null).isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void buscarPorApellidoVacioDevuelveVacio(String surname) {
        assertTrue(employeeService.buscarPorApellido(surname).isEmpty());
    }

    @Test
    void buscarPorApellidoHaceTrim() {
        crearJerarquiaBase();
        assertEquals(1, employeeService.buscarPorApellido("  Lopez  ").size());
    }

    @Test
    void buscarPorApellidoSinCoincidenciasDevuelveVacio() {
        crearJerarquiaBase();
        assertTrue(employeeService.buscarPorApellido("NoExiste").isEmpty());
    }

    @Test
    void noPermiteCrearEmpleadoComoSuPropioManager() {
        Employee employee = new Employee(20, "Eva", "Duran", "2024-01-01", 20, 1);
        assertFalse(employeeService.crear(employee));
    }

    @Test
    void listarTodosTrasCrearVariosMantieneOrdenPorId() {
        crearJerarquiaBase();
        List<Integer> ids = employeeService.listarTodos().stream().map(Employee::getId).toList();
        assertEquals(List.of(1, 2, 3, 4), ids);
    }

    @Test
    void listarTodosTrasEliminarReduceCantidad() {
        crearJerarquiaBase();
        assertTrue(employeeService.eliminar(4));
        assertEquals(3, employeeService.listarTodos().size());
    }
}
