package com.docencia.repository;

import com.docencia.model.Usuario;

import java.util.Optional;
import java.util.Set;

public interface IUserRepository {

  void save(Usuario usuario);

  Usuario findByEmail(String email);

  boolean existsByEmail(String email);

  Set<Usuario> findAll();

  boolean deleteByEmail(String email);
}
