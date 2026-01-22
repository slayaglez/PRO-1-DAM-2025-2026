/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.herencia.ejercicio6;

import java.util.UUID;

public class CuentaCorriente extends CuentaBancaria {

    private double limiteDescubierto;

    public CuentaCorriente(UUID id, String titular, double saldo, double limiteDescubierto) {
        super(id, titular, saldo);
        this.limiteDescubierto = limiteDescubierto;
}

    public double getLimiteDescubierto() { return limiteDescubierto; }

    @Override
    public double comisionMensual() {
        return 4.99;
    }

    @Override
    public String toString() {
        return "CuentaCorriente [limiteDescubierto=" + limiteDescubierto + ", id=" + getId() + "]";
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof CuentaCorriente)){
            return false;
        }
        return super.equals(obj);
    }
}
