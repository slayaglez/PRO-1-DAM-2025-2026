/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con Coches
 */
package com.docencia.clases.ejercicio3;

import java.util.Objects;

public class Coche {
    private String matricula;
    private String marca;
    private int anio;

    /**
     * Constructor vacio
     */
    public Coche() {}

    /**
     * Constructor por defecto
     * @param matricula identificador unico
     */
    public Coche(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Constructor por defecto
     * @param matricula identificador unico
     * @param marca marca del coche
     * @param anio anio del vehiculo
     */
    public Coche(String matricula, String marca, int anio) {
        this.matricula = matricula;
        this.marca = marca;
        this.anio = anio;
    }
    
    /** Getters y Setters */
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coche other = (Coche) obj;
        return Objects.equals(matricula, other.matricula);
    }

    @Override
    public String toString() {
        return "Coche [matricula=" + matricula + ", marca=" + marca + ", anio=" + anio + "]";
    }

    
}
