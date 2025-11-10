package org.docencia.ejercicio.calificable;
/**
 * Clase que aplica la formula de Heron
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio3 {

    /**
     * Constructor vacio
     */
    private Ejercicio3() {}

    /**
     * Funcion que aplica la formula de Heron
     * @param a lado numero 1
     * @param b lado numero 2
     * @param c lado numero 3
     * @return area calculada
     */
    public static double areaHeron(double a, double b, double c) {
        
        if(a < 0 || b < 0 || c < 0){
            return -1.0d;
        }
        if(a+b < c || a+c < b || b+c < a){
            return -1.0d;
        }

        double semiperimetro=0.0d;
        semiperimetro = (a + b + c) / 2;

        double area=0.0d;
        area= Math.sqrt(semiperimetro * (semiperimetro - a) * (semiperimetro - b) * (semiperimetro - c));
        if (area > 0) {
            return area;
        }
        return -1.0d;
    }

  
    
}
