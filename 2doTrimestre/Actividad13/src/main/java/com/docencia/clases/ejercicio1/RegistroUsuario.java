package com.docencia.clases.ejercicio1;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;


public class RegistroUsuario {

    private final String email;
    private final String password;
    private final String telefono;
    private final LocalDate fechaNacimiento;
    private final LocalDateTime fechaRegistro;

    public RegistroUsuario(String email, String password, String telefono, LocalDate fechaNacimiento) {
        this(email, password, telefono, fechaNacimiento, Clock.systemDefaultZone());
    }

    public RegistroUsuario(String email, String password, String telefono, LocalDate fechaNacimiento, Clock clock) {
        this.email = email;
        this.password = password;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = LocalDateTime.now(clock);
    }

    public void validate(int edadMinima) {
        

        String patronEmail = "^[a-zA-Z0-9+-_%]+@[a-z]+.[a-z]{2,}$";
        if(!Pattern.matches(patronEmail, this.email)){
            throw new IllegalArgumentException("");
        }

        String patronPassword = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])\\S{8,32}$";
        if(!Pattern.matches(patronPassword, this.password)){
            throw new IllegalArgumentException("");
        }

        String patronTelefono = "^\\+34(\\s)?6[0-9]{8}$";
        if(!Pattern.matches(patronTelefono, this.telefono)){
            throw new IllegalArgumentException("");
        }

        int diaRegistro = fechaRegistro.getDayOfMonth();
        int mesRegistro = fechaRegistro.getMonthValue();
        int anioRegistro = fechaRegistro.getYear();

        LocalDate fechaRegistroBuena = LocalDate.of(anioRegistro, mesRegistro, diaRegistro);

        if(fechaNacimiento.isAfter(fechaRegistroBuena)){
            throw new IllegalArgumentException("");
        }
        if(fechaRegistroBuena.getYear()-fechaNacimiento.getYear()<14){
            throw new IllegalArgumentException();
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTelefono() {
        return telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    

   
}
