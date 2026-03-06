package com.docencia.repository;

import com.docencia.model.Usuario;

import java.util.Set;

public interface IUserRepository {

  /**
   * Funcion que almacena en un repo y recibe un usuario
   * @param usuario el usuario a guardar
   */
  void save(Usuario usuario);

  Usuario findByEmail(String email);

  boolean existsByEmail(String email);

  /**
   * Funcion que retorna todos los elementos de la lista
   * @return lista Set de Usuario
   */
  Set<Usuario> findAll();

  boolean deleteByEmail(String email);
}
