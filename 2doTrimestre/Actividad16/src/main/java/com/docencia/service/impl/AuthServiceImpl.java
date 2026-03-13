package com.docencia.service.impl;

import com.docencia.model.Usuario;
import com.docencia.repository.IUserRepository;
import com.docencia.service.IAuthService;
import com.docencia.util.Validaciones;

public class AuthServiceImpl implements IAuthService{

    private final IUserRepository userRepository;

    public AuthServiceImpl(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Usuario register(int id, String nombre, String email, String password) {
        
        if(id < 1 || !Validaciones.emailValido(email) || !Validaciones.passwordValida(password)){
            return null;
        }
        email = Validaciones.normalizarEmail(email);
        Validaciones.validarPassword(password);

        // Si existe no devolvera null
        if (userRepository.findByEmail(email) != null) {
            throw new IllegalArgumentException();
        }
        
        Usuario usuario = new Usuario(id, nombre, email, password);
        userRepository.save(usuario);
        return usuario;
    }

    /**
     * Login de usuario
     * @param email email
     * @param password contrasenia
     * @return true / false
     */
    @Override
    public boolean login(String email, String password){

        Usuario usuario = userRepository.findByEmail(email);

        if(isBloqueado(email)){
            return false;
        }

        if(usuario.getPassword().equals(password)){
            usuario.resetearIntentosFallidos();
            return true;
        }

        usuario.incrementarIntentosFallidos();
        return false;
    }

    @Override
    public boolean isBloqueado(String email) {

        Usuario usuario = userRepository.findByEmail(email);
        return usuario.getIntentosFallidos() >= 3;
    }

    @Override
    public void desbloquear(String email) {

        Usuario usuario = userRepository.findByEmail(email);
        if(isBloqueado(email)){
        }
    }

}
