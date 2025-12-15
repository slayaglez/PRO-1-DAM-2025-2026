package com.docencia.herencia.ejercicio2;

/**
 * Empleado base con nombre y método para calcular el salario mensual.
 */
public abstract class Empleado {
    private final String nombre;

    protected Empleado(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularSalarioMensual();
}
