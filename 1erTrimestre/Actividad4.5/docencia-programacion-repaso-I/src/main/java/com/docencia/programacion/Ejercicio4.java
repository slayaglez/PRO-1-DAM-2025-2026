package com.docencia.programacion;
/**
 * @author slayaglez
 * @version 1.0.0.
 */
public class Ejercicio4 {
    
    /**
     * Funcion que calcula el area de un rectangulo
     * @param base la base del rectangulo
     * @param height la altura del rectangulo
     * @return el area del rectangulo
     */
    public static int area(int base, int height) {
        int area = base * height;
        return area;
    }

    /**
     * Funcion que calcula el perimetro de un rectangulo
     * @param base la base del rectangulo
     * @param height la altura del rectangulo
     * @return el perimetro del rectangulo
     */
    public static int perimeter(int base, int height) {
        int perimetro = (base * 2) + (height * 2);
        return perimetro;
    }
}
