package com.docencia.herencia.ejercicio23;

public class Coche extends Vehiculo {
    public Coche() {

    }

    public Coche(String matricula){
        super(matricula);
    }

    public Coche(String marca, String modelo, String matricula){
        super(marca, modelo, matricula);
    }

    @Override
    public String toString(){
        return "Coche: " + super.toString();
    }

    @Override
    String descripcion() {
        return "Yo soy un coche verde del toscal";
    }

    
}
