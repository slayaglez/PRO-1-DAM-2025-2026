package com.ejemplo.service;


import com.ejemplo.model.Propietario;
import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

class PropietarioServiceSqliteTest {

    private IPropietarioService servicePropietario;


    @BeforeEach
    void setUp() {
        try {
            Files.copy(
                    Path.of(TestBackupManager.rutaBackupDb),
                    Path.of(TestBackupManager.rutaDb),
                    StandardCopyOption.REPLACE_EXISTING);
            servicePropietario = new PropietarioService();
        } catch (IOException e) {
            fail("No se pudo restaurar la base de datos de prueba: " + e.getMessage());
        }
    }


    @Test
    void crearPropietarioValidoFunciona() {
        assertTrue(servicePropietario.crear(TestDataFactory.propietario1()));
        assertNotNull(servicePropietario.buscarPorDni("11111111A"));
    }

    @Test
    void crearDosClientesValidosFunciona() {
        assertTrue(servicePropietario.crear(TestDataFactory.propietario1()));
        assertTrue(servicePropietario.crear(TestDataFactory.propietario2()));
        assertEquals(2, servicePropietario.listarTodos().size());
    }

    @Test
    void noPermiteCrearPropietarioConDniNulo() {
        Propietario propietario = TestDataFactory.propietario1();
        propietario.setDni(null);
        assertFalse(servicePropietario.crear(propietario));
    }

    @Test
    void noPermiteCrearPropietarioConDniVacio() {
        Propietario propietario = TestDataFactory.propietario1();
        propietario.setDni(" ");
        assertFalse(servicePropietario.crear(propietario));
    }

    @Test
    void noPermiteCrearPropietarioConNombreNulo() {
        Propietario propietario = TestDataFactory.propietario1();
        propietario.setNombre(null);
        assertFalse(servicePropietario.crear(propietario));
    }

    @Test
    void noPermiteCrearPropietarioConNombreVacio() {
        Propietario propietario = TestDataFactory.propietario1();
        propietario.setNombre("  ");
        assertFalse(servicePropietario.crear(propietario));
    }

    @Test
    void noPermiteCrearPropietarioDuplicado() {
        assertTrue(servicePropietario.crear(TestDataFactory.propietario1()));
        assertFalse(servicePropietario.crear(TestDataFactory.propietario1()));
        assertEquals(1, servicePropietario.listarTodos().size());
    }

    @Test
    void buscarPorDniExistenteDevuelvePropietario() {
        servicePropietario.crear(TestDataFactory.propietario1());
        assertEquals("Ana", servicePropietario.buscarPorDni("11111111A").getNombre());
    }

    @Test
    void buscarPorDniInexistenteDevuelveNull() {
        assertNull(servicePropietario.buscarPorDni("99999999Z"));
    }

    @Test
    void listarTodosEmpiezaVacioEnCadaTest() {
        assertEquals(0, servicePropietario.listarTodos().size());
    }

    @Test
    void actualizarPropietarioExistenteFunciona() {
        Propietario propietario = TestDataFactory.propietario1();
        servicePropietario.crear(propietario);
        propietario.setCiudad("Valencia");
        assertTrue(servicePropietario.actualizar(propietario));
        assertEquals("Valencia", servicePropietario.buscarPorDni(propietario.getDni()).getCiudad());
    }

    @Test
    void noPermiteActualizarPropietarioInexistente() {
        assertFalse(servicePropietario.actualizar(TestDataFactory.propietario1()));
    }

    @Test
    void noPermiteActualizarPropietarioInvalido() {
        Propietario propietario = TestDataFactory.propietario1();
        servicePropietario.crear(propietario);
        propietario.setNombre(" ");
        assertFalse(servicePropietario.actualizar(propietario));
    }

    @Test
    void eliminarPropietarioExistenteFunciona() {
        servicePropietario.crear(TestDataFactory.propietario1());
        assertTrue(servicePropietario.eliminar("11111111A"));
        assertNull(servicePropietario.buscarPorDni("11111111A"));
    }

    @Test
    void eliminarPropietarioInexistenteDevuelveFalse() {
        assertFalse(servicePropietario.eliminar("11111111A"));
    }

    @Test
    void listarActivosSoloIncluyeActivos() {
        servicePropietario.crear(TestDataFactory.propietario1());
        servicePropietario.crear(TestDataFactory.propietario3Inactivo());
        assertEquals(1, servicePropietario.listarActivos().size());
    }

    @Test
    void contarActivosFunciona() {
        servicePropietario.crear(TestDataFactory.propietario1());
        servicePropietario.crear(TestDataFactory.propietario2());
        servicePropietario.crear(TestDataFactory.propietario3Inactivo());
        assertEquals(2, servicePropietario.contarActivos());
    }

    @Test
    void buscarPorCiudadEncuentraCoincidencias() {
        servicePropietario.crear(TestDataFactory.propietario1());
        servicePropietario.crear(TestDataFactory.propietario2());
        servicePropietario.crear(TestDataFactory.propietario3Inactivo());
        assertEquals(2, servicePropietario.buscarPorCiudad("Madrid").size());
    }

    @Test
    void buscarPorCiudadIgnoraMayusculas() {
        servicePropietario.crear(TestDataFactory.propietario1());
        assertEquals(1, servicePropietario.buscarPorCiudad("madrid").size());
    }

    @Test
    void buscarPorCiudadSinCoincidenciasDevuelveVacio() {
        servicePropietario.crear(TestDataFactory.propietario1());
        assertEquals(0, servicePropietario.buscarPorCiudad("Bilbao").size());
    }

    @Test
    void crearPropietarioInactivoEsValido() {
        assertTrue(servicePropietario.crear(TestDataFactory.propietario3Inactivo()));
        assertFalse(servicePropietario.buscarPorDni("33333333C").isActivo());
    }

    @Test
    void restauracionDeBackupAislaLosTests() {
        servicePropietario.crear(TestDataFactory.propietario1());
        assertEquals(1, servicePropietario.listarTodos().size());
    }
}
