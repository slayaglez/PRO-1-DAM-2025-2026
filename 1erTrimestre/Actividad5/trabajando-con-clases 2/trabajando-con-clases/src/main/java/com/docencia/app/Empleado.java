package com.docencia.app;

import com.docencia.clases.CuentaBancaria;

public class Empleado extends Persona{

    private Direccion direccion;
    private CuentaBancaria cuentaBancaria;

    public Empleado(){
        super();
    }

    public Empleado(String identificador, String nombre, int edad, Direccion direccion) {
        super(identificador, nombre, edad);
        this.direccion = direccion;
    }

    @Override //! Pregunta de examen el super.toString()
    public String toString() {
        return "Empleado [persona="+super.toString()+ "direccion=" + direccion + ", cuentaBancaria=" + cuentaBancaria + "]";
    }

    public static void main(String[] args) {
        String identificador = "12345678B";
        String nombre = "Juan España";
        int edad = 99;
        Direccion direccion = new Direccion("Una calle", 38260, "Tejina Centro del Mundo", 14);
        Empleado empleado = new Empleado(identificador, nombre, edad, direccion);
        System.out.println(empleado);
    
    }
}
