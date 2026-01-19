package com.docencia.herencia.ejercicio2;

import java.util.UUID;

public class Motocicleta extends Vehiculo {

    private boolean tieneSidecar;

    public Motocicleta(UUID id, String marca, String modelo, boolean tieneSidecar) {
        super(id, marca, modelo);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public boolean getTieneSidecar() { return tieneSidecar; }

    @Override
    public int ruedas() {
        return 2;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
