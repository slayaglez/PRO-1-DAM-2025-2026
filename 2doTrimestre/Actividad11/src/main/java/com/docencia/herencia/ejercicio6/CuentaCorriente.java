package com.docencia.herencia.ejercicio6;

import java.util.UUID;

public class CuentaCorriente extends CuentaBancaria {

    private double limiteDescubierto;

    public CuentaCorriente(UUID id, String titular, double saldo, double limiteDescubierto) {
        super(id, titular, saldo);
        throw new UnsupportedOperationException("El metodo no esta implementado");
}

    public double getLimiteDescubierto() { return limiteDescubierto; }

    @Override
    public double comisionMensual() {
        return 4.99;
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
