package com.docencia.clases;

public class Coche extends Vehiculo {
    public Coche(String matricula) {
        super("B", matricula);
    }


    @Override
    public String suSonido() {
        return "Futututututu";
    }

    @Override
    public int numeroRuedas() {
        return 4;
    }

    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Motocicleta("3371FDK");
        System.out.println(vehiculo1.suSonido());
        Vehiculo vehiculo2 = new Coche("2345NFS");
        System.out.println(vehiculo2.suSonido());

        System.out.println("Numero de ruedas del coche: " + vehiculo2.numeroRuedas());
        System.out.println("Numero de ruedas de la motocicleta: " + vehiculo1.numeroRuedas());
    }
}
