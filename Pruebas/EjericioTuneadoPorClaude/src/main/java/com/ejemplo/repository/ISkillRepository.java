package com.ejemplo.repository;

import com.ejemplo.model.Skill;
import java.util.List;

public interface ISkillRepository {

    /**
     * Crea una skill
     * @param skill Skill
     * @return boolean
     */
    boolean create(Skill skill);

    /**
     * Encuentra un Skill por su ID
     * @param id ID
     * @return Skill
     */
    Skill findById(Integer id);
    
    /**
     * Lista todas las Skills
     * @return Skill
     */
    List<Skill> findAll();

    /**
     * Actualiza una skill
     * @param skill Skill
     * @return boolean
     */
    boolean update(Skill skill);

    /**
     * Elimina una Skill por si ID
     * @param id ID
     * @return Skill
     */
    boolean deleteById(Integer id);
}
