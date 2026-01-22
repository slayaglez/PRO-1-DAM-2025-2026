/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.herencia.ejercicio4;

import java.util.Objects;
import java.util.UUID;

/**
 * Clase base abstracta.
 * Incluye un identificador unico (UUID) y campos comunes.
 */
public abstract class Animal {

    private UUID id;
    private String nombre;

    protected Animal(UUID id, String nombre) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.nombre = nombre;
    }

    public UUID getId() { return id; }
    public String getNombre() { return nombre; }

    /** Metodo abstracto para demostrar polimorfismo. */
    public abstract String sonido();

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
        Animal other = (Animal) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", nombre=" + nombre + "]";
    }

    
}
