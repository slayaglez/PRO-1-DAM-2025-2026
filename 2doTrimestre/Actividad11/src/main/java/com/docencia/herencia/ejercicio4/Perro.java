package com.docencia.herencia.ejercicio4;

import java.util.UUID;

public class Perro extends Animal {

    private String raza;

    public Perro(UUID id, String nombre, String raza) {
        super(id, nombre);
        this.raza = raza;
}

    public String getRaza() { return raza; }

    @Override
    public String sonido() {
        return "Guau";
    }

    @Override
    public String toString() {
        return "Perro [raza=" + raza + ", id=" + getId() + "]";
    }

    
}
