package com.docencia.herencia.ejercicio30;

import java.util.ArrayList;
import java.util.List;

import com.docencia.herencia.ejercicio21.Circulo;
import com.docencia.herencia.ejercicio21.Figura;
import com.docencia.herencia.ejercicio21.Triangulo;

/**
 * Ejercicio 30 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí la jerarquía de clases, clases base abstractas,
 * subclases concretas y métodos polimórficos correspondientes
 * al enunciado.
 */
public class Ejercicio30 {
    public static void main(String[] args) {
        Figura triangulo = new Triangulo(10, 2);
        Figura circulo1 = new Circulo(2);
        Figura circulo2 = new Circulo(4);
        Figura cuadrado = new Figura(5,5);

        List<Figura> figuras = new ArrayList<>();
        figuras.add(cuadrado);
        figuras.add(triangulo);
        figuras.add(circulo1);
        figuras.add(circulo2);
        

        GrupoFiguras grupoFiguras = new GrupoFiguras(figuras);
        System.out.println(grupoFiguras.areaTotal());
        System.out.println(grupoFiguras.areaTotalCirculo());
        System.out.println(grupoFiguras.areaTotalOtros());
        System.out.println(grupoFiguras.areaTotalTriangulo());
    }
}
