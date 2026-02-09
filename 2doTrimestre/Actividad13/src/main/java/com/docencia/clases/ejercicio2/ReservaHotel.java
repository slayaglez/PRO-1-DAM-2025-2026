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
            throw new IllegalArgumentException();
        }
        if(!validCodigo){
            throw new IllegalArgumentException();
        }
    }

    public long noches() {
        long resultado = checkOut.getDayOfYear() - checkIn.getDayOfYear();
        return resultado;
    }

    public boolean puedeCancelar(LocalDate hoy) {
        throw new UnsupportedOperationException("TODO");
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
