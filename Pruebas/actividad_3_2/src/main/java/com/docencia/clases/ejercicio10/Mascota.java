/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que trabaja con la clase Mascota
 */
package com.docencia.clases.ejercicio10;

import java.util.Objects;

public class Mascota {
    private String chip;
    private String nombre;
    private String tipo;

    /**
     * Constructor vacio
     */
    public Mascota() {
    }

    /**
     * Constructor con id unico
     * @param chip identificador unico
     */
    public Mascota(String chip) {
        this.chip = chip;
    }

    /**
     * Constructor por defecto
     * @param chip identificador unico
     * @param nombre nombre mascota
     * @param tipo tipo de mascota
     */
    public Mascota(String chip, String nombre, String tipo) {
        this.chip = chip;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chip);
    }

    @Override
    public boolean equals(Object obj) {
        
        if (obj == null)
            return false;

        if (this == obj)
            return true;
        
        if (getClass() != obj.getClass())
            return false;
        Mascota other = (Mascota) obj;
        return Objects.equals(chip, other.chip);
    }

    @Override
    public String toString() {
        return "Mascota [chip=" + chip + ", nombre=" + nombre + ", tipo=" + tipo + "]";
    }

    
}
