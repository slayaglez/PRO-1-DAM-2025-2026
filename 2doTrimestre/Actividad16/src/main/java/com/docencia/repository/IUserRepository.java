package com.docencia.repository;

import java.util.Set;

import com.docencia.model.Usuario;

public interface IUserRepository {

  /**
   * Funcion que almacena en un repo y recibe un usuario
   * @param usuario el usuario a guardar
   */
  void save(Usuario usuario);

  /**
     * Encuentra un usuario por su email
     * @param email string email
     * @return el Usuario
     */
  Usuario findByEmail(String email);

  /**
     * Metodo que comprueba si una email existe o no
     * @param email String email
     * @return true / false
     */
  boolean existsByEmail(String email);

  /**
   * Funcion que retorna todos los elementos de la lista
   * @return lista Set de Usuario
   */
  Set<Usuario> findAll();

  /**
     * Elimina un usuario dado su email
     * @param email String email
     * @return true / false
     */
  boolean deleteByEmail(String email);
}
