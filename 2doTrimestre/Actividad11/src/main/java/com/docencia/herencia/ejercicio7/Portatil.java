package com.docencia.herencia.ejercicio7;

import java.util.UUID;

public class Portatil extends Dispositivo {

    private double pulgadas;

    public Portatil(UUID id, String fabricante, double pulgadas) {
        super(id, fabricante);
        this.pulgadas = pulgadas;
}

    public double getPulgadas() { return pulgadas; }

    @Override
    public String tipo() {
        return "Portatil";
    }

    @Override
    public String toString() {
        return "Portatil [pulgadas=" + pulgadas + ", id=" + getId() + "]";
    }

    
}
