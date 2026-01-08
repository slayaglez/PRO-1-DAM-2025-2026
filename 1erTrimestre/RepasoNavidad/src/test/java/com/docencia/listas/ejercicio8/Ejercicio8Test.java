package com.docencia.listas.ejercicio8;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class Ejercicio8Test {

    @Test
    void maximoSeguro_basico() {
        Integer max = Ejercicio8.maximoSeguro(Arrays.asList(1, 10, null, 5));
        assertEquals(10, max);
    }

    @Test
    void maximoSeguro_soloNullsOListaInvalida() {
        assertNull(Ejercicio8.maximoSeguro(Arrays.asList(null, null)));
        assertNull(Ejercicio8.maximoSeguro(null));
        assertNull(Ejercicio8.maximoSeguro(Collections.emptyList()));
    }
}