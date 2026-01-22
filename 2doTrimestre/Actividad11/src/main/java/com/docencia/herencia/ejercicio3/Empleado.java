/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
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
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        Empleado other = (Empleado) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre + ", salarioBase=" + salarioBase + "]";
    }
}
