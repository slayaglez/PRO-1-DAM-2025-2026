/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.herencia.ejercicio2;

import java.util.UUID;

public class Motocicleta extends Vehiculo {

    private boolean tieneSidecar;

    public Motocicleta(UUID id, String marca, String modelo, boolean tieneSidecar) {
        super(id, marca, modelo);
        this.tieneSidecar = tieneSidecar;
}

    public boolean getTieneSidecar() { return tieneSidecar; }

    @Override
    public int ruedas() {
        return 2;
    }

    @Override
    public String toString() {
        return "Motocicleta [tieneSidecar=" + tieneSidecar + "]"+"id="+getId();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals (Object obj) {
        if(!(obj instanceof Motocicleta)){
            return false;
        }
        return super.equals(obj);
    }

    
}
