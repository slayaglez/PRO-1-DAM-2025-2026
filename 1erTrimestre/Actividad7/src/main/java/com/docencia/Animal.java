package com.docencia;

import java.util.Objects;

public class Animal {
    private String chip;
    private String nombre;

    public Animal() {}

    /** Getters y Setters */
    public void setChip(String chip) {
        this.chip = chip;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getChip() {
        return chip;
    }

    public String getNombre() {
        return nombre;
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
        Animal other = (Animal) obj;
        return Objects.equals(chip, other.chip);
    }

    
    
}
