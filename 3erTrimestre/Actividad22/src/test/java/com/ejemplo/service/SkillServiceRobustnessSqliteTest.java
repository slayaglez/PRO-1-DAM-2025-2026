package com.ejemplo.service;

import com.ejemplo.model.Employee;
import com.ejemplo.model.Skill;
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

class SkillServiceRobustnessSqliteTest {

    private IEmployeeService employeeService;
    private ISkillService skillService;
    private TestDatabaseSupport support;

    @BeforeEach
    void setUp() {
        try {
            Files.copy(Path.of(TestBackupManager.rutaBackupDb), Path.of(TestBackupManager.rutaDb), StandardCopyOption.REPLACE_EXISTING);
            support = new TestDatabaseSupport();
            support.insertarCatalogosBase();
            employeeService = new EmployeeService();
            skillService = new SkillService();
        } catch (IOException e) {
            fail("No se pudo restaurar la base de datos de prueba: " + e.getMessage());
        }
    }

    private void crearEmpleadoBase() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        employeeService.crear(TestDataFactory.employee2());
    }

    @Test
    void crearSkillNullDevuelveFalse() {
        assertFalse(skillService.crear(null));
    }

    @Test
    void noPermiteCrearSkillConIdNulo() {
        Skill skill = TestDataFactory.skillJava();
        skill.setId(null);
        assertFalse(skillService.crear(skill));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void noPermiteCrearSkillConNombreVacioEnVariantes(String invalidName) {
        Skill skill = TestDataFactory.skillJava();
        skill.setName(invalidName);
        assertFalse(skillService.crear(skill));
    }

    @Test
    void noPermiteCrearSkillConCategoriaNula() {
        Skill skill = TestDataFactory.skillJava();
        skill.setCategoryId(null);
        assertFalse(skillService.crear(skill));
    }

    @Test
    void noPermiteCrearSkillConIdDuplicado() {
        assertTrue(skillService.crear(TestDataFactory.skillJava()));
        Skill skill = new Skill(1, "Scala", 1);
        assertFalse(skillService.crear(skill));
    }

    @Test
    void noPermiteCrearSkillConNombreDuplicadoIgnorandoMayusculas() {
        assertTrue(skillService.crear(TestDataFactory.skillJava()));
        Skill duplicada = new Skill(99, "java", 1);
        assertFalse(skillService.crear(duplicada));
    }

    @Test
    void noPermiteCrearSkillConNombreDuplicadoIgnorandoEspacios() {
        assertTrue(skillService.crear(TestDataFactory.skillJava()));
        Skill duplicada = new Skill(99, "  Java  ", 1);
        assertFalse(skillService.crear(duplicada));
    }

    @Test
    void crearSkillHaceTrimDelNombre() {
        Skill skill = new Skill(1, "  Java  ", 1);
        assertTrue(skillService.crear(skill));
        assertEquals("Java", skillService.buscarPorId(1).getName());
    }

    @Test
    void buscarPorIdNullDevuelveNull() {
        assertNull(skillService.buscarPorId(null));
    }

    @Test
    void buscarPorIdInexistenteDevuelveNull() {
        assertNull(skillService.buscarPorId(999));
    }

    @Test
    void actualizarSkillNullDevuelveFalse() {
        assertFalse(skillService.actualizar(null));
    }

    @Test
    void noPermiteActualizarSkillConIdNulo() {
        Skill skill = TestDataFactory.skillJava();
        skill.setId(null);
        assertFalse(skillService.actualizar(skill));
    }

    @Test
    void noPermiteActualizarSkillInexistente() {
        assertFalse(skillService.actualizar(TestDataFactory.skillJava()));
    }

    @Test
    void noPermiteActualizarSkillConNombreVacio() {
        skillService.crear(TestDataFactory.skillJava());
        Skill skill = skillService.buscarPorId(1);
        skill.setName(" ");
        assertFalse(skillService.actualizar(skill));
    }

    @Test
    void noPermiteActualizarSkillConCategoriaNula() {
        skillService.crear(TestDataFactory.skillJava());
        Skill skill = skillService.buscarPorId(1);
        skill.setCategoryId(null);
        assertFalse(skillService.actualizar(skill));
    }

    @Test
    void noPermiteActualizarSkillConNombreDuplicadoExacto() {
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(TestDataFactory.skillSql());
        Skill skill = skillService.buscarPorId(2);
        skill.setName("Java");
        assertFalse(skillService.actualizar(skill));
    }

    @Test
    void noPermiteActualizarSkillConNombreDuplicadoIgnorandoMayusculas() {
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(TestDataFactory.skillSql());
        Skill skill = skillService.buscarPorId(2);
        skill.setName("java");
        assertFalse(skillService.actualizar(skill));
    }

    @Test
    void actualizarSkillHaceTrimDelNombre() {
        skillService.crear(TestDataFactory.skillJava());
        Skill skill = skillService.buscarPorId(1);
        skill.setName("  Java SE  ");
        assertTrue(skillService.actualizar(skill));
        assertEquals("Java SE", skillService.buscarPorId(1).getName());
    }

    @Test
    void eliminarSkillNullDevuelveFalse() {
        assertFalse(skillService.eliminar(null));
    }

    @Test
    void eliminarSkillInexistenteDevuelveFalse() {
        assertFalse(skillService.eliminar(999));
    }

    @Test
    void eliminarSkillAsignadaFallaPorIntegridadReferencial() {
        crearEmpleadoBase();
        skillService.crear(TestDataFactory.skillJava());
        assertTrue(skillService.asignarEmpleado(2, 1, "advanced"));
        assertFalse(skillService.eliminar(1));
    }

    @Test
    void listarPorCategoriaNullDevuelveVacio() {
        assertTrue(skillService.listarPorCategoria(null).isEmpty());
    }

    @Test
    void listarPorCategoriaSinCoincidenciasDevuelveVacio() {
        skillService.crear(TestDataFactory.skillJava());
        assertTrue(skillService.listarPorCategoria(999).isEmpty());
    }

    @Test
    void listarPorCategoriaConVariasSkillsDevuelveTodas() {
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(new Skill(4, "Python", 1));
        skillService.crear(TestDataFactory.skillSql());
        assertEquals(2, skillService.listarPorCategoria(1).size());
    }

    @Test
    void asignarEmpleadoConEmployeeNullFalla() {
        assertFalse(skillService.asignarEmpleado(null, 1, "advanced"));
    }

    @Test
    void asignarEmpleadoConSkillNullFalla() {
        assertFalse(skillService.asignarEmpleado(1, null, "advanced"));
    }

    @Test
    void asignarEmpleadoConEmpleadoInexistenteFalla() {
        skillService.crear(TestDataFactory.skillJava());
        assertFalse(skillService.asignarEmpleado(999, 1, "advanced"));
    }

    @Test
    void asignarEmpleadoConSkillInexistenteFalla() {
        crearEmpleadoBase();
        assertFalse(skillService.asignarEmpleado(2, 999, "advanced"));
    }

    @Test
    void asignarEmpleadoConLevelNullFunciona() {
        crearEmpleadoBase();
        skillService.crear(TestDataFactory.skillJava());
        assertTrue(skillService.asignarEmpleado(2, 1, null));
        assertNull(support.obtenerLevelAsignado(2, 1));
    }

    @Test
    void asignarEmpleadoHaceTrimDelLevel() {
        crearEmpleadoBase();
        skillService.crear(TestDataFactory.skillJava());
        assertTrue(skillService.asignarEmpleado(2, 1, "  advanced  "));
        assertEquals("advanced", support.obtenerLevelAsignado(2, 1));
    }

    @Test
    void listarPorEmpleadoNullDevuelveVacio() {
        assertTrue(skillService.listarPorEmpleado(null).isEmpty());
    }

    @Test
    void listarPorEmpleadoSinAsignacionesDevuelveVacio() {
        crearEmpleadoBase();
        skillService.crear(TestDataFactory.skillJava());
        assertTrue(skillService.listarPorEmpleado(2).isEmpty());
    }

    @Test
    void listarPorEmpleadoDevuelveSkillsOrdenadasPorId() {
        crearEmpleadoBase();
        skillService.crear(TestDataFactory.skillDocker());
        skillService.crear(TestDataFactory.skillJava());
        skillService.asignarEmpleado(2, 3, "basic");
        skillService.asignarEmpleado(2, 1, "advanced");
        List<Integer> ids = skillService.listarPorEmpleado(2).stream().map(Skill::getId).toList();
        assertEquals(List.of(1, 3), ids);
    }

    @Test
    void contarEmpleadosConSkillNullEsCero() {
        assertEquals(0, skillService.contarEmpleadosConSkill(null));
    }

    @Test
    void contarEmpleadosConSkillInexistenteEsCero() {
        assertEquals(0, skillService.contarEmpleadosConSkill(999));
    }

    @Test
    void contarEmpleadosConSkillSinAsignacionesEsCero() {
        skillService.crear(TestDataFactory.skillJava());
        assertEquals(0, skillService.contarEmpleadosConSkill(1));
    }

    @Test
    void listarSinAsignarSinSkillsDevuelveVacio() {
        assertTrue(skillService.listarSinAsignar().isEmpty());
    }

    @Test
    void listarSinAsignarCuandoTodasEstanAsignadasDevuelveVacio() {
        crearEmpleadoBase();
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(TestDataFactory.skillSql());
        skillService.asignarEmpleado(2, 1, "advanced");
        skillService.asignarEmpleado(2, 2, "advanced");
        assertTrue(skillService.listarSinAsignar().isEmpty());
    }

    @Test
    void listarSinAsignarConVariasNoAsignadasDevuelveCantidadCorrecta() {
        crearEmpleadoBase();
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(TestDataFactory.skillSql());
        skillService.crear(TestDataFactory.skillDocker());
        skillService.asignarEmpleado(2, 1, "advanced");
        assertEquals(2, skillService.listarSinAsignar().size());
    }

    @Test
    void crearVariasSkillsYListarTodasMantieneCantidad() {
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(TestDataFactory.skillSql());
        skillService.crear(TestDataFactory.skillDocker());
        assertEquals(3, skillService.listarTodas().size());
    }

    @Test
    void listarTodasTrasEliminarUnaReduceCantidad() {
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(TestDataFactory.skillSql());
        assertTrue(skillService.eliminar(2));
        assertEquals(1, skillService.listarTodas().size());
    }

    @Test
    void permiteAsignarMismaSkillADosEmpleadosDistintos() {
        crearEmpleadoBase();
        skillService.crear(TestDataFactory.skillJava());
        assertTrue(skillService.asignarEmpleado(2, 1, "advanced"));
        assertTrue(skillService.asignarEmpleado(3, 1, "intermediate"));
        assertEquals(2, skillService.contarEmpleadosConSkill(1));
    }

    @Test
    void permiteAsignarDosSkillsAUnMismoEmpleado() {
        crearEmpleadoBase();
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(TestDataFactory.skillSql());
        assertTrue(skillService.asignarEmpleado(2, 1, "advanced"));
        assertTrue(skillService.asignarEmpleado(2, 2, "intermediate"));
        assertEquals(2, skillService.listarPorEmpleado(2).size());
    }
}
