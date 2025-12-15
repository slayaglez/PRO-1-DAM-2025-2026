package com.docencia.herencia.ejercicio1;

/**
 * Rectángulo definido por ancho y alto.
 */
public class Rectangulo extends Figura {
    private final double ancho;
    private final double alto;

    public Rectangulo(double ancho, double alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    @Override
    public double area() {
        // TODO: implementar área = ancho * alto.
        return 0.0;
    }
}
