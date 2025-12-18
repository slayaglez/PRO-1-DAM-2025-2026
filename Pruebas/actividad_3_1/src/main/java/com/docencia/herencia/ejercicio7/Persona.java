/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase Persona con nombre
 */
package com.docencia.herencia.ejercicio7;


public abstract class Persona {
    private final String nombre;

    /**
     * Constructor por defecto
     * @param nombre nombre de la persona
     */
    protected Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String descripcionRol();
}
