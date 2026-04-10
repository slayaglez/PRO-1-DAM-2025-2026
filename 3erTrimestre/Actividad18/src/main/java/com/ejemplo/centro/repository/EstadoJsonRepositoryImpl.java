package com.ejemplo.centro.repository;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.ejemplo.centro.model.EstadoCentro;
import com.ejemplo.centro.model.Evaluacion;
import com.ejemplo.centro.model.Incidencia;
import com.ejemplo.centro.util.JsonManager;

public class EstadoJsonRepositoryImpl implements EstadoJsonRepository {
    private final Path jsonPath;
    private final JsonManager jsonManager;
    private final EstadoCentro estado;

    public EstadoJsonRepositoryImpl(Path jsonPath) {
        this(jsonPath, new JsonManager());
    }

    public EstadoJsonRepositoryImpl(Path jsonPath, JsonManager jsonManager) {
        this.jsonPath = jsonPath;
        this.jsonManager = jsonManager;
        this.estado = jsonManager.read(jsonPath);
    }

    @Override
    public void saveEvaluacion(Evaluacion evaluacion) {

        if (evaluacion == null || evaluacion.getAlumno() == null || evaluacion.getAlumno().isBlank()
                || evaluacion.getModuloId() == null || evaluacion.getModuloId().isBlank()
                || evaluacion.getNota() < 0) {

            throw new IllegalArgumentException();
        }

        List<Evaluacion> evaluaciones = estado.getEvaluaciones();

        // si la evaluacion ya existe, sobreescribo
        if (evaluaciones.contains(evaluacion)) {
            for (int i = 0; i < evaluaciones.size(); i++) {
                Evaluacion evaluacion2 = evaluaciones.get(i);
                if (evaluacion2.getModuloId().equals(evaluacion.getModuloId())
                        && evaluacion2.getAlumno().equals(evaluacion.getAlumno())) {
                    evaluaciones.get(i).setNota(evaluacion.getNota());
                    return;
                }
            }
        }

        evaluaciones.add(evaluacion);
        estado.setEvaluaciones(evaluaciones);
        jsonManager.write(jsonPath, estado);
    }

    @Override
    public List<Evaluacion> findAllEvaluaciones() {

        List<Evaluacion> evaluaciones = new ArrayList<>();
        evaluaciones.addAll(estado.getEvaluaciones());
        return evaluaciones;
    }

    @Override
    public List<Evaluacion> findEvaluacionesByModuloId(String moduloId) {

        if(moduloId == null || moduloId.isBlank()){
            return new ArrayList<>();
        }

        List<Evaluacion> evaluaciones = new ArrayList<>(estado.getEvaluaciones());
        List<Evaluacion> evaluacionesModulo = new ArrayList<>();

        for (Evaluacion evaluacion : evaluaciones) {
            if (evaluacion.getModuloId().equals(moduloId)) {
                evaluacionesModulo.add(evaluacion);
            }
        }
        return evaluacionesModulo;
    }

    @Override
    public void saveIncidencia(Incidencia incidencia) {
        if (incidencia == null || incidencia.getProfesorId() == null || incidencia.getProfesorId().isBlank()
                || incidencia.getDescripcion() == null || incidencia.getDescripcion().isBlank()
                || incidencia.getFecha() == null || incidencia.getFecha().isBlank()) {

            throw new IllegalArgumentException();
        }
        List<Incidencia> incidencias = estado.getIncidencias();
        incidencias.add(incidencia);
    }

    @Override
    public List<Incidencia> findAllIncidencias() {

        List<Incidencia> incidencias = new ArrayList<>();
        incidencias.addAll(estado.getIncidencias());
        return incidencias;
    }

    @Override
    public List<Incidencia> findIncidenciasByProfesorId(String profesorId) {

        if(profesorId == null || profesorId.isBlank()){
            return new ArrayList<>();
        }

        List<Incidencia> incidencias = new ArrayList<>(estado.getIncidencias());
        List<Incidencia> incidenciasProfesor = new ArrayList<>();

        for (Incidencia incidencia : incidencias) {
            if (incidencia.getProfesorId().equals(profesorId)) {
                incidenciasProfesor.add(incidencia);
            }
        }
        return incidenciasProfesor;
    }

}
