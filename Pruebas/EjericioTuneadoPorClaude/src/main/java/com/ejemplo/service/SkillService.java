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
        if (!validarSkill(skill)) return false;
        if (repository.findById(skill.getId()) != null) return false;
        skill.setName(skill.getName().trim());
        if (existeNombreCaseInsensitive(skill.getName(), null)) return false;
        return repository.create(skill);
    }

    @Override
    public Skill buscarPorId(Integer id) {
        if (id == null) return null;
        return repository.findById(id);
    }

    @Override
    public List<Skill> listarTodas() {
        return repository.findAll();
    }

    @Override
    public boolean actualizar(Skill skill) {
        if (!validarSkill(skill)) return false;
        skill.setName(skill.getName().trim());
        // Comprueba duplicado excluyendo el propio registro (por id)
        if (existeNombreCaseInsensitive(skill.getName(), skill.getId())) return false;
        return repository.update(skill);
    }

    @Override
    public boolean eliminar(Integer id) {
        if (id == null) return false;
        return repository.deleteById(id);
    }

    @Override
    public List<Skill> listarPorCategoria(Integer categoryId) {
        if (categoryId == null) return new ArrayList<>();
        List<Skill> todas = repository.findAll();
        List<Skill> resultado = new ArrayList<>();
        for (Skill s : todas) {
            if (categoryId.equals(s.getCategoryId())) resultado.add(s);
        }
        return resultado;
    }

    // ── Operaciones sobre la tabla intermedia employee_skill ─────────────────

    @Override
    public boolean asignarEmpleado(Integer employeeId, Integer skillId, String levelId) {
        if (employeeId == null || skillId == null) return false;
        // La PK compuesta (employee_id, skill_id) impide duplicados.
        // Las FK impiden employee_id o skill_id inexistentes.
        // Ambas restricciones son gestionadas por la BD y se capturan en el catch.
        String levelGuardado = levelId != null ? levelId.trim() : null;
        try (Connection connection = SQLiteConnectionManager.openConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "INSERT INTO employee_skill (employee_id, skill_id, level_id) VALUES (?, ?, ?)")) {
            ps.setInt(1, employeeId);
            ps.setInt(2, skillId);
            ps.setString(3, levelGuardado);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public List<Skill> listarPorEmpleado(Integer employeeId) {
        if (employeeId == null) return new ArrayList<>();
        // INNER JOIN: devuelve solo las skills asignadas al empleado
        try (Connection connection = SQLiteConnectionManager.openConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT s.id, s.name, s.category_id " +
                     "FROM skill s " +
                     "INNER JOIN employee_skill es ON s.id = es.skill_id " +
                     "WHERE es.employee_id = ?")) {
            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                List<Skill> skills = new ArrayList<>();
                while (rs.next()) {
                    skills.add(new Skill(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("category_id")));
                }
                return skills;
            }
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public int contarEmpleadosConSkill(Integer skillId) {
        if (skillId == null) return 0;
        try (Connection connection = SQLiteConnectionManager.openConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT COUNT(*) FROM employee_skill WHERE skill_id = ?")) {
            ps.setInt(1, skillId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? rs.getInt(1) : 0;
            }
        } catch (SQLException e) {
            return 0;
        }
    }

    @Override
    public List<Skill> listarSinAsignar() {
        // NOT IN con subconsulta: skills cuyo id no aparece en employee_skill
        try (Connection connection = SQLiteConnectionManager.openConnection();
             PreparedStatement ps = connection.prepareStatement(
                     "SELECT id, name, category_id FROM skill " +
                     "WHERE id NOT IN (SELECT DISTINCT skill_id FROM employee_skill)")) {
            try (ResultSet rs = ps.executeQuery()) {
                List<Skill> skills = new ArrayList<>();
                while (rs.next()) {
                    skills.add(new Skill(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getInt("category_id")));
                }
                return skills;
            }
        } catch (SQLException e) {
            return new ArrayList<>();
        }
    }

    private boolean validarSkill(Skill skill) {
        if (skill == null) return false;
        if (skill.getId() == null) return false;
        if (skill.getName() == null || skill.getName().isBlank()) return false;
        if (skill.getCategoryId() == null) return false;
        return true;
    }

    // Devuelve true si ya existe una skill con el mismo nombre (ignorando mayúsculas),
    // excluyendo el registro con excludeId (útil en actualizar para no bloquearse a sí mismo).
    private boolean existeNombreCaseInsensitive(String nombre, Integer excludeId) {
        String sql = excludeId == null
                ? "SELECT COUNT(*) FROM skill WHERE UPPER(name) = UPPER(?)"
                : "SELECT COUNT(*) FROM skill WHERE UPPER(name) = UPPER(?) AND id != ?";
        try (Connection connection = SQLiteConnectionManager.openConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, nombre);
            if (excludeId != null) ps.setInt(2, excludeId);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
