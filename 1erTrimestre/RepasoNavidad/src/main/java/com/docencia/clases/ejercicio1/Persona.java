/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con Personas
 */
package com.docencia.clases.ejercicio1;

import java.util.Objects;

public class Persona {
    private String dni;
    private String nombre;
    private int edad;

    /**
     * Constructor vacio
     */
    public Persona() {}

    /**
     * Constructor con id
     * @param dni el dni de la persona
     */
    public Persona(String dni) {
        this.dni = dni;
    }

    /**
     * Constructor con id
     * @param dni el dni de la persona
     * @param nombre el nombre de la persona
     * @param edad edad de la persona
     */
    public Persona(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    /** Getters y setters */
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
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
        return Objects.equals(dni, other.dni);
    }

    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + "]";
    } 
}
