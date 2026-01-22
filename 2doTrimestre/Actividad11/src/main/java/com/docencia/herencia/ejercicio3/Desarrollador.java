package com.docencia.herencia.ejercicio3;

import java.util.UUID;

public class Desarrollador extends Empleado {

    private String lenguajePrincipal;

    public Desarrollador(UUID id, String nombre, double salarioBase, String lenguajePrincipal) {
        super(id, nombre, salarioBase);
        this.lenguajePrincipal = lenguajePrincipal;
}

    public String getLenguajePrincipal() { return lenguajePrincipal; }

    @Override
    public double calcularBonus() {
        return getSalarioBase() * 0.10;
    }

    @Override
    public String toString() {
        return "Desarrollador [lenguajePrincipal=" + lenguajePrincipal + "]" + "id=" + getId();
    }

    @Override
    public boolean equals (Object obj) {
        if(!(obj instanceof Desarrollador)){
            return false;
        }
        return super.equals(obj);
    }
    
}
