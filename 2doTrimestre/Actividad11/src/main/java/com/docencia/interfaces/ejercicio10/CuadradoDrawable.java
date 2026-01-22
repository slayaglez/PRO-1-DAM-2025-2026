/**
 * @author slayaglez
 * @version 1.0.0
 * @brief ejercicios evaluables 3.3
 */
package com.docencia.interfaces.ejercicio10;

import java.util.UUID;

/**
 * Implementacion concreta de Drawable.
 */
public class CuadradoDrawable implements Drawable {

    private UUID id;
    private double lado;
    private String color;

    public CuadradoDrawable(UUID id, double lado, String color) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.lado = lado;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public double getLado() {
        return lado;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String dibujar() {
        return "Cuadrado l=" + lado;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CuadradoDrawable other = (CuadradoDrawable) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CuadradoDrawable [id=" + id + ", lado=" + lado + ", color=" + color + "]";
    }

    
}
