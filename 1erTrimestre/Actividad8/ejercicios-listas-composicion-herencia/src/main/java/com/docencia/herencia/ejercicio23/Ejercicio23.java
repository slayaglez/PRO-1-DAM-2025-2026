package com.docencia.herencia.ejercicio23;

/**
 * Ejercicio 23 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí la jerarquía de clases, clases base abstractas,
 * subclases concretas y métodos polimórficos correspondientes
 * al enunciado.
 */
public class Ejercicio23 {

    
    public static void main(String[] args) {
        Vehiculo vehiculo = new Coche("4223 FDK");
        //System.out.println(vehiculo.descripcion());
        
        Vehiculo avion = new Aeronave(2, "2222ACD");
        System.out.println(avion);
    
    }

}
