package com.docencia.composicion.ejercicio16;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejercicio 16 - ver la descripción detallada en el README.md.
 *
 * Diseña aquí las clases de dominio, atributos, métodos y relaciones de
 * composición correspondientes al enunciado.
 */
public class Ejercicio16 {

    public static void main(String[] args) {
        Telefono numero1 = new Telefono("fijo", "922996677");
        Telefono numero2 = new Telefono("movil", "618845790");
        Telefono numero3 = new Telefono("movil", "67891234");
        Telefono numero4 = new Telefono("fijo", "922101010");

        List<Telefono> telefonos1 = new ArrayList<>();
        telefonos1.add(numero1);
        telefonos1.add(numero2);
        Contacto contacto1 = new Contacto("Sebas", telefonos1);

        List<Telefono> telefonos2 = new ArrayList<>();
        telefonos2.add(numero3);
        telefonos2.add(numero4);
        Contacto contacto2 = new Contacto("Andrea", telefonos2);

        List<Contacto> contactos = new ArrayList<>();

        Agenda agenda = new Agenda(contactos);
    }

    

}
