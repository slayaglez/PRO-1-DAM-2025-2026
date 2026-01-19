package com.docencia.herencia.ejercicio3;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Empleado {

    private UUID id;
    private String nombre;
    private double salarioBase;

    protected Empleado(UUID id, String nombre, double salarioBase) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }
    public double getSalarioBase() { return salarioBase; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract double calcularBonus();

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
