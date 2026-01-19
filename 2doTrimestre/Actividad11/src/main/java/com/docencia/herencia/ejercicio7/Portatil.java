package com.docencia.herencia.ejercicio7;

import java.util.UUID;

public class Portatil extends Dispositivo {

    private double pulgadas;

    public Portatil(UUID id, String fabricante, double pulgadas) {
        super(id, fabricante);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public double getPulgadas() { return pulgadas; }

    @Override
    public String tipo() {
        return "Portatil";
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
