package com.docencia.model;

import java.time.LocalDate;
import java.util.Objects;

public class Usuario extends Persona {

    private String password;
    private final String email;
    private int intentosFallidos;
    private boolean bloqueado;
    private final LocalDate fechaRegistro;

    /**
     * Constructor vacio
     */
    public Usuario(){
        this.email = "";
        this.fechaRegistro = null;
    }

    /**
     * Constructor por defecto
     * @param id identificador
     * @param email email
     * @param nombre nombre 
     * @param fechaRegistro fecha de registro
     * @param password contrasenia
     * @param intentosFallidos intentos falllidos
     * @param bloqueado bloqueado o no
     */
    public Usuario(int id, String nombre, String email, String password) {
        super(id, nombre);
        this.password = password;
        this.email = email;
        this.intentosFallidos = 0;
        this.bloqueado = false;
        this.fechaRegistro = LocalDate.now();
    }

    public Usuario(String email){
        super(0);
        this.email = email;
        this.fechaRegistro = null;
    }

    public Usuario(int id){
        super(id);
        this.email = null;
        this.fechaRegistro = null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIntentosFallidos() {
        return intentosFallidos;
    }

    public void setIntentosFallidos(int intentosFallidos) {
        this.intentosFallidos = intentosFallidos;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }


    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if(!(obj instanceof Usuario)){
            return false;
        }
        Usuario usuario = (Usuario) obj;
        if (email == null || usuario.getEmail() == null){
            return false;
        }
        return Objects.equals(email, usuario.email);
    }

    @Override
    public String toString() {
        return "\n==============================\nID = "+ getId()+"\nNombre = "+getNombre()+"\nPassword = " + password + "\nEmail = " + email + "\nIntentos fallidos = " + intentosFallidos
                + "\nBloqueado = " + bloqueado + "\nFecha Registro = " + fechaRegistro + "\n==============================\n";
    }

    public void incrementarIntentosFallidos(){
        this.intentosFallidos++;
    }

    public void resetearIntentosFallidos(){
        this.intentosFallidos = 0;
    }

    public void bloquear(){
        this.bloqueado = true;
    }

}
