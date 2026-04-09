package com.ejemplo.centro.repository;

import com.ejemplo.centro.model.CentroData;
import com.ejemplo.centro.model.Modulo;
import com.ejemplo.centro.model.Profesor;
import com.ejemplo.centro.util.XmlManager;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CentroXmlRepositoryImpl implements CentroXmlRepository {
    private final Path xmlPath;
    private final XmlManager xmlManager;
    private final CentroData centro;
    

    public CentroXmlRepositoryImpl(Path xmlPath) {
        this(xmlPath, new XmlManager());
    }

    public CentroXmlRepositoryImpl(Path xmlPath, XmlManager xmlManager) {
        this.xmlPath = xmlPath;
        this.xmlManager = xmlManager;
        this.centro = xmlManager.read(xmlPath);
    }

    @Override
    public List<Profesor> findAllProfesores() {

        List<Profesor> profesores = new ArrayList<>();
        profesores.addAll(centro.getProfesores());
        return profesores;
    }

    @Override
    public List<Modulo> findAllModulos() {
        
        List<Modulo> modulos = new ArrayList<>();
        modulos.addAll(centro.getModulos());
        return modulos;
    }

    @Override
    public Profesor findProfesorById(String id) {

        List<Profesor> profesores = centro.getProfesores();
        Profesor profesorBuscado = new Profesor(id);
        for (Profesor profesor : profesores) {
            if(profesorBuscado.equals(profesor)) {
                return profesor;
            }
        }

        // No encontrado
        return null;
    }

    @Override
    public Modulo findModuloById(String id) {
        
        List<Modulo> modulos = centro.getModulos();
        Modulo moduloBuscado = new Modulo(id);
        for (Modulo modulo : modulos) {
            if(moduloBuscado.equals(modulo)) {
                return modulo;
            }
        }

        // No encontrado
        return null;
    }

    
}
