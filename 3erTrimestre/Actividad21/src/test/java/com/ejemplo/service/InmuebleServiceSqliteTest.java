package com.ejemplo.service;

import com.ejemplo.model.Inmueble;
import com.ejemplo.support.TestBackupManager;
import com.ejemplo.support.TestDataFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

class InmuebleServiceSqliteTest {


    private IInmuebleService inmuebleService;
    private IPropietarioService propietarioService;

    @BeforeEach
    void setUp() {
        try {

            Files.copy(
                    Path.of(TestBackupManager.rutaBackupDb),
                    Path.of(TestBackupManager.rutaDb),
                    StandardCopyOption.REPLACE_EXISTING);
            propietarioService = new PropietarioService();
            inmuebleService = new InmuebleService();
        } catch (IOException e) {
            fail("No se pudo restaurar la base de datos de prueba: " + e.getMessage());
        }
    }

    private void crearPropietariosBase() {
        propietarioService.crear(TestDataFactory.propietario1());
        propietarioService.crear(TestDataFactory.propietario2());
        propietarioService.crear(TestDataFactory.propietario3Inactivo());
    }

    @Test
    void crearInmuebleValidoFunciona() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        assertTrue(inmuebleService.crear(inmueble));
        assertNotNull(inmueble.getId());
    }

    @Test
    void noPermiteCrearInmuebleSinPropietarioExistente() {
        assertFalse(inmuebleService.crear(TestDataFactory.inmueble1("11111111A")));
    }

    @Test
    void noPermiteCrearInmuebleConMatriculaVacia() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmueble.setMatricula(" ");
        assertFalse(inmuebleService.crear(inmueble));
    }

    @Test
    void noPermiteCrearInmuebleConTipoVacia() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmueble.setTipo(" ");
        assertFalse(inmuebleService.crear(inmueble));
    }

    @Test
    void noPermiteCrearInmuebleConModeloVacio() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmueble.setModelo(" ");
        assertFalse(inmuebleService.crear(inmueble));
    }

    @Test
    void noPermiteCrearInmuebleConKilometrosNegativos() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmueble.setKilometros(-1);
        assertFalse(inmuebleService.crear(inmueble));
    }

    @Test
    void noPermiteCrearInmuebleConPrecioNoPositivo() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmueble.setPrecio(0.0);
        assertFalse(inmuebleService.crear(inmueble));
    }

    @Test
    void noPermiteCrearInmuebleDuplicadoPorMatricula() {
        crearPropietariosBase();
        assertTrue(inmuebleService.crear(TestDataFactory.inmueble1("11111111A")));
        assertFalse(inmuebleService.crear(TestDataFactory.inmueble1("11111111A")));
    }

    @Test
    void buscarPorIdExistenteDevuelveInmueble() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmuebleService.crear(inmueble);
        assertEquals("Piso", inmuebleService.buscarPorId(inmueble.getId()).getTipo());
    }

    @Test
    void buscarPorIdInexistenteDevuelveNull() {
        assertNull(inmuebleService.buscarPorId(99L));
    }

    @Test
    void listarTodosEmpiezaVacioEnCadaTest() {
        assertEquals(0, inmuebleService.listarTodos().size());
    }

    @Test
    void actualizarInmuebleExistenteFunciona() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmuebleService.crear(inmueble);
        inmueble.setColor("Blanco");
        assertTrue(inmuebleService.actualizar(inmueble));
        assertEquals("Blanco", inmuebleService.buscarPorId(inmueble.getId()).getColor());
    }

    @Test
    void noPermiteActualizarInmuebleInexistente() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmueble.setId(999L);
        assertFalse(inmuebleService.actualizar(inmueble));
    }

    @Test
    void noPermiteActualizarInmuebleConPropietarioInexistente() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmuebleService.crear(inmueble);
        inmueble.setDniPropietario("99999999Z");
        assertFalse(inmuebleService.actualizar(inmueble));
    }

    @Test
    void eliminarInmuebleExistenteFunciona() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmuebleService.crear(inmueble);
        assertTrue(inmuebleService.eliminar(inmueble.getId()));
        assertNull(inmuebleService.buscarPorId(inmueble.getId()));
    }

    @Test
    void eliminarInmuebleInexistenteDevuelveFalse() {
        assertFalse(inmuebleService.eliminar(1L));
    }

    @Test
    void listarPorPropietarioDevuelveSusInmuebles() {
        crearPropietariosBase();
        inmuebleService.crear(TestDataFactory.inmueble1("11111111A"));
        inmuebleService.crear(TestDataFactory.inmueble2("11111111A"));
        inmuebleService.crear(TestDataFactory.inmueble3Vendido("22222222B"));
        assertEquals(2, inmuebleService.listarPorPropietario("11111111A").size());
    }

    @Test
    void listarVendidosSoloIncluyeVendidos() {
        crearPropietariosBase();
        inmuebleService.crear(TestDataFactory.inmueble1("11111111A"));
        inmuebleService.crear(TestDataFactory.inmueble3Vendido("22222222B"));
        assertEquals(1, inmuebleService.listarVendidos().size());
    }

    @Test
    void listarDisponiblesSoloIncluyeNoVendidos() {
        crearPropietariosBase();
        inmuebleService.crear(TestDataFactory.inmueble1("11111111A"));
        inmuebleService.crear(TestDataFactory.inmueble3Vendido("22222222B"));
        assertEquals(1, inmuebleService.listarDisponibles().size());
    }

    @Test
    void cambiarPropietarioFuncionaSiNuevoPropietarioExiste() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmuebleService.crear(inmueble);
        assertTrue(inmuebleService.cambiarPropietario(inmueble.getId(), "22222222B"));
        assertEquals("22222222B", inmuebleService.buscarPorId(inmueble.getId()).getDniPropietario());
    }

    @Test
    void cambiarPropietarioFallaSiInmuebleNoExiste() {
        crearPropietariosBase();
        assertFalse(inmuebleService.cambiarPropietario(999L, "22222222B"));
    }

    @Test
    void cambiarPropietarioFallaSiPropietarioNoExiste() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmuebleService.crear(inmueble);
        assertFalse(inmuebleService.cambiarPropietario(inmueble.getId(), "99999999Z"));
    }

    @Test
    void tiporComoVendidoFuncionaUnaVez() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmuebleService.crear(inmueble);
        assertTrue(inmuebleService.tiporComoVendido(inmueble.getId()));
        assertTrue(inmuebleService.buscarPorId(inmueble.getId()).isVendido());
    }

    @Test
    void tiporComoVendidoFallaSiYaEstaVendido() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble3Vendido("11111111A");
        inmuebleService.crear(inmueble);
        assertFalse(inmuebleService.tiporComoVendido(inmueble.getId()));
    }

    @Test
    void tiporComoVendidoFallaSiNoExiste() {
        assertFalse(inmuebleService.tiporComoVendido(1L));
    }

    @Test
    void actualizarMetrosCuadradosFunciona() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmuebleService.crear(inmueble);
        assertTrue(inmuebleService.actualizarMetrosCuadrados(inmueble.getId(), 30000));
        assertEquals(30000, inmuebleService.buscarPorId(inmueble.getId()).getKilometros());
    }

    @Test
    void actualizarMetrosCuadradosFallaSiValorEsNegativo() {
        crearPropietariosBase();
        Inmueble inmueble = TestDataFactory.inmueble1("11111111A");
        inmuebleService.crear(inmueble);
        assertFalse(inmuebleService.actualizarMetrosCuadrados(inmueble.getId(), -10));
    }

    @Test
    void actualizarMetrosCuadradosFallaSiInmuebleNoExiste() {
        assertFalse(inmuebleService.actualizarMetrosCuadrados(1L, 100));
    }

    @Test
    void calcularPrecioMedioDevuelveCeroSinInmuebles() {
        assertEquals(0.0, inmuebleService.calcularPrecioMedio(), 0.001);
    }

    @Test
    void calcularPrecioMedioFunciona() {
        crearPropietariosBase();
        inmuebleService.crear(TestDataFactory.inmueble1("11111111A"));
        inmuebleService.crear(TestDataFactory.inmueble2("11111111A"));
        assertEquals(11150.0, inmuebleService.calcularPrecioMedio(), 0.001);
    }

    @Test
    void calcularValorTotalDisponibleSumaSoloNoVendidos() {
        crearPropietariosBase();
        inmuebleService.crear(TestDataFactory.inmueble1("11111111A"));
        inmuebleService.crear(TestDataFactory.inmueble2("11111111A"));
        inmuebleService.crear(TestDataFactory.inmueble3Vendido("22222222B"));
        assertEquals(22300.0, inmuebleService.calcularValorTotalDisponible(), 0.001);
    }

    @Test
    void contarInmueblesDePropietarioFunciona() {
        crearPropietariosBase();
        inmuebleService.crear(TestDataFactory.inmueble1("11111111A"));
        inmuebleService.crear(TestDataFactory.inmueble2("11111111A"));
        assertEquals(2, inmuebleService.contarInmueblesDePropietario("11111111A"));
    }

    @Test
    void crearInmuebleParaPropietarioInactivoEsValidoPorqueExiste() {
        crearPropietariosBase();
        assertTrue(inmuebleService.crear(TestDataFactory.inmueble1("33333333C")));
    }

    @Test
    void restauracionDeBackupAislaLosTests() {
        crearPropietariosBase();
        assertEquals(0, inmuebleService.listarTodos().size());
    }
}
