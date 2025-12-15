package com.docencia.herencia.ejercicio21;

public class Triangulo extends Figura{

    private long altura;
    private long base;

    public Triangulo(long altura, long base){
        this.altura = altura;
        this.base = base;
    }

    @Override
    public double area() {
        return (base * altura)/2;
    }
}
