package com.docencia.herencia.ejercicio2;

import java.util.List;

public class EmpleadoPorHoras extends Empleado {
    private final int horas;
    private final double tarifaPorHora;

    public EmpleadoPorHoras(String nombre, int horas, double tarifaPorHora) {
        super(nombre);
        this.horas = horas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularSalarioMensual() {
        if(horas > 0 && tarifaPorHora > 0){
            return horas * tarifaPorHora;
        }
        return 0.0;
    }

    public static double costeTotalNomina(List<Empleado> empleados) {
        if(empleados == null){
            return 0;
        }
        float salario=0;
        for (int i = 0; i < empleados.size(); i++) {
            if(empleados.get(i) != null){
                salario += empleados.get(i).calcularSalarioMensual();
            }
        }
        return salario;
    }
}
