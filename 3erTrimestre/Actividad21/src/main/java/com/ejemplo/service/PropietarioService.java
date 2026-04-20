package com.ejemplo.service;

import com.ejemplo.model.Propietario;
import com.ejemplo.repository.IPropietarioRepository;
import com.ejemplo.repository.sqlite.PropietarioSqliteRepository;

import java.util.List;

public class PropietarioService implements IPropietarioService {

    private final IPropietarioRepository repository;

    public PropietarioService() {
        this.repository = new PropietarioSqliteRepository();
    }

    @Override
    public boolean crear(Propietario propietario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Propietario buscarPorDni(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorDni'");
    }

    @Override
    public List<Propietario> listarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodos'");
    }

    @Override
    public boolean actualizar(Propietario propietario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public boolean eliminar(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Propietario> listarActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarActivos'");
    }

    @Override
    public List<Propietario> buscarPorCiudad(String ciudad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorCiudad'");
    }

    @Override
    public int contarActivos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarActivos'");
    }
}
