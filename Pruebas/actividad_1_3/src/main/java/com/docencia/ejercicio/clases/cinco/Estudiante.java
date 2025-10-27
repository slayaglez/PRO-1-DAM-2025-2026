package com.docencia.ejercicio.clases.cinco;
/**
 * @brief Clase coche que contiene constructores, getters y setters de los parámetros
 * dni y nombre de estudiantes y trabaja con ellos.
 * @author slayaglez
 * @date 24 Oct 2025
 * @version 1.0.0
 */
import java.util.Objects;

public class Estudiante {
    private String dni;
    private String nombre;

    /**
     * Constructor vacío
     */
    public Estudiante(){}

    /**
     * Constructor solo matricula
     * @param dni identificador
     * @param nombre nombre del alumno
     */
    public Estudiante(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() { return dni; }
    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estudiante)) {
            return false;
        }
        Estudiante estudiante = (Estudiante) o;
        return Objects.equals(dni.toUpperCase(), estudiante.dni.toUpperCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni.toUpperCase());
    }


    @Override
    public String toString() {
        return getDni() + " - " + getNombre();
    }

}

