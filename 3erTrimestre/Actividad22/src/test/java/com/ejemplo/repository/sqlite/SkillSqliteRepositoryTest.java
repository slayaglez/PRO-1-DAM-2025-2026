package com.ejemplo.repository.sqlite;

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
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkillSqliteRepositoryTest {

    private SkillSqliteRepository repository;
    private TestDatabaseSupport support;
    private EmployeeSqliteRepository employeeRepository;

    @BeforeEach
    void setUp() {
        try {
            Files.copy(Path.of(TestBackupManager.rutaBackupDb), Path.of(TestBackupManager.rutaDb), StandardCopyOption.REPLACE_EXISTING);
            support = new TestDatabaseSupport();
            support.insertarCatalogosBase();
            repository = new SkillSqliteRepository();
            employeeRepository = new EmployeeSqliteRepository();
        } catch (IOException e) {
            fail("No se pudo restaurar la base de datos de prueba: " + e.getMessage());
        }
    }

    private void crearSkillsBase() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        assertTrue(repository.create(TestDataFactory.skillSql()));
        assertTrue(repository.create(TestDataFactory.skillDocker()));
    }

    @Test
    void createSkillValidaPersisteCorrectamente() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        assertEquals("Java", repository.findById(1).getName());
    }

    @Test
    void createConIdDuplicadoDevuelveFalse() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        assertFalse(repository.create(TestDataFactory.skillJava()));
    }

    @Test
    void createConNombreDuplicadoDevuelveFalse() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        Skill duplicada = new Skill(9, "Java", 1);
        assertFalse(repository.create(duplicada));
    }

    @Test
    void createConCategoriaInexistenteFallaPorIntegridad() {
        assertFalse(repository.create(new Skill(1, "Rust", 999)));
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
    void findAllDevuelveTodasOrdenadasPorId() {
        crearSkillsBase();
        List<Integer> ids = repository.findAll().stream().map(Skill::getId).toList();
        assertEquals(List.of(1, 2, 3), ids);
    }

    @Test
    void findByIdMapeaCorrectamenteTodosLosCampos() {
        assertTrue(repository.create(TestDataFactory.skillSql()));
        Skill skill = repository.findById(2);
        assertAll(
                () -> assertEquals(2, skill.getId()),
                () -> assertEquals("SQL", skill.getName()),
                () -> assertEquals(2, skill.getCategoryId())
        );
    }

    @Test
    void updateSkillExistenteModificaNombre() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        Skill skill = repository.findById(1);
        skill.setName("Java SE");
        assertTrue(repository.update(skill));
        assertEquals("Java SE", repository.findById(1).getName());
    }

    @Test
    void updateSkillExistenteModificaCategoria() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        Skill skill = repository.findById(1);
        skill.setCategoryId(2);
        assertTrue(repository.update(skill));
        assertEquals(2, repository.findById(1).getCategoryId());
    }

    @Test
    void updateSkillInexistenteDevuelveFalse() {
        assertFalse(repository.update(TestDataFactory.skillJava()));
    }

    @Test
    void updateConNombreDuplicadoDevuelveFalse() {
        crearSkillsBase();
        Skill skill = repository.findById(2);
        skill.setName("Java");
        assertFalse(repository.update(skill));
    }

    @Test
    void updateConCategoriaInexistenteDevuelveFalse() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        Skill skill = repository.findById(1);
        skill.setCategoryId(999);
        assertFalse(repository.update(skill));
    }

    @Test
    void deleteSkillExistenteDevuelveTrue() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        assertTrue(repository.deleteById(1));
        assertNull(repository.findById(1));
    }

    @Test
    void deleteSkillInexistenteDevuelveFalse() {
        assertFalse(repository.deleteById(999));
    }

    @Test
    void deleteSkillAsignadaFallaPorIntegridad() {
        assertTrue(employeeRepository.create(TestDataFactory.manager1()));
        assertTrue(employeeRepository.create(TestDataFactory.employee1()));
        assertTrue(repository.create(TestDataFactory.skillJava()));
        assertEquals(0, support.contarFilas("employee_skill"));
        try (var connection = SQLiteConnectionManager.openConnection();
             var ps = connection.prepareStatement("INSERT INTO employee_skill (employee_id, skill_id, level_id) VALUES (?,?,?)")) {
            ps.setInt(1, 2);
            ps.setInt(2, 1);
            ps.setString(3, "advanced");
            ps.executeUpdate();
        } catch (Exception e) {
            fail(e.getMessage());
        }
        assertFalse(repository.deleteById(1));
    }

    @Test
    void createPermiteDistintosNombresEnMismaCategoria() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        assertTrue(repository.create(new Skill(9, "Python", 1)));
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void createPermiteMismoCategoryIdEnVariasSkills() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        assertTrue(repository.create(new Skill(9, "Python", 1)));
        assertEquals(List.of(1, 9), repository.findAll().stream().map(Skill::getId).toList());
    }

    @Test
    void findAllTrasDeleteReduceCantidad() {
        crearSkillsBase();
        assertTrue(repository.deleteById(2));
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void updateNoCambiaNadaSiValoresSonIgualesPeroDevuelveTrue() {
        assertTrue(repository.create(TestDataFactory.skillJava()));
        Skill skill = repository.findById(1);
        assertTrue(repository.update(skill));
        assertEquals("Java", repository.findById(1).getName());
    }
}
