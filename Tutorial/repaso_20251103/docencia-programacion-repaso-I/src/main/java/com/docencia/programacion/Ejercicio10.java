package com.docencia.programacion;
/**
 * Clase que devuelve el salario de una semana
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio10 {

    /**
     * Funcion 
     * @param hours
     * @param hourlyRate
     * @return
     */
    public static double calculateWeeklySalary(double hours, double hourlyRate) {
        if (hourlyRate <= 0 || hours <= 0){
            return 0.0;
        }
        return (hours * hourlyRate);
    }
}
