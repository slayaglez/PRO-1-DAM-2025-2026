package com.docencia.interfaces.ejercicio10;

import java.util.UUID;

/**
 * Implementacion concreta de Drawable.
 */
public class CirculoDrawable implements Drawable {

    private UUID id;
    private double radio;
    private String color;

    public CirculoDrawable(UUID id, double radio, String color) {
        if (id == null) {
            this.id = UUID.randomUUID();
        } else {
            this.id = id;
        }
        this.radio = radio;
        this.color = color;
    }

    public UUID getId() {
        return id;
    }

    public double getRadio() {
        return radio;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String dibujar() {
        return "Circulo r=" + radio;
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
        CirculoDrawable other = (CirculoDrawable) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CirculoDrawable [id=" + id + ", radio=" + radio + ", color=" + color + "]";
    }

    
}
