package com.docencia.clases;
import java.util.ArrayList;
import java.util.List;

public class Concesionario {
    List<Coche> coches = null;

    public Concesionario() {
    
        coches = new ArrayList<>();  //! Instanciar siempre
    }

    public boolean addCoche(Coche coche) {

        if(coche == null || coche.getMatricula() == null ||  coche.getMatricula().isEmpty()){
            return false;
        }
        coches.add(coche);
        return true;
    }
}
