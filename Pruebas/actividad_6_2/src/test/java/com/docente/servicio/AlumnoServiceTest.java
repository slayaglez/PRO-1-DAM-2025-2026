package com.docente.servicio;

import com.docente.modelo.Alumno;
import com.docente.persistencia.IAlumnoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoServiceTest {

    private AlumnoService service;

    @BeforeEach
    void setUp() {
        service = new AlumnoService(new AlumnoRepositorioMemoria(List.of(
                new Alumno("ALU001", "Ana", 18, "1DAM")
        )));
    }

    @Test
    void crearAlumnoOk() {
        assertTrue(service.crearAlumno("ALU002", "Luis", 19, "1DAM"));
        assertNotNull(service.buscarAlumno("ALU002"));
    }

    @Test
    void crearAlumnoDuplicadoDevuelveFalse() {
        assertFalse(service.crearAlumno("ALU001", "Ana", 18, "1DAM"));
    }

    @Test
    void readDevuelveListaConContenido() {
        List<String> resultado = service.read();
        assertEquals(1, resultado.size());
        assertTrue(resultado.get(0).contains("Ana"));
    }

    @Test
    void buscarAlumnoExistenteDevuelveObjeto() {
        Alumno alumno = service.buscarAlumno("ALU001");
        assertNotNull(alumno);
        assertEquals("Ana", alumno.getNombre());
    }

    @Test
    void actualizarAlumnoExistenteModificaDatos() {
        assertTrue(service.actualizarAlumno("ALU001", "Ana María", 19, "2DAM"));
        Alumno actualizado = service.buscarAlumno("ALU001");
        assertEquals("Ana María", actualizado.getNombre());
        assertEquals(19, actualizado.getEdad());
        assertEquals("2DAM", actualizado.getCurso());
    }

    @Test
    void deleteAlumnoExistenteEliminaElemento() {
        assertTrue(service.deleteAlumno("ALU001"));
        assertNull(service.buscarAlumno("ALU001"));
    }

    private static class AlumnoRepositorioMemoria implements IAlumnoRepositorio {
        private final List<Alumno> alumnos;

        AlumnoRepositorioMemoria(List<Alumno> iniciales) {
            this.alumnos = new ArrayList<>(iniciales);
        }

        @Override
        public List<Alumno> obtenerAlumnos() {
            return new ArrayList<>(alumnos);
        }

        @Override
        public boolean guardarAlumnos(List<Alumno> alumnos) {
            this.alumnos.clear();
            this.alumnos.addAll(alumnos);
            return true;
        }
    }
}
