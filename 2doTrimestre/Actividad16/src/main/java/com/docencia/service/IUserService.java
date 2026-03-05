package com.docencia.service;

import com.docencia.model.Usuario;

import java.util.Optional;
import java.util.Set;

public interface IUserService {

  Usuario crearUsuario(int id, String nombre, String email, String password);

  Set<Usuario> listarUsuarios();

  Usuario buscarPorEmail(String email);

  boolean eliminarPorEmail(String email);

  // opcionales (pero implementados)
  Usuario cambiarNombre(String email, String nuevoNombre);

  Usuario cambiarPassword(String email, String nuevaPassword);
}
