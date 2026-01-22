/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.herencia.ejercicio5;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Figura {

    private UUID id;
    private String color;

    protected Figura(UUID id, String color) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.color = color;
    }

    public UUID getId() { return id; }
    public String getColor() { return color; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract double area();

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Figura other = (Figura) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Figura [id=" + id + ", color=" + color + "]";
    }

    
}
