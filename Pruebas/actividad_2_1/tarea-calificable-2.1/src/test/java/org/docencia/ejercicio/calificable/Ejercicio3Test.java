package org.docencia.ejercicio.calificable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ejercicio3Test {
    private static final double EPS = 1e-9;

    @Test
    void casosClasicosTest() {
        assertEquals(84.0, Ejercicio3.areaHeron(13,14,15), EPS);

        assertEquals(6.0, Ejercicio3.areaHeron(3,4,5), EPS);

        assertEquals(12.0, Ejercicio3.areaHeron(5,5,6), EPS);
    }

    @Test
    void entradasInvalidasTest() {
        assertEquals(-1.0, Ejercicio3.areaHeron(1, 2, 3), EPS);   // degenerado
        assertEquals(-1.0, Ejercicio3.areaHeron(-3, 4, 5), EPS);  // lado no positivo
    }
}
