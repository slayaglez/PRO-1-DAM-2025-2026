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

    @Override
    public Usuario findByEmail(String email) {
        
        if(!existsByEmail(email)){
            return null;
        }

        Usuario usuarioABuscar= new Usuario(email);
        for (Usuario usuario : usuarios) {
            if(usuario.equals(usuarioABuscar)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public boolean existsByEmail(String email) {

        Usuario usuarioABuscar= new Usuario(email);
        return usuarios.contains(usuarioABuscar);
    }

}
