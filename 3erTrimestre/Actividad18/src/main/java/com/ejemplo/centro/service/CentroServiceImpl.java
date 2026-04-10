package com.ejemplo.centro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ejemplo.centro.model.Evaluacion;
import com.ejemplo.centro.model.Incidencia;
import com.ejemplo.centro.model.Modulo;
import com.ejemplo.centro.model.Profesor;
import com.ejemplo.centro.repository.CentroXmlRepository;
import com.ejemplo.centro.repository.EstadoJsonRepository;

public class CentroServiceImpl implements CentroService {

    private final CentroXmlRepository xmlRepository;
    private final EstadoJsonRepository jsonRepository;

    public CentroServiceImpl(CentroXmlRepository xmlRepository, EstadoJsonRepository jsonRepository) {
        this.xmlRepository = Objects.requireNonNull(xmlRepository);
        this.jsonRepository = Objects.requireNonNull(jsonRepository);
    }

    @Override
    public Profesor buscarProfesor(String profesorId) {

        return xmlRepository.findProfesorById(profesorId.trim());
    }

    @Override
    public Modulo buscarModulo(String moduloId) {
        
        return xmlRepository.findModuloById(moduloId.trim());
    }

    @Override
    public List<Modulo> listarModulosDeProfesor(String profesorId) {
        
        List<Modulo> modulosProfesor = new ArrayList<>();
        List<Modulo> modulos = xmlRepository.findAllModulos();
        for (Modulo modulo : modulos) {
            if(modulo.getProfesorId().equals(profesorId)){
                modulosProfesor.add(modulo);
            }
        }
        return modulosProfesor;
    }

    @Override
    public Evaluacion registrarEvaluacion(String alumno, String moduloId, double nota) {

        if (alumno == null || alumno.isBlank() || moduloId == null || moduloId.isBlank() || nota < 0 || nota > 10) {
            return null;
        }

        // Compruebo si el modulo NO existe
        Modulo moduloAComprobar = new Modulo(moduloId.trim());
        if (!xmlRepository.findAllModulos().contains(moduloAComprobar)) {
            return null;
        }

        Evaluacion evaluacion = new Evaluacion(alumno.trim(), moduloId.trim(), nota);
        jsonRepository.saveEvaluacion(evaluacion);
        return evaluacion;
    }

    @Override
    public List<Evaluacion> listarEvaluacionesDeModulo(String moduloId) {
        
        return jsonRepository.findEvaluacionesByModuloId(moduloId);
    }

    @Override
    public double calcularMediaDeModulo(String moduloId) {
        
        List<Evaluacion> evaluaciones = new ArrayList<>(jsonRepository.findEvaluacionesByModuloId(moduloId));
        double media = 0;

        for (Evaluacion evaluacion : evaluaciones) {
            media += evaluacion.getNota();
        }
        
        return media/evaluaciones.size();
    }

    @Override
    public double calcularMediaDeProfesor(String profesorId) {
        
        List<Modulo> modulos = new ArrayList<>(listarModulosDeProfesor(profesorId));
        double media = 0;
        int contador = 0;

        for (Modulo modulo : modulos) {
            String idModulo = modulo.getId();
            for (Evaluacion evaluacion : jsonRepository.findEvaluacionesByModuloId(idModulo)) {
                media += evaluacion.getNota();
                contador++;
            }
        }

        if(contador == 0){
            return media;
        }
        
        return media/contador;
    }

    @Override
    public Incidencia registrarIncidencia(String profesorId, String descripcion, String fecha) {

        if(profesorId == null || profesorId.isBlank() || descripcion == null || descripcion.isBlank() || fecha == null || fecha.isBlank()){
            return null;
        }

        // Compruebo si el profesor NO existe
        if (xmlRepository.findProfesorById(profesorId) == null) {
            return null;
        }

        Incidencia incidencia = new Incidencia(profesorId.trim(), descripcion.trim(), fecha);
        jsonRepository.saveIncidencia(incidencia);
        return incidencia;
    }

    @Override
    public List<Incidencia> listarIncidenciasDeProfesor(String profesorId) {
        
        return jsonRepository.findIncidenciasByProfesorId(profesorId);
    }

}
