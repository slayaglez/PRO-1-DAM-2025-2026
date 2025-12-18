package com.docencia.herencia.ejercicio25;

public class Perro extends Animal{
    private String especie;

    public Perro(String tipo, String especie) {
        super(tipo);
        this.especie = especie;
    }

    @Override
    public String hacerSonido(){
        return "Guaf Guaf Guauuuf";
    }
}
