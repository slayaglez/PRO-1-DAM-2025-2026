package com.docencia.herencia.ejercicio25;

public class Vaca extends Animal{
    private String especie;

    public Vaca(String tipo, String especie) {
        super(tipo);
        this.especie = especie;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String hacerSonido(){
        return "Muuuuu muuuu";
    }
}
