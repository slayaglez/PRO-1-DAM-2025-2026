package com.docencia.herencia.ejercicio4;

import java.util.UUID;

public class Gato extends Animal {

    private boolean cazador;

    public Gato(UUID id, String nombre, boolean cazador) {
        super(id, nombre);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public boolean getCazador() { return cazador; }

    @Override
    public String sonido() {
        return "Miau";
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
