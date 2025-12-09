package com.docencia.herencia.ejercicio22;

/**
 * @author slayaglez
 * @version 1.0.0
 * @brief 
 */
public class Ejercicio22 {
    public static void main(String[] args) {
        EmpleadoFijo empleado1 = new EmpleadoFijo(1, "Iker", 24000);
        EmpleadoPorHoras empleado2 = new EmpleadoPorHoras(2, "Lionel", 8);

        System.out.println(empleado1.calcularSueldo());
        System.out.println(empleado2.calcularSueldo());
    }

    
}
