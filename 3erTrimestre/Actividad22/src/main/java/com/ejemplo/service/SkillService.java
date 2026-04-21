package com.ejemplo.service;

import com.ejemplo.model.Skill;
import com.ejemplo.repository.ISkillRepository;
import com.ejemplo.repository.sqlite.SQLiteConnectionManager;
import com.ejemplo.repository.sqlite.SkillSqliteRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillService implements ISkillService {

    private final ISkillRepository repository;

    public SkillService() {
        this.repository = new SkillSqliteRepository();
    }

    @Override
    public boolean crear(Skill skill) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public Skill buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<Skill> listarTodas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarTodas'");
    }

    @Override
    public boolean actualizar(Skill skill) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public boolean eliminar(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public List<Skill> listarPorCategoria(Integer categoryId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorCategoria'");
    }

    @Override
    public boolean asignarEmpleado(Integer employeeId, Integer skillId, String levelId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarEmpleado'");
    }

    @Override
    public List<Skill> listarPorEmpleado(Integer employeeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarPorEmpleado'");
    }

    @Override
    public int contarEmpleadosConSkill(Integer skillId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarEmpleadosConSkill'");
    }

    @Override
    public List<Skill> listarSinAsignar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarSinAsignar'");
    }

    
}
