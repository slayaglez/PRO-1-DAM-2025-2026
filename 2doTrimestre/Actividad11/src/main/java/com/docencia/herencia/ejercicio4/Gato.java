/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.herencia.ejercicio4;

import java.util.UUID;

public class Gato extends Animal {

    private boolean cazador;

    public Gato(UUID id, String nombre, boolean cazador) {
        super(id, nombre);
        this.cazador = cazador;
}

    public boolean getCazador() { return cazador; }

    @Override
    public String sonido() {
        return "Miau";
    }

    @Override
    public String toString() {
        return "Gato [cazador=" + cazador + ", id=" + getId() + "]";
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Gato)){
            return false;
        }
        return super.equals(obj);
    }
}
