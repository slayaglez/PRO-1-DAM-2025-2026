package com.docencia.herencia.ejercicio4;

import java.util.UUID;

public class Perro extends Animal {

    private String raza;

    public Perro(UUID id, String nombre, String raza) {
        super(id, nombre);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public String getRaza() { return raza; }

    @Override
    public String sonido() {
        return "Guau";
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
