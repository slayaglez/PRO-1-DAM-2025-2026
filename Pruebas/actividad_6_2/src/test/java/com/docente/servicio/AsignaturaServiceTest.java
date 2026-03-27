package com.docente.servicio;

import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAsignaturaRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AsignaturaServiceTest {

    private AsignaturaService service;

    @BeforeEach
    void setUp() {
        service = new AsignaturaService(new AsignaturaRepositorioMemoria(List.of(
                new Asignatura("PROG", "Programación", 8)
        )));
    }

    @Test
    void crearAsignaturaOk() {
        assertTrue(service.crearAsignatura("BBDD", "Bases de Datos", 6));
        assertNotNull(service.buscarAsignatura("BBDD"));
    }

    @Test
    void crearAsignaturaDuplicadaDevuelveFalse() {
        assertFalse(service.crearAsignatura("PROG", "Programación", 8));
    }

    @Test
    void readDevuelveListaConAsignaturas() {
        List<String> resultado = service.read();
        assertEquals(1, resultado.size());
        assertTrue(resultado.get(0).contains("Programación"));
    }

    @Test
    void buscarAsignaturaExistenteDevuelveObjeto() {
        Asignatura asignatura = service.buscarAsignatura("PROG");
        assertNotNull(asignatura);
        assertEquals(8, asignatura.getHorasSemanales());
    }

    @Test
    void actualizarAsignaturaExistenteModificaDatos() {
        assertTrue(service.actualizarAsignatura("PROG", "Programación Java", 9));
        Asignatura actualizada = service.buscarAsignatura("PROG");
        assertEquals("Programación Java", actualizada.getNombre());
        assertEquals(9, actualizada.getHorasSemanales());
    }

    @Test
    void deleteAsignaturaExistenteEliminaElemento() {
        assertTrue(service.deleteAsignatura("PROG"));
        assertNull(service.buscarAsignatura("PROG"));
    }

    private static class AsignaturaRepositorioMemoria implements IAsignaturaRepositorio {
        private final List<Asignatura> asignaturas;

        AsignaturaRepositorioMemoria(List<Asignatura> iniciales) {
            this.asignaturas = new ArrayList<>(iniciales);
        }

        @Override
        public List<Asignatura> obtenerAsignaturas() {
            return new ArrayList<>(asignaturas);
        }

        @Override
        public boolean guardarAsignaturas(List<Asignatura> asignaturas) {
            this.asignaturas.clear();
            this.asignaturas.addAll(asignaturas);
            return true;
        }
    }
}
