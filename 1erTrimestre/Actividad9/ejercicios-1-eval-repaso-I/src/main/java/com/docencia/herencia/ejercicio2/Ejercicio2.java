package com.docencia.herencia.ejercicio2;

import java.util.List;

/**
 * HERENCIA – Ejercicio 2: Empleados y nómina.
 *
 * Implementa el cálculo de salario y el coste total de la nómina.
 * Esta clase incluye un main opcional para pruebas manuales.
 */
public class Ejercicio2 {

    private Ejercicio2() {
    }

    public static void main(String[] args) {
        Empleado e1 = new EmpleadoFijo("Ana", 1000.0);
        Empleado e2 = new EmpleadoPorHoras("Luis", 80, 10.0);

        double total = costeTotalNomina(List.of(e1, e2));
        System.out.println("Coste total nómina = " + total);
    }

    public static double costeTotalNomina(List<Empleado> empleados) {
        // TODO: sumar salarios de empleados no nulos.
        return 0.0;
    }
}
