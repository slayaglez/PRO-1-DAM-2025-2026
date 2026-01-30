package com.docencia;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Fechas {

    public static void main(String[] args) {
        Date fecha = new Date();
        LocalDate fechaActual = LocalDate.now(); //? xxxxxx dateFormat
        System.out.println(fecha);
        System.out.println(fechaActual);
        System.out.println("------");

        fecha.setDate(3);
        System.out.println(fecha);
        System.out.println(fechaActual.plusDays(3));
        System.out.println("------");

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //! M mayúscula
        System.out.println(fechaActual.format(dateFormat));
        System.out.println(fechaActual.plusYears(40));
        LocalDate fechaFutura = fechaActual.plusYears(35);

        if(fechaActual.isBefore(fechaFutura)){
            System.out.println("La fecha actual es anterior");
        } else {
            System.out.println("La fecha actual es posterior");
        }

        LocalDate lasNueve = LocalDate.of(9999, 1, 12);
        System.out.println(lasNueve);
    }
}
