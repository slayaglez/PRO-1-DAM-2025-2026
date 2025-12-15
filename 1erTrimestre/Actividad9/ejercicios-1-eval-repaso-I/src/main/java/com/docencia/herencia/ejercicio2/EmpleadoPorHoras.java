package com.docencia.herencia.ejercicio2;

/**
 * Empleado que cobra por horas trabajadas.
 */
public class EmpleadoPorHoras extends Empleado {
    private final int horas;
    private final double tarifaPorHora;

    public EmpleadoPorHoras(String nombre, int horas, double tarifaPorHora) {
        super(nombre);
        this.horas = horas;
        this.tarifaPorHora = tarifaPorHora;
    }

    public int getHoras() {
        return horas;
    }

    public double getTarifaPorHora() {
        return tarifaPorHora;
    }

    @Override
    public double calcularSalarioMensual() {
        // TODO: devolver horas * tarifaPorHora, controlando valores negativos.
        return 0.0;
    }
}
