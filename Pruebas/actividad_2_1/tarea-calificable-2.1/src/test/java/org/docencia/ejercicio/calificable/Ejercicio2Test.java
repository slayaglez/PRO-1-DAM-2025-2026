package org.docencia.ejercicio.calificable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ejercicio2Test {

    @Test
    void basicTest() {
        assertEquals(4, Ejercicio2.contarVocales("Hola mundo"));
        assertEquals(5, Ejercicio2.contarVocales("aeiou"));
        assertEquals(5, Ejercicio2.contarVocales("AEIOU"));
    }

    @Test
    void conEspaciosYSignosTest() {
        assertEquals(5, Ejercicio2.contarVocales(" A!e? I,O.U "));
        assertEquals(0, Ejercicio2.contarVocales("12345,.-"));
    }

    @Test
    void sinVocalesTest() {
        assertEquals(0, Ejercicio2.contarVocales("rhythms"));
        assertEquals(0, Ejercicio2.contarVocales("sky"));
    }

    @Test
    void nulosYVaciosTest() {
        assertEquals(0, Ejercicio2.contarVocales(""));
        assertEquals(0, Ejercicio2.contarVocales(null));
    }

    @Test
    void repetidasYMezclaTest() {
        assertEquals(5, Ejercicio2.contarVocales("abracadabra"));
        assertEquals(10, Ejercicio2.contarVocales("Java y Codigo: aula uno"));
        assertEquals(3, Ejercicio2.contarVocales("bbbAaaccc"));
    }
}
