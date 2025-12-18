package com.docencia;

import java.util.ArrayList;
import java.util.List;

public class Zoo extends Animal {
    final Animal[] animales;
    final List<Animal> animalesList;

    public Zoo() {
        animales = new Animal[3];
        animalesList = new ArrayList<>();
    }

    /**
     * Agrega un animal a la lista o array
     * @param animal animal a agregar
     * @return verdadero
     */
    public boolean add(Animal animal) {
        
        if(animal == null || animal.getChip() == null || animal.getChip().isEmpty()) {
            return false;
        }

        for (Animal animalArray : animales) {
            if(animalArray == null){
                animalArray = animal;
            }
        }
        animalesList.add(animal);

        return true;
    }

    /**
     * Devuelve verdadero si un animal esta en el array o lista
     * @param animal animal a buscar
     * @return verdadero o falso segun si esta o no
     */
    public boolean search(Animal animal) {
        
        if(animal == null || animal.getChip() == null || animal.getChip().isEmpty()) {
            return false;
        }

        for (Animal animalArray : animales) {
            if(animalArray != null && animalArray.equals(animal)){
                return true;
            }
        }

        animalesList.contains(animal);

        return true;
    }
}
