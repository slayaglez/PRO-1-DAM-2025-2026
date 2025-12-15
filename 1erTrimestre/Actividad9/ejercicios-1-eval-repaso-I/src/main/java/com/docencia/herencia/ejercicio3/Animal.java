package com.docencia.herencia.ejercicio3;

/**
 * Animal base con nombre y un método para devolver su sonido característico.
 */
public abstract class Animal {
    private final String nombre;

    protected Animal(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String sonido();
}
