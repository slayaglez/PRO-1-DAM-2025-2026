package com.ejemplo.service;

import com.ejemplo.model.Skill;
import java.util.List;

public interface ISkillService {

    boolean crear(Skill skill);
    Skill buscarPorId(Integer id);
    List<Skill> listarTodas();
    boolean actualizar(Skill skill);
    boolean eliminar(Integer id);
    List<Skill> listarPorCategoria(Integer categoryId);
    boolean asignarEmpleado(Integer employeeId, Integer skillId, String levelId);
    List<Skill> listarPorEmpleado(Integer employeeId);
    int contarEmpleadosConSkill(Integer skillId);
    List<Skill> listarSinAsignar();
}
