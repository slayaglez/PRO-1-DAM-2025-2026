package com.docencia.herencia.ejercicio6;

import java.util.UUID;

public class CuentaAhorro extends CuentaBancaria {

    private double interesAnual;

    public CuentaAhorro(UUID id, String titular, double saldo, double interesAnual) {
        super(id, titular, saldo);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public double getInteresAnual() { return interesAnual; }

    @Override
    public double comisionMensual() {
        return 0.0;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
