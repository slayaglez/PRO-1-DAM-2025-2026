package com.docencia.herencia.ejercicio9;

import java.util.UUID;

public class Electronica extends Producto {

    private int garantiaMeses;

    public Electronica(UUID id, String nombre, double precio, int garantiaMeses) {
        super(id, nombre, precio);
        this.garantiaMeses = garantiaMeses;
}

    public int getGarantiaMeses() { return garantiaMeses; }

    @Override
    public String categoria() {
        return "Electronica";
    }

    @Override
    public String toString() {
        return "Electronica [garantiaMeses=" + garantiaMeses + ", id=" + getId() + "]";
    }

    

    
}
