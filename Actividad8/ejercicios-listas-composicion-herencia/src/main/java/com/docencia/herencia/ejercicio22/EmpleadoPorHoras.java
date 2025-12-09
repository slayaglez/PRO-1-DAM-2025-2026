package com.docencia.herencia.ejercicio22;

public class EmpleadoPorHoras extends Empleado{

    private double sueldoHora;

    public EmpleadoPorHoras(int id, String nombre, double sueldoHora) {
        super(id, nombre);
        this.sueldoHora = sueldoHora;
    }

    public double getSueldoHora() {
        return sueldoHora;
    }

    public void setSueldoHora(double sueldoHora) {
        this.sueldoHora = sueldoHora;
    }

    @Override
    public double calcularSueldo(){
        return sueldoHora;
    }
}
