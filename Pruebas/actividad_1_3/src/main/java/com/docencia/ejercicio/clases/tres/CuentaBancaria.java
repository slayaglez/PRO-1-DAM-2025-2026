package com.docencia.ejercicio.clases.tres;
/**
 * @author slayaglez
 * @brief Clase CuentaBancaria que contiene constructores, getters y setters de los parametros
 * titular, numero y saldo y trabaja con ellos.
 * @date 24 Oct 2025
 * @version 1.0.0
 */
import java.util.Objects;

public class CuentaBancaria {
    private String titular;
    private String numero;
    private double saldo;

    /**
     * Constructor vacío
     */
    public CuentaBancaria() {}

    /**
     * Constructor usando todos los campos
     * @param titular nombre del dueño de la cuenta
     * @param numero numero de la cuenta
     * @param saldo dinero dentro de la cuenta (double)
     */
    public CuentaBancaria(String titular, String numero, double saldo) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = saldo;
    }

    /**
     * Constructor usando los campos menos saldo
     * @param titular
     * @param numero
     */
    public CuentaBancaria(String titular, String numero) {
        this.titular = titular;
        this.numero = numero;
    }

    
    public String getTitular() { return titular; }
    public void setTitular(String titular) {
        
        this.titular = titular;
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSaldo() { return saldo; }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CuentaBancaria)) {
            return false;
        }
        CuentaBancaria cuentaBancaria = (CuentaBancaria) o;
        return Objects.equals(numero.toUpperCase(), cuentaBancaria.numero.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero.toUpperCase());
    }


    @Override
    public String toString() {
        return getNumero()+ " - " + getTitular() + " - saldo=" + getSaldo();
    }
    
}

