package com.docencia.composicion.ejercicio11;

import java.util.Objects;

public class Persona{
    
    private String identificador;
    private String nombre;
    private Direccion direccion;
    
    public Persona(){}

    /**
     * Constructor por defecto
     * @param identificador dni
     * @param nombre nombre
     */
    public Persona(String identificador, String nombre, Direccion direccion) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.direccion = direccion;
        
    }


    /** Getters y setters */
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Persona other = (Persona) obj;
        return Objects.equals(identificador, other.identificador);
    }

    @Override
    public String toString() {
        return "Persona [DNI: " + identificador + " y nombre: " + nombre + "]" + " y " + direccion;
    }

    

}
