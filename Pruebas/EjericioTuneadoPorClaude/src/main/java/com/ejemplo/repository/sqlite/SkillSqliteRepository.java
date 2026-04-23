package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Employee;
import com.ejemplo.model.Skill;
import com.ejemplo.repository.ISkillRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SkillSqliteRepository extends SQLiteConnectionManager implements ISkillRepository {

    public SkillSqliteRepository() {
        super(rutaDb);
    }

    @Override
    public boolean create(Skill skill) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("INSERT INTO skill VALUES (?, ?, ?)");
            sentencia.setInt(1, skill.getId());
            sentencia.setString(2, skill.getName());
            sentencia.setInt(3, skill.getCategoryId());
            return sentencia.executeUpdate() > 0;
            

        } catch (Exception e) {
            System.err.println("Error creando skill");
            return false;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public Skill findById(Integer id) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM skill WHERE id = ?");
            sentencia.setInt(1, id);
            ResultSet resultado = sentencia.executeQuery();

            if (!resultado.next()) return null;

            String name = resultado.getString("name");
            int categoryId = resultado.getInt("category_id");

            Skill skill = new Skill(id, name, categoryId);

            return skill;

        } catch (Exception e) {
            System.err.println("Error buscando skill");
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public List<Skill> findAll() {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("SELECT * FROM skill");
            ResultSet resultado = sentencia.executeQuery();
            List<Skill> skills = new ArrayList<>();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String name = resultado.getString("name");
                int categoryId = resultado.getInt("category_id");

                Skill skill = new Skill(id, name, categoryId);
                skills.add(skill);
            }
            return skills;

        } catch (Exception e) {
            System.err.println("Error buscando skills");
            return null;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean update(Skill skill) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement(
                    "UPDATE skill SET name = ?, category_id = ? WHERE id = ?");
            sentencia.setInt(3, skill.getId());
            sentencia.setString(1, skill.getName());
            sentencia.setInt(2, skill.getCategoryId());
            
            return sentencia.executeUpdate() == 1;

        } catch (Exception e) {
            System.err.println("Error actualizando skill");
            return false;

        } finally {
            closeConnection(connection);

        }
    }

    @Override
    public boolean deleteById(Integer id) {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement sentencia = connection.prepareStatement("DELETE FROM skill WHERE id = ?");
            sentencia.setInt(1, id);

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("Error borrando el skill");
            return false;

        } finally {
            closeConnection(connection);

        }
    }

}
