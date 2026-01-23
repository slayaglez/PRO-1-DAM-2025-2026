package com.docencia.examen.herencia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrecioJuegosTest {

    @Test void precioTest_arcade_0() {
        Arcade a = new Arcade("A", "Pac-Man", 0);
        assertEquals(20.0, a.precio(), 0.0001);
    }

    @Test void precioTest_arcade_10() {
        Arcade a = new Arcade("A", "Pac-Man", 10);
        assertEquals(22.0, a.precio(), 0.0001);
    }

    @Test void precioTest_arcade_100() {
        Arcade a = new Arcade("A", "Pac-Man", 100);
        assertEquals(40.0, a.precio(), 0.0001);
    }

    @Test void precioTest_mesa_0() {
        JuegoMesa m = new JuegoMesa("M", "Catan", 0);
        assertEquals(35.0, m.precio(), 0.0001);
    }

    @Test void precioTest_mesa_10() {
        JuegoMesa m = new JuegoMesa("M", "Catan", 10);
        assertEquals(38.5, m.precio(), 0.0001);
    }

    @Test void precioTest_mesa_100() {
        JuegoMesa m = new JuegoMesa("M", "Catan", 100);
        assertEquals(70.0, m.precio(), 0.0001);
    }
}
