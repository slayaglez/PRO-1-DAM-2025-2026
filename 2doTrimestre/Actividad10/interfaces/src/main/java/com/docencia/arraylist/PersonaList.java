package com.docencia.arraylist;

import java.util.ArrayList;
import java.util.List;

public class PersonaList extends ArrayList{

    final List<Persona> lista;

    public PersonaList(){
        lista = new ArrayList<>();
    }

    /**
     * Add a personita
     * @param persona Persona
     * @return true or false
     */
    public boolean add(Persona persona){
        
        if (lista == null || persona == null || persona.getId() == null || persona.getId().isBlank()){
            return false;
        }

        int posicion = lista.indexOf(persona);
        if(posicion > -1) {
            return false;
        }
        return lista.add(persona);
    }

    /**
     * Remove a personita by Id
     * @param id Identificador
     * @return true or false
     */
    public boolean remove(String id){

        Persona personaEliminar = new Persona(id);
        return remove(personaEliminar);
    }

    /**
     * Remove a personita by persona
     * @param persona Persona a eliminar
     * @return true or false
     */
    public boolean remove(Persona persona){

        int posicion = lista.indexOf(persona);
        if(posicion < 0) {
            return false;
        }
        return lista.remove(persona);
    }

}
