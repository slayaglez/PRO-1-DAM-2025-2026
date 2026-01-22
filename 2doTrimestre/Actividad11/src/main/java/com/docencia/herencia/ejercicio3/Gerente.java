/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.herencia.ejercicio3;

import java.util.UUID;

public class Gerente extends Empleado {

    private int numReportes;

    public Gerente(UUID id, String nombre, double salarioBase, int numReportes) {
        super(id, nombre, salarioBase);
        this.numReportes = numReportes;
}

    public int getNumReportes() { return numReportes; }

    @Override
    public double calcularBonus() {
        return getSalarioBase() * 0.20;
    }

    @Override
    public String toString() {
        return "Gerente [numReportes=" + numReportes + ", id=" + getId() + "]";
    }

    @Override
    public boolean equals (Object obj) {
        if(!(obj instanceof Gerente)){
            return false;
        }
        return super.equals(obj);
    }

    
}
