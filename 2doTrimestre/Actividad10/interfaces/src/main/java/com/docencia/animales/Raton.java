package com.docencia.animales;

public class Raton extends AnimalAbstracto{

    @Override
    public String tuEspecie() {
        return "roedor";
    }

    @Override
    public String comer() {
        return "queso";
    }

    
}
