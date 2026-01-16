package com.docencia.arraylist;

import java.util.Objects;

public class Persona {

    String id;
    String nombre;

    public Persona(){}

    public Persona(String id){
        this.id = id;
    }

    public Persona(String id, String nombre){
        this.id = id;
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
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + "]";
    }

}
