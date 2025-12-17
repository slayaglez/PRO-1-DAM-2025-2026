/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con cuentas bancarias
 */
package com.docencia.clases.ejercicio4;

import java.util.Objects;

public class CuentaBancaria {
    private String iban;
    private String titular;
    private double saldo;

    /**
     * Constructor vacio
     */
    public CuentaBancaria() {}

    /**
     * Constructor con identificador unico
     * @param iban IBAN de la cuenta
     */
    public CuentaBancaria(String iban) {
        this.iban = iban;
    }

    /**
     * Constructor por defecto
     * @param iban IBAN de la cuenta
     * @param titular titular de la cuenta
     * @param saldo saldo de la cuenta
     */
    public CuentaBancaria(String iban, String titular, double saldo) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
    }

    /** Getters y Setters */
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CuentaBancaria other = (CuentaBancaria) obj;
        return Objects.equals(iban, other.iban);
    }

    @Override
    public String toString() {
        return "CuentaBancaria [iban=" + iban + ", titular=" + titular + ", saldo=" + saldo + "]";
    }

}
