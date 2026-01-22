/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */

package com.docencia.herencia.ejercicio1;

import java.util.UUID;

public class Profesor extends Persona {

    private String departamento;

    public Profesor(UUID id, String nombre, int edad, String departamento) {
        super(id, nombre, edad);
        this.departamento = departamento;
}

    public String getDepartamento() { return departamento; }

    @Override
    public String rol() {
        return "Profesor";
    }

    @Override
    public String toString() {
        return "Profesor [departamento=" + departamento + ", rol=" + rol() + ", id=" + getId() + "]";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals (Object obj) {
        if(!(obj instanceof Profesor)){
            return false;
        }
        return super.equals(obj);
    }
}
