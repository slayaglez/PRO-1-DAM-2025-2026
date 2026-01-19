package com.docencia.herencia.ejercicio9;

import java.util.UUID;

public class Electronica extends Producto {

    private int garantiaMeses;

    public Electronica(UUID id, String nombre, double precio, int garantiaMeses) {
        super(id, nombre, precio);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public int getGarantiaMeses() { return garantiaMeses; }

    @Override
    public String categoria() {
        return "Electronica";
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
