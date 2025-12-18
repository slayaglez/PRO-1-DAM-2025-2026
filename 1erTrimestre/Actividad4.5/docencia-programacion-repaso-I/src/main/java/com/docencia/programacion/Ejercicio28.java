package com.docencia.programacion;
/** 
 * Clase que trabaja con dos cordenadas de un vector
 * @author slayaglez
 * @version 1.0.0
*/
public class Ejercicio28 {
    private final double x;
    private final double y;

    /**
     * Constructor por defecto
     * @param x punto x
     * @param y punto y
     */
    public Ejercicio28(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Funcion que suma que coordenadas
     * @param other
     * @return
    */
    public Ejercicio28 add(Ejercicio28 other) {
        return new Ejercicio28(this.x + other.x, this.y + other.y);
    }

    public double magnitude() {
        return (Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)));
    }

    public double distanceTo(Ejercicio28 other) {
        // TODO implementar
        return 0.0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
