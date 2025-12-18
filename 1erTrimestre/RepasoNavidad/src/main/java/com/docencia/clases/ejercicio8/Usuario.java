/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con usuarios
 */
package com.docencia.clases.ejercicio8;

import java.util.Objects;

public class Usuario {
    private String username;
    private String email;
    private boolean activo;

    /**
     * Constructor vacio
     */
    public Usuario() {}

    /**
     * Constructor con identificador unico
     * @param username
     */
    public Usuario(String username) {
        this.username = username;
    }

    /**
     * Constructor con identificador unico
     * @param username id unico
     * @param email email del usuario
     * @param activo si esta activo o no
     */
    public Usuario(String username, String email, boolean activo) {
        this.username = username;
        this.email = email;
        this.activo = activo;
    }

    /** Getters y Setters */
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(username, other.username);
    }

    @Override
    public String toString() {
        return "Usuario [username=" + username + ", email=" + email + ", activo=" + activo + "]";
    }

    
}
