package com.docente.servicio;

import com.docente.modelo.AlumnoMatriculado;
import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAlumnoMatriculadoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AlumnoMatriculadoServiceTest {

    private AlumnoMatriculadoService service;

    @BeforeEach
    void setUp() {
        AlumnoMatriculado alumno = new AlumnoMatriculado("ALM001", "Lucia", 19, "1DAM");
        IAlumnoMatriculadoRepositorio repo = new AlumnoMatriculadoRepositorioMemoria(List.of(alumno));
        IAsignaturaService asignaturaService = new AsignaturaService(new AsignaturaRepositorioMemoria(List.of(
                new Asignatura("PROG", "Programación", 8),
                new Asignatura("BBDD", "Bases de Datos", 6)
        )));
        service = new AlumnoMatriculadoService(repo, asignaturaService);
    }

    @Test
    void crearAlumnoMatriculadoOk() {
        assertTrue(service.crearAlumnoMatriculado("ALM002", "Mario", 20, "1DAM"));
        assertNotNull(service.buscarAlumnoMatriculado("ALM002"));
    }

    @Test
    void matricularAsignaturaOk() {
        assertTrue(service.matricularAsignatura("ALM001", "PROG"));
        assertTrue(service.estaMatriculadoEn("ALM001", "PROG"));
    }

    @Test
    void matricularAsignaturaDuplicadaDevuelveFalse() {
        assertTrue(service.matricularAsignatura("ALM001", "PROG"));
        assertFalse(service.matricularAsignatura("ALM001", "PROG"));
    }

    @Test
    void getNumeroAsignaturasDevuelveTotalCorrecto() {
        service.matricularAsignatura("ALM001", "PROG");
        service.matricularAsignatura("ALM001", "BBDD");
        assertEquals(2, service.getNumeroAsignaturas("ALM001"));
    }

    @Test
    void estaMatriculadoEnDevuelveBooleanEsperado() {
        service.matricularAsignatura("ALM001", "PROG");
        assertTrue(service.estaMatriculadoEn("ALM001", "PROG"));
        assertFalse(service.estaMatriculadoEn("ALM001", "BBDD"));
    }

    @Test
    void desmatricularAsignaturaEliminaRelacion() {
        service.matricularAsignatura("ALM001", "PROG");
        assertTrue(service.desmatricularAsignatura("ALM001", "PROG"));
        assertFalse(service.estaMatriculadoEn("ALM001", "PROG"));
    }

    private static class AlumnoMatriculadoRepositorioMemoria implements IAlumnoMatriculadoRepositorio {
        private final List<AlumnoMatriculado> alumnos;

        AlumnoMatriculadoRepositorioMemoria(List<AlumnoMatriculado> iniciales) {
            this.alumnos = new ArrayList<>(iniciales);
        }

        @Override
        public List<AlumnoMatriculado> obtenerAlumnosMatriculados() {
            return new ArrayList<>(alumnos);
        }

        @Override
        public boolean guardarAlumnosMatriculados(List<AlumnoMatriculado> alumnosMatriculados) {
            this.alumnos.clear();
            this.alumnos.addAll(alumnosMatriculados);
            return true;
        }
    }

    private static class AsignaturaRepositorioMemoria implements com.docente.persistencia.IAsignaturaRepositorio {
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
