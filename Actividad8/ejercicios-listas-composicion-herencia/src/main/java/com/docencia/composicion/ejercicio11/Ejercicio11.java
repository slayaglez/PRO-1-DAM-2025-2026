/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa de clases que trabaja con Personas y direcciones
 * permitiendo obtener una lista de personas buscando una ciudad.
 * 
 */

package com.docencia.composicion.ejercicio11;

import java.util.ArrayList;
import java.util.List;


public class Ejercicio11 {
    public static void main(String[] args) {
        Direccion direccion1 = new Direccion("Venezuela", "Caracas", "El paraíso", 98435);
        Direccion direccion2 = new Direccion("España", "Madrid", "Gran vía", 57835);
        Persona persona1 = new Persona("43388111B", "Maradona", direccion1);
        Persona persona2 = new Persona("43354432C", "Usman", direccion2);
        Persona persona3 = new Persona("43386545T", "WillyRex", direccion1);
        //System.out.println(persona1);

        List<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        //System.out.println(personas);
        List<Persona> personasEncontradas = encontrarPersonaPorCiudad(personas, "Caracas");
        System.out.println(personasEncontradas);
    }

    /**
     * Devuelve una lista de Persona que vivan en la ciudad pasada
     * @param personas Lista de tipo Persona
     * @param ciudad Nombre de la ciudad
     * @return Lista de personas de la ciudad
     */
    public static List<Persona> encontrarPersonaPorCiudad(List<Persona> personas, String ciudad){
        if(personas == null || ciudad == null || ciudad.isBlank()){
            return null;
        }

        List<Persona> personasEncontradas = new ArrayList<>();

        for (Persona persona : personas) {
            if(persona.getDireccion() != null &&
            persona.getDireccion().getCiudad() != null &&
            persona.getDireccion().getCiudad().equals(ciudad)){
                personasEncontradas.add(persona);
            }
        }
        return personasEncontradas;
    }
}
