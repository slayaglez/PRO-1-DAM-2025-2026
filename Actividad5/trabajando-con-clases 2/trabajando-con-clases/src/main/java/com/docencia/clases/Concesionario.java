package com.docencia.clases;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Concesionario {
    final List<Coche> coches;
    public Concesionario() {
        coches = new ArrayList<>();  //! Instanciar siempre
    }

    public boolean addCoche(Coche coche) {

        if(coche == null || coche.getMatricula() == null ||  coche.getMatricula().isEmpty()){
            return false;
        }
        if (coches.contains(coche)) {
            return true;
        }
        coches.add(coche);
        return true;
    }

    public boolean deleteCoche(Coche coche) {
        if (coche == null) {
            return false;
        }
        return coches.remove(coche);
    }

    public boolean deleteCoches(List<Coche> cochesABorrar) {
        if (cochesABorrar == null) {
            return false;
        }
        return coches.removeAll(cochesABorrar);
    }

    public List<Coche> cochesOrdenadosPorMatricula() { //! Pregunta de examen
        coches.sort(Comparator
            .comparing((Coche c)-> c.getMatricula(), 
            Comparator.reverseOrder()));

        return coches;  
    }

     public List<Coche> cochesOrdenadosPorModelo() {
        coches.sort(Comparator
            .comparing((Coche c)-> c.getModelo(), 
            Comparator.reverseOrder()));

        return coches;  
    }

    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();
        Coche coche1 = new Coche("3371 FDC");
        Coche coche2 = new Coche("3371 FDK");
        Coche coche3 = new Coche("4222 ZBQ");
        Coche coche4 = new Coche("7223 DTF");
        
        concesionario.addCoche(coche1);
        concesionario.addCoche(coche2);
        concesionario.addCoche(coche3);
        concesionario.addCoche(coche4);
        
        List<Coche> cochesBorrar = new ArrayList<>();
        cochesBorrar.add(coche1);
        cochesBorrar.add(coche2);
        cochesBorrar.add(coche3);
        concesionario.deleteCoches(cochesBorrar);
        
        // Coche cocheMalo = new Coche("3371 FDK");
        // concesionario.deleteCoche(cocheMalo);

        List<Coche> cochesOrdenadosPorMatricula = concesionario.cochesOrdenadosPorMatricula();
        System.out.println(cochesOrdenadosPorMatricula);
    }
}
