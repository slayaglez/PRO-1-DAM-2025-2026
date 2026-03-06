package com.docencia.service;

import com.docencia.model.Usuario;

public interface IAuthService {

  /**
   * Funcion que registra un usuario
   * @param id identificador unico
   * @param nombre nombre del usuario
   * @param email email unico
   * @param password contrasenia del usuario
   * @return 
   */
  Usuario register(int id, String nombre, String email, String password);

  boolean login(String email, String password);

  // opcionales (pero implementados)
  boolean isBloqueado(String email);

  void desbloquear(String email);
}
