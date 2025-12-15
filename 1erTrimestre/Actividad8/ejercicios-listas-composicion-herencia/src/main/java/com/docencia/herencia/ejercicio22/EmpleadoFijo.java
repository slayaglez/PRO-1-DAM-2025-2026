package com.docencia.herencia.ejercicio22;

public class EmpleadoFijo extends Empleado{
    private double sueldoAnual;

    public EmpleadoFijo(int id, String nombre, double sueldoAnual) {
        super(id, nombre);
        this.sueldoAnual = sueldoAnual;
    }

    public double getSueldoAnual() {
        return sueldoAnual;
    }

    public void setSueldoAnual(double sueldoAnual) {
        this.sueldoAnual = sueldoAnual;
    }

    @Override
    public double calcularSueldo(){
        return sueldoAnual/52/5/8;
    }
}
