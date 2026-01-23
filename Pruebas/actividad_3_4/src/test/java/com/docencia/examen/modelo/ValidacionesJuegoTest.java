package com.docencia.examen.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.docencia.examen.herencia.Arcade;

public class ValidacionesJuegoTest {

    @Test void constructorTest_idNull_lanza() {
        assertThrows(IllegalArgumentException.class, () -> new Arcade(null, "T", 0));
    }

    @Test void constructorTest_idBlank_lanza() {
        assertThrows(IllegalArgumentException.class, () -> new Arcade(" ", "T", 0));
    }

    @Test void constructorTest_tituloNull_lanza() {
        assertThrows(IllegalArgumentException.class, () -> new Arcade("A1", null, 0));
    }

    @Test void constructorTest_tituloBlank_lanza() {
        assertThrows(IllegalArgumentException.class, () -> new Arcade("A1", " ", 0));
    }

    @Test void constructorTest_complementoFueraRango_lanza() {
        assertThrows(IllegalArgumentException.class, () -> new Arcade("A1", "T", -1));
        assertThrows(IllegalArgumentException.class, () -> new Arcade("A1", "T", 101));
    }

    @Test void constructorTest_ok_noLanza() {
        assertDoesNotThrow(() -> new Arcade("A1", "T", 50));
    }
}
