package com.docencia.listas.ejercicio06;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class Ejercicio06Test {

    @Test
    void filtrarMayoresQue() {
        List<Integer> datos = Arrays.asList(1, 5, 10, 3, 7);
        List<Integer> filtrados = Ejercicio06.filtrarMayoresQue(datos, 4);
        assertEquals(Arrays.asList(5, 10, 7), filtrados);
    }
}
