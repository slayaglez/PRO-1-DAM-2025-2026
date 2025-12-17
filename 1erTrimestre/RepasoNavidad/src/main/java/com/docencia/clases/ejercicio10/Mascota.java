/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con Mascotas
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
    public Mascota() {}

    /**
     * Constructor con identificador unico
     * @param chip id unico
     */
    public Mascota(String chip) {
        this.chip = chip;
    }

    /**
     * Constructor con identificador unico
     * @param chip id unico
     * @param nombre nombre de la mascota
     * @param tipo tipo de mascota
     */
    public Mascota(String chip, String nombre, String tipo) {
        this.chip = chip;
        this.nombre = nombre;
        this.tipo = tipo;
    }


    /** Getters y Setters */
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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
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
