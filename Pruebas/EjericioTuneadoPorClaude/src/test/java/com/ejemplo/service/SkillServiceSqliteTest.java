package com.ejemplo.service;

import com.ejemplo.model.Skill;
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

class SkillServiceSqliteTest {

    private IEmployeeService employeeService;
    private ISkillService skillService;

    @BeforeEach
    void setUp() {
        try {
            Files.copy(Path.of(TestBackupManager.rutaBackupDb), Path.of(TestBackupManager.rutaDb), StandardCopyOption.REPLACE_EXISTING);
            TestDatabaseSupport support = new TestDatabaseSupport();
            support.insertarCatalogosBase();
            employeeService = new EmployeeService();
            skillService = new SkillService();
        } catch (IOException e) {
            fail("No se pudo restaurar la base de datos de prueba: " + e.getMessage());
        }
    }

    @Test
    void crearSkillValidaFunciona() {
        assertTrue(skillService.crear(TestDataFactory.skillJava()));
        assertNotNull(skillService.buscarPorId(1));
    }

    @Test
    void noPermiteCrearSkillConNombreVacio() {
        Skill skill = TestDataFactory.skillJava();
        skill.setName(" ");
        assertFalse(skillService.crear(skill));
    }

    @Test
    void noPermiteCrearSkillDuplicada() {
        assertTrue(skillService.crear(TestDataFactory.skillJava()));
        assertFalse(skillService.crear(TestDataFactory.skillJava()));
    }

    @Test
    void noPermiteCrearSkillConCategoriaInexistente() {
        Skill skill = TestDataFactory.skillJava();
        skill.setCategoryId(999);
        assertFalse(skillService.crear(skill));
    }

    @Test
    void listarTodasEmpiezaVacio() {
        assertEquals(0, skillService.listarTodas().size());
    }

    @Test
    void actualizarSkillExistenteFunciona() {
        skillService.crear(TestDataFactory.skillJava());
        Skill skill = TestDataFactory.skillJava();
        skill.setName("Java SE");
        assertTrue(skillService.actualizar(skill));
        assertEquals("Java SE", skillService.buscarPorId(1).getName());
    }

    @Test
    void eliminarSkillExistenteFunciona() {
        skillService.crear(TestDataFactory.skillJava());
        assertTrue(skillService.eliminar(1));
        assertNull(skillService.buscarPorId(1));
    }

    @Test
    void listarPorCategoriaDevuelveCoincidencias() {
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(TestDataFactory.skillSql());
        skillService.crear(TestDataFactory.skillDocker());
        assertEquals(1, skillService.listarPorCategoria(1).size());
    }

    @Test
    void asignarEmpleadoFuncionaSiEmployeeYSkillExisten() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        skillService.crear(TestDataFactory.skillJava());
        assertTrue(skillService.asignarEmpleado(2, 1, "advanced"));
        assertEquals(1, skillService.listarPorEmpleado(2).size());
    }

    @Test
    void noPermiteAsignarSkillDuplicadaAlMismoEmpleado() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        skillService.crear(TestDataFactory.skillJava());
        assertTrue(skillService.asignarEmpleado(2, 1, "advanced"));
        assertFalse(skillService.asignarEmpleado(2, 1, "advanced"));
    }

    @Test
    void contarEmpleadosConSkillFunciona() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        employeeService.crear(TestDataFactory.employee2());
        skillService.crear(TestDataFactory.skillJava());
        skillService.asignarEmpleado(2, 1, "advanced");
        skillService.asignarEmpleado(3, 1, "intermediate");
        assertEquals(2, skillService.contarEmpleadosConSkill(1));
    }

    @Test
    void listarSinAsignarIncluyeSkillsSinUso() {
        employeeService.crear(TestDataFactory.manager1());
        employeeService.crear(TestDataFactory.employee1());
        skillService.crear(TestDataFactory.skillJava());
        skillService.crear(TestDataFactory.skillSql());
        skillService.asignarEmpleado(2, 1, "advanced");
        assertEquals(1, skillService.listarSinAsignar().size());
    }

    @Test
    void restauracionDeBackupAislaLosTests() {
        skillService.crear(TestDataFactory.skillJava());
        assertEquals(1, skillService.listarTodas().size());
    }
}
