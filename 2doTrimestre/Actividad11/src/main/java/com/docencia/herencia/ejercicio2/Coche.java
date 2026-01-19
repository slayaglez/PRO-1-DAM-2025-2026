package com.docencia.herencia.ejercicio2;

import java.util.UUID;

public class Coche extends Vehiculo {

    private int puertas;

    public Coche(UUID id, String marca, String modelo, int puertas) {
        super(id, marca, modelo);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public int getPuertas() { return puertas; }

    @Override
    public int ruedas() {
        return 4;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
