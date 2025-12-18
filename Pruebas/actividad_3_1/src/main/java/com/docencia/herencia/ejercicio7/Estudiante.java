/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase estudiante con nombre y curso
 */
package com.docencia.herencia.ejercicio7;

public class Estudiante extends Persona {
    private final String curso;

    /**
     * Constructor por defecto
     * @param nombre nombre estudiante
     * @param curso curso que cursa
     */
    public Estudiante(String nombre, String curso) {
        super(nombre);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    /**
     * Descripcion del rol del estudiante
     */
    @Override
    public String descripcionRol() {
        return "Estudiante " + getNombre() + " del curso " + getCurso();
    }
}
