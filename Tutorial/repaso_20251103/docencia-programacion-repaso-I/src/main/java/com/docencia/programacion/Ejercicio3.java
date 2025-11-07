package com.docencia.programacion;
/**
 * Clase que calcula si una edad es mayor a 18 o no
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio3 {
    
    /**
     * Funcion que suma un anio
     * @param currentAge edad actual
     * @return edad mas uno
     */
    public static int ageNextYear(int currentAge) {
        if (currentAge < 0) {
            return 0;
        }
        return currentAge +1;
    }

    /**
     * Funcion que devuelve si la edad es mayor a 18 o no
     * @param age edad (entero)
     * @return si es mayor de edad o no
     */
    public static boolean isAdult(int age) {
        if (age < 18) {
            return false;
        }
        return true;
    }
}
