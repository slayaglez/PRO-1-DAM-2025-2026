package com.docencia.herencia.ejercicio5;

import java.util.UUID;

public class Rectangulo extends Figura {

    private double ancho;
    private double alto;

    public Rectangulo(UUID id, String color, double ancho, double alto) {
        super(id, color);
        this.ancho = ancho;
        this.alto = alto;
}

    public double getAncho() { return ancho; }
    public double getAlto() { return alto; }

    @Override
    public double area() {
        return getAncho() * getAlto();
    }

    @Override
    public String toString() {
        return "Rectangulo [ancho=" + ancho + ", alto=" + alto + ", id=" + getId() + "]";
    }

    
}
