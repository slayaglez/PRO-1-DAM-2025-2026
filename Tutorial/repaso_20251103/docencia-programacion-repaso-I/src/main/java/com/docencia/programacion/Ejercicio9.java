package com.docencia.programacion;
/**
 * Clase que calcula 
 */
public class Ejercicio9 {
    /**
     * Funcion que calcula el valor absoluto
     * 
     * @param x valor de entrada
     * @return valor absoluto calculado
     */
    public static int absValue(int x) {
        return Math.abs(x);
    }

    /**
     * Funcion que devuelve el mayor valor
     * @param a valor de entrada 1
     * @param b valor de entrada 2
     * @return valor mayor calculado
     */
    public static int maxOfTwo(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    /**
     * Funcion que devuelve el módulo de la distancia entre dos puntos
     * @param x1 posicion en el eje x del punto 1
     * @param y1 posicion en el eje y del punto 1
     * @param x2 posicion en el eje x del punto 2
     * @param y2 posicion en el eje y del punto 2
     * @return Modulo de la distancia entre dos puntos
     */
    public static double distance2D(double x1, double y1, double x2, double y2) {
        double resultado;
        resultado = Math.sqrt(Math.pow((x2-x1), 2) + Math.pow((y2-y1), 2));
        return resultado;
    }
}
