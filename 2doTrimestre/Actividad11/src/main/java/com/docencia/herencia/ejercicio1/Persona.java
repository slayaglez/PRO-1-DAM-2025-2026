package com.docencia.herencia.ejercicio1;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Persona {

    private UUID id;
    private String nombre;
    private int edad;

    public Persona(){}

    public Persona(UUID id){
        this.id = id;
    }

    protected Persona(UUID id, String nombre, int edad) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract String rol();

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
        return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
    }

    
}
