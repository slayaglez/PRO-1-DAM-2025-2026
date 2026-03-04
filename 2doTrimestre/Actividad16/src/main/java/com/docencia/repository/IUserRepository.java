package com.docencia.repository;

import com.docencia.model.Usuario;

public interface IUserRepository {

    /**
     * Funcion que busca un usuario dado un email
     * @param email string con email normalizado
     * @return true / false
     */
    public Usuario findByEmail(String email);


    /**
     * Funcion que determina si existe un usuario por su email
     * @param email string con email normalizado
     * @return true / false
     */
    public boolean existsByEmail(String email);
}
