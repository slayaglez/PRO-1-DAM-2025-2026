package com.docencia.clases;

public class Profesor extends Alumno{
    private String cursoImparte;

    public Profesor() {}

    public Profesor(String identificador, String nombre, int edad, String cursoEstudia) {
        
        super(identificador, nombre, edad, cursoEstudia);
        this.cursoImparte = cursoImparte;
    
    }
    public static void main(String[] args) {
        Profesor profesor = new Profesor();  
        System.out.println(profesor.getEdad());  
    }
}
