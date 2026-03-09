package com.docencia.repository.impl;

import java.util.HashSet;
import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;

public class UserRepositoryImpl implements IUserRepository{
    final Set<Usuario> usuarios;

    public UserRepositoryImpl() {
        usuarios = new HashSet<>();
    }

    /**
     * Encuentra un usuario por su email
     * @param String email
     * @return el Usuario
     */
    @Override
    public Usuario findByEmail(String email) {
        
        if(!existsByEmail(email)){
            return null;
        }
        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email)){
                return usuario;
            }
        }
        return null;
    }

    /**
     * Metodo que comprueba si una email existe o no
     * @param email String email
     * @return true / false
     */
    @Override
    public boolean existsByEmail(String email) {

        // Usuario usuarioABuscar= new Usuario(email);
        // return usuarios.contains(usuarioABuscar);

        for (Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email.trim().toLowerCase())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(Usuario usuario) {
        usuarios.add(usuario);
    }

    /**
     * Devuelve todos los Usuarios
     * @return List Set Usuario
     */
    @Override
    public Set<Usuario> findAll() {
        return usuarios;
    }

    /**
     * Elimina un usuario dado su email
     * @param email String email
     * @return true / false
     */
    @Override
    public boolean deleteByEmail(String email) {
        
        return usuarios.removeIf(usuario -> usuario.getEmail().equals(email));
    }

}
