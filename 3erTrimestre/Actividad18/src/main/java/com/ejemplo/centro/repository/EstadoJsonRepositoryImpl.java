package com.ejemplo.centro.repository;

import com.ejemplo.centro.model.EstadoCentro;
import com.ejemplo.centro.model.Evaluacion;
import com.ejemplo.centro.model.Incidencia;
import com.ejemplo.centro.model.Profesor;
import com.ejemplo.centro.util.JsonManager;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        // defensiva udghewgfyuegw

        List<Evaluacion> evaluaciones = estado.getEvaluaciones();
        //List<Incidencia> incidencias = estado.getIncidencias();

        evaluaciones.add(evaluacion);

        // estado = evaluaciones + incidencias 
    }

    @Override
    public List<Evaluacion> findAllEvaluaciones() {
        
        List<Evaluacion> evaluaciones = new ArrayList<>();
        evaluaciones.addAll(estado.getEvaluaciones());
        return evaluaciones;
    }

    @Override
    public List<Evaluacion> findEvaluacionesByModuloId(String moduloId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findEvaluacionesByModuloId'");
    }

    @Override
    public void saveIncidencia(Incidencia incidencia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveIncidencia'");
    }

    @Override
    public List<Incidencia> findAllIncidencias() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllIncidencias'");
    }

    @Override
    public List<Incidencia> findIncidenciasByProfesorId(String profesorId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findIncidenciasByProfesorId'");
    }

    
}
