package com.docencia.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.service.IUserService;
import com.docencia.util.Validaciones;

public class UserServiceImpl implements IUserService{

    private final IUserRepository userRepository;

    /**
     * Constructor vacio
     */
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Crea un usuario
     */
    @Override
    public Usuario crearUsuario(int id, String nombre, String email, String password) {
        Usuario usuario = new Usuario(id, nombre, email, password);
        userRepository.save(usuario);
        return usuario;
    }

    /**
     * Lista usuarios
     */
    @Override
    public Set<Usuario> listarUsuarios() {
        return userRepository.findAll();
    }

    /**
     * Busca usuarios por email
     */
    @Override
    public Usuario buscarPorEmail(String email) {
        if(!Validaciones.emailValido(email)){
            return new Usuario();
        }
        email = Validaciones.normalizarEmail(email);
        if(userRepository.findByEmail(email) == null){
            return new Usuario();
        }
        return userRepository.findByEmail(email);
    }

    /**
     * Elimina usuarios por email
     */
    @Override
    public boolean eliminarPorEmail(String email) {
        return userRepository.deleteByEmail(email);
    }

    /**
     * Cambia del nombre del usuario
     */
    @Override
    public Usuario cambiarNombre(String email, String nuevoNombre) {
        Usuario usuario = userRepository.findByEmail(email);
        usuario.setNombre(nuevoNombre);
        return usuario;
    }

    /**
     * Cambia la contrasenia del usuario
     */
    @Override
    public Usuario cambiarPassword(String email, String nuevaPassword) {
        Usuario usuario = userRepository.findByEmail(email);
        usuario.setPassword(nuevaPassword);
        return usuario;
    }

    @Override
    public Set<Usuario> obtenerBloqueados() {
        Set<Usuario> bloqueados = new HashSet<>();
        Set<Usuario> todos = listarUsuarios();
        
        for (Usuario usuario : todos) {
            if(usuario.isBloqueado()){
                bloqueados.add(usuario);
            }
        }

        return bloqueados;
    }

}
