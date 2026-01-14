package com.docencia;

import java.util.ArrayList;
import java.util.List;

public class EjercicioInterface {

    public static void main(String[] args) {
        
        List<Animal> animales = new ArrayList<>();
        Avestruz jaime = new Avestruz();
        Delfin ivan = new Delfin();
        Plancton sebas = new Plancton();
        Raton nau = new Raton();

        animales.add(sebas);
        animales.add(ivan);
        animales.add(jaime);
        animales.add(nau);

        for (Animal animal : animales) {
            System.out.println(animal.comer());
        }
    }
}
