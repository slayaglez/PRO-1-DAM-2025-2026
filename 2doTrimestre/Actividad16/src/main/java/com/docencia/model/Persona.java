package com.docencia.model;

import java.util.Objects;

public abstract class Persona {

    private final int id;
    private String nombre;

    /**
     * Constructor vacio
     */
    protected Persona(){
        this.id=0;
    }
    
    /**
     * Constructor con identificador
     * @param id identificador unico
     */
    protected Persona(int id) {
        this.id = id;
    }

    /**
     * Constructor por defecto
     * @param id identificador unico
     * @param nombre nombre usuario
     */
    protected Persona(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id);
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
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + "]";
    }
    
}
