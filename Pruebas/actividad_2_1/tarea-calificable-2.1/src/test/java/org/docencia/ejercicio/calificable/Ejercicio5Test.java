package org.docencia.ejercicio.calificable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio5Test {

    private static final double EPS = 1e-9;

    @Test
    void hipotenusasTest() {
        assertEquals(25.0, Ejercicio5.hipotenusa(7, 24), EPS); // 7-24-25
        assertEquals(13.0, Ejercicio5.hipotenusa(5, 12), EPS); // 5-12-13
        assertEquals(Math.sqrt(2), Ejercicio5.hipotenusa(1, 1), EPS);
    }

    @Test
    void hipotenusaEntradasInvalidas() {
        assertEquals(-1.0, Ejercicio5.hipotenusa(-3, 4), EPS);
        assertEquals(-1.0, Ejercicio5.hipotenusa(0, 4), EPS);
    }

    @Test
    void catetoDesdeHipotenusaTest() {
        assertEquals(12.0, Ejercicio5.catetoDesdeHipotenusa(13, 5), EPS);
        assertEquals(5.0, Ejercicio5.catetoDesdeHipotenusa(13, 12), EPS);
    }

    @Test
    void catetoDesdeHipotenusaEntradasInvalidasTest() {
        assertEquals(-1.0, Ejercicio5.catetoDesdeHipotenusa(10, 10), EPS); // c no mayor
        assertEquals(-1.0, Ejercicio5.catetoDesdeHipotenusa(5, 7), EPS);   // c < cateto
        assertEquals(-1.0, Ejercicio5.catetoDesdeHipotenusa(-5, 3), EPS);  // lado no positivo
    }

}