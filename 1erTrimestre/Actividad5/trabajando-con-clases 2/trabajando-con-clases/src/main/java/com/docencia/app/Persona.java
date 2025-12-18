package com.docencia.app;

import java.util.Objects;

public class Persona {
    private String identificador;
    private String nombre;
    private int edad;

    public Persona() {
    
    };

    public Persona(String identificador) {
        this.identificador = identificador;

    }

    public Persona (String identificador, String nombre, int edad) {
        this.identificador = identificador;
        this. nombre = nombre;
        this.edad = edad;
    }


    /** Getters y setters */
    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.identificador, other.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("identificador=").append(identificador);
        sb.append(", nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }

    
}
