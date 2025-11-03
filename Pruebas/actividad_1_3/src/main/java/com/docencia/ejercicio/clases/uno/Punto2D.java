package com.docencia.ejercicio.clases.uno;
/**
 * @brief Puto2D que contiene constructores, getters y setters de los parámetros
 * X e Y y trabaja con ellos.
 * @author slayaglez
 * @date 24 Oct 2025
 * @version 1.0.0
 */
import java.util.Objects;

public class Punto2D {
    private double x;
    private double y;

    /**
     * Constructor vacío
    */
    public Punto2D() {}

    /**
     * Constructor usando los campos
     * @param x numero double
     * @param y numero double
     */
    public Punto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    // Getters y setters
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    // toEquals
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Punto2D)) {
            return false;
        }
        Punto2D punto2D = (Punto2D) o;
        return x == punto2D.x && y == punto2D.y;
    }
    
    //hashCode
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    //toString
    @Override
    public String toString() {
        return "(x=" + getX() + ", y=" + getY()+")";
    }
    

    
}

