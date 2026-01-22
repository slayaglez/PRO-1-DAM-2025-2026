package com.docencia.herencia.ejercicio2;

import java.util.UUID;

public class Coche extends Vehiculo {

    private int puertas;

    public Coche(UUID id, String marca, String modelo, int puertas) {
        super(id, marca, modelo);
        this.puertas = puertas;
}

    public int getPuertas() { return puertas; }

    @Override
    public int ruedas() {
        return 4;
    }

    @Override
    public String toString() {
        return "Coche [puertas=" + puertas + "]" + "id="+ getId();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals (Object obj) {
        if(!(obj instanceof Coche)){
            return false;
        }
        return super.equals(obj);
    }

   

    

    
}
