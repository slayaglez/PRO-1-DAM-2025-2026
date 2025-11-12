package com.docencia.clases;

public class CuentaBancaria {

    private final String iban;
    private double saldo;

    /**
     * Constructor vacio
     */
    public CuentaBancaria() {
        this("iban", 0); // ! MUY IMPORTANTE
    }

    /**
     * Constructor solo iban
     * @param iban identificador
     */
    public CuentaBancaria(String iban) {
        this("iban", 0);
    }
    /**
     * Constructor por defecto
     * 
     * @param iban  identificador cuenta
     * @param saldo saldo positivo
     */
    public CuentaBancaria(String iban, double saldo) {
        this.iban = iban;

        if (saldo < 0) {
            throw new IllegalArgumentException("saldo");
        }
        this.saldo = saldo;
    }

    /** Getters & Setters */

    public double getSaldo() {
        if (saldo < 0) {
            throw new IllegalArgumentException("saldo");
        }
        return saldo;
    }

    /**
     * Funcion que añade dinero al saldo
     * 
     * @param cantidad cantidad a sumar
     */
    public void ingresar(double cantidad) {
        if (cantidad < -1) {
            throw new IllegalArgumentException("cantidad");
        }
        saldo += cantidad;
    }

    /**
     * Funcion que retira dinero al saldo
     * 
     * @param cantidad cantidad a retirar
     */
    public void retirar(double cantidad) {
        if (cantidad < -1 || cantidad > saldo) {
            throw new IllegalArgumentException("cantidad");
        }
        saldo -= cantidad;
    }

    @Override
    public String toString() {
        return "Cuenta(" + iban + ", saldo=" + saldo + ")";
    }

    public static void main(String[] args) {
        CuentaBancaria cuentaBancaria1 = new CuentaBancaria("iban1");
        System.out.println(cuentaBancaria1);
        CuentaBancaria cuentaBancaria2 = new CuentaBancaria("iban2", 0);
        System.out.println(cuentaBancaria2);
        cuentaBancaria2.ingresar(50);
        cuentaBancaria2.retirar(20);
        System.out.println(cuentaBancaria2);

    }
}
