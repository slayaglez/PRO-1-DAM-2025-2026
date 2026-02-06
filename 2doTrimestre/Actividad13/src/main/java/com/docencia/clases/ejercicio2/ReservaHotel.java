package com.docencia.clases.ejercicio2;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ReservaHotel {

    private final String codigoReserva;
    private final String dni;
    private final LocalDate checkIn;
    private final LocalDate checkOut;

    public ReservaHotel(String codigoReserva, String dni, LocalDate checkIn, LocalDate checkOut) {
        this.codigoReserva = codigoReserva;
        this.dni = dni;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public void validate() {
        String patronDni = "^[0-9]{8}[A-Z]$";
        String patronCodigo = "^RES-[0-9]{4}-[A-Z]{3}$";

        boolean validDni = Pattern.matches(patronDni, this.dni);
        boolean validCodigo = Pattern.matches(patronCodigo, this.codigoReserva);

        if(!validDni){
            throw new IllegalArgumentException("DNI incorrecto");
        }
        if(!validCodigo){
            throw new IllegalArgumentException("Codigo incorrecto");
        }
        if(checkIn.isAfter(checkOut) || checkIn.equals(checkOut)){
            throw new IllegalArgumentException("Check in despues del check out");
        }

        // la letra del dni
        String cadenaDni = "TRWAGMYFPDXBNJZSQVLCKE";
        String dniNumeroStr = this.dni.substring(0,8);
        int dniNumero = Integer.parseInt(dniNumeroStr);
        int resto = dniNumero % 23;
        char letra = cadenaDni.charAt(resto);
        String letraStr = String.valueOf(letra);
        if(!this.dni.substring(8,9).equals(letraStr)){
            throw new IllegalArgumentException("Letra DNI incorrecta");
        }
    }

    public long noches() {
        long resultado = checkOut.getDayOfYear() - checkIn.getDayOfYear();
        return resultado;
    }

    public boolean puedeCancelar(LocalDate hoy) {
        int diaHoy = hoy.getDayOfMonth();
        int diaCheck = checkIn.getDayOfMonth();
        return diaCheck-diaHoy >= 2;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }
}
