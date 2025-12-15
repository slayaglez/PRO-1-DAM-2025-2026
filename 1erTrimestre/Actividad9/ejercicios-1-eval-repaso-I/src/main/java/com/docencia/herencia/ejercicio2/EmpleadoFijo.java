package com.docencia.herencia.ejercicio2;

/**
 * Empleado con salario fijo mensual.
 */
public class EmpleadoFijo extends Empleado {
    private final double salarioMensual;

    public EmpleadoFijo(String nombre, double salarioMensual) {
        super(nombre);
        this.salarioMensual = salarioMensual;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    @Override
    public double calcularSalarioMensual() {
        // TODO: devolver salario mensual.
        return 0.0;
    }
}
