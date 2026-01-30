package com.docencia;

import java.time.LocalDate;
import java.time.Period;

public class UtilidadesFecha {


    /**
     * Verifica si el anio es bisiesto
     * @param fecha fecha
     * @return true / false
     */
    static boolean isBisiesto(int anio, int mes, int dia){
        try {
            LocalDate fecha = LocalDate.of(anio, mes, dia);
            return fecha.isLeapYear();
        } catch (Exception e) {
            return false;
        }
        
    }

    static int calcularEdad(LocalDate fechaNacimiento) {
        int edad=0;

        LocalDate hoy = LocalDate.now();

        edad = Period.between(fechaNacimiento, hoy).getYears();

        return edad;
    }



    public static void main(String[] args) {
        //Anio bisiesto
        LocalDate anioBisiesto1 = LocalDate.of(2024, 2, 29);
        LocalDate FechaNacimiento = LocalDate.of(2004, 1, 22);
        System.out.println("Es bisiesto: "+isBisiesto(2026, 2, 29));

        System.out.println(calcularEdad(FechaNacimiento));
    }
}
