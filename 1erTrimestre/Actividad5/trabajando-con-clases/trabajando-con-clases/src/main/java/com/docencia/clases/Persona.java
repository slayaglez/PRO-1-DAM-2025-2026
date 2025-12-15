package com.docencia.clases;

/**
 * Clase Persona que identifica a una persona de forma unica
 */
public class Persona {
    private String nombre;
    private int edad;
    private String dni;

    /**
     * Constructor vacio
     */
    public Persona(){}

    /**
     * Constructor del identificador unico
     * @param dni identificador
     */
    public Persona(String dni){
        this.dni = dni;
    }

    /**
     * Constructor por defecto
     * @param nombre nombre
     * @param edad edad
     * @param dni identificador
     */
    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni=dni;
    }


    public int getEdad(){
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad){
        if(edad < 0){
        throw new IllegalArgumentException("edad");
        }
        this.edad = edad;
    }

    public void setNombre(String nombre){
        if(nombre.isEmpty()){
        throw new IllegalArgumentException("nombre");
        }
        this.nombre = nombre;
    }

    public static void main(String[] args) {
        Persona persona = new Persona();
        persona.setNombre("Ana");
        persona.setEdad(21);
        System.out.println(persona.nombre + " (" + persona.edad + ")");
        persona.setEdad(5);
        System.out.println(persona.nombre + " (" + persona.edad + ")");

    }
}

