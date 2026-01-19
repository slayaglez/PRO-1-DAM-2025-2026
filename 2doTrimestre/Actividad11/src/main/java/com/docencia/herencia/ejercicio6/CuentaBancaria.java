package com.docencia.herencia.ejercicio6;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class CuentaBancaria {

    private UUID id;
    private String titular;
    private double saldo;

    protected CuentaBancaria(UUID id, String titular, double saldo) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.titular = titular;
        this.saldo = saldo;
    }

    public UUID getId() { return id; }
    public String getTitular() { return titular; }
    public double getSaldo() { return saldo; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract double comisionMensual();

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("El metodo no esta implementado");
    }
}
