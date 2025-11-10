package org.docencia.ejercicio.calificable;
/**
 * Clase que aplica la formula de Pitagoras
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio5 {

    /**
     * Constructor vacio
     */
    private Ejercicio5() {}

    /**
     * Funcion que devuelve la hipotenusa de dos catetos
     * @param a cateto numero 1
     * @param b cateto numero 2
     * @return la hipotenusa de ambos catetos
     */
    public static double hipotenusa(double a, double b) {
        if(a <= 0 || b <= 0){
            return -1.0d;
        }
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    public static double catetoDesdeHipotenusa(double c, double otroCateto) {
        if(c <= otroCateto || otroCateto <= 0){
            return -1.0d;
        }
        return Math.sqrt(Math.pow(c, 2) - Math.pow(otroCateto, 2));
    }

}
