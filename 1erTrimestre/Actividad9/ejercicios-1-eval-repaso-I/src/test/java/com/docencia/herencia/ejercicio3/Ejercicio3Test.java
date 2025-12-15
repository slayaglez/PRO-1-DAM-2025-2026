package com.docencia.herencia.ejercicio3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ejercicio3Test {

    @Test
    void concatenarSonidos_basico() {
        Animal a1 = new Perro("Bobby");
        Animal a2 = new Gato("Misi");

        String sonidos = Ejercicio3.concatenarSonidos(Arrays.asList(a1, null, a2));
        assertEquals("guau miau", sonidos);
    }

    @Test
    void concatenarSonidos_listaNullOVacia() {
        assertEquals("", Ejercicio3.concatenarSonidos(null));
        assertEquals("", Ejercicio3.concatenarSonidos(Collections.emptyList()));
    }
}
