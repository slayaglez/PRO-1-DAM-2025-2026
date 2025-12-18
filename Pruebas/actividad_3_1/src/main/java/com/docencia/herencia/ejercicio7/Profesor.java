/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase profesor con nombre y especialidad
 */
package com.docencia.herencia.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona {
    private final String especialidad;

    /**
     * Constructor por defecto
     * @param nombre nombre del profesor
     * @param especialidad nombre de la especialidad
     */
    public Profesor(String nombre, String especialidad) {
        super(nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Describe el rol
     */
    @Override
    public String descripcionRol() {
        return "Profesor " + getNombre() + " de " + getEspecialidad();
    }

    /**
     * Devuelve una lista de descripciones de las personas
     * @param personas lista de personas
     * @return lista de descripciones de personas
     */
    public static List<String> descripciones(List<Persona> personas) {

        if (personas == null) {
            return new ArrayList<>();
        }

        List<String> resultado = new ArrayList<>();

        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i) != null) {
                Persona persona = personas.get(i);
                String descripcionPersona = persona.descripcionRol();
                if (descripcionPersona != null || !(descripcionPersona.isBlank())) {
                    resultado.add(descripcionPersona);
                }
            }

        }
        return resultado;
    }
}
