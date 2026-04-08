package com.examen.profesores.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.examen.profesores.model.Profesor;
import com.examen.profesores.model.Profesores;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ProfesorRepositoryJsonImpl implements ProfesorRepository{
    private final ObjectMapper objectMapper;
    Path path;
    List<Profesor> profesores;

    public ProfesorRepositoryJsonImpl() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        this.path = Path.of("data", "profesores.json");
        profesores = read().getProfesores();
    }

    @Override
    public boolean save(Profesor profesor) {
        profesores.add(profesor);
        return write();
    }

    @Override
    public Profesor findById(String id) {
        Profesor profesorBuscado = new Profesor(id);
        int posicion = profesores.indexOf(profesorBuscado);
        if(posicion < 0){
            return null;
        }
        return profesores.get(posicion);
    }

    @Override
    public List<Profesor> findAll() {
        return profesores;
    }

    @Override
    public boolean existsById(String id) {
        Profesor profesorBuscado = new Profesor(id);
        return profesores.contains(profesorBuscado);
    }

    @Override
    public boolean deleteById(String id) {
        Profesor profesorBuscado = new Profesor(id);
        profesores.removeIf(profesor -> profesor.equals(profesorBuscado));
        return write();
    }

    @Override
    public boolean updateDepartamento(String id, String nuevoDepartamento) {
        Profesor profesorBuscado = new Profesor(id);
        for (Profesor profesor : profesores) {
                if (profesor.equals(profesorBuscado)) {
                profesor.setDepartamento(nuevoDepartamento);
                return write();
            }
        }
        return false;
    }

    /**
     * Funcion que lee todos los elementos de un JSON
     * @return xmlMapper
     */
    private Profesores read() {
        try {
            if (Files.notExists(path) || Files.size(path) == 0) {
                return new Profesores();
            }
            return objectMapper.readValue(path.toFile(), Profesores.class);
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo leer el JSON", e);
        }
    }

    /**
     * Funcion que escribe los elementos de un JSON
     */
    public boolean write() {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            objectMapper.writeValue(path.toFile(), profesores);
            return true;
        } catch (IOException e) {
            throw new IllegalStateException("No se pudo escribir el JSON", e);
        }
    }
}
