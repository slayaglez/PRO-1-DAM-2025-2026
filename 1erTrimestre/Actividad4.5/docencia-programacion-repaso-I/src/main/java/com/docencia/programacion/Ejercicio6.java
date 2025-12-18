package com.docencia.programacion;
/**
 * Clase que calcula el precio final a partir de precio base e impuesto
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio6 {
    
    /**
     * Funcion que devuelve un precio con un impuesto aplicado
     * @param basePrice precio inicial
     * @param taxRate impuesto
     * @return precio con impuesto
     */
    public static double calculateFinalPrice(double basePrice, double taxRate) {
        if(taxRate == 0){
            return basePrice;
        }
        double total = basePrice + basePrice*taxRate;
        return total;
    }
}
