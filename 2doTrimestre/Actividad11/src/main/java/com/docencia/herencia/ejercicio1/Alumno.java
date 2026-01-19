package com.docencia.herencia.ejercicio1;

import java.util.UUID;

public class Alumno extends Persona {

    private String matricula;

    public Alumno(UUID id){
        super(id);
    }

    public Alumno(UUID id, String nombre, int edad, String matricula) {
        super(id, nombre, edad);
        this.matricula = matricula;
}

    public String getMatricula() { return matricula; }

    @Override
    public String rol() {
        return "Alumno";
    }


    @Override
    public String toString() {
        return rol() + " matricula='" + getMatricula() + "'" + "id='"+ getId() +"'";
    }

}
