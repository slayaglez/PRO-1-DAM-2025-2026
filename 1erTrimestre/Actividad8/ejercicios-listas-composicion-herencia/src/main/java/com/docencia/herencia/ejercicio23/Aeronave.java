package com.docencia.herencia.ejercicio23;

public class Aeronave extends Vehiculo{

    final int alas;

    public Aeronave() {
        alas =2;
    }

    public Aeronave(int alas, String matricula) {
        super(matricula);
        this.alas = alas;
    }

    public Aeronave (String marca, String modelo, String matricula){
        super(matricula, marca, modelo);
        this.alas = 2;
    }

    public Aeronave (int alas, String modelo, String matricula){
        super(null, modelo, matricula);
        this.alas= alas;
    }

    public Aeronave (int alas, String marca, String modelo, String matricula){
        super(matricula, marca, modelo);
        this.alas = alas;
    }

    @Override
    String descripcion() {
        return "No sé cómo, pero vuelo";
    }

    @Override
    public String toString() {
        return "Avion: "+super.toString();
    }

}
