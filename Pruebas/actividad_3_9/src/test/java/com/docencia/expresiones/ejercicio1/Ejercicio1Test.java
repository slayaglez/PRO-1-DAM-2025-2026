package com.docencia.expresiones.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

public final class Ejercicio1Test {

    

      // 1) Válida típica
    @Test
    void fechaValida_deberiaSerTrue() {
        assertTrue(Ejercicio1.esFechaDdMmAaaaValida("13/02/2026"));
    }

    // 2) Válida con ceros iniciales
    @Test
    void fechaValida_conCerosIniciales_deberiaSerTrue() {
        assertTrue(Ejercicio1.esFechaDdMmAaaaValida("01/12/1999"));
    }

    // 3) Día máximo válido
    @Test
    void fechaValida_dia31_mes01_deberiaSerTrue() {
        assertTrue(Ejercicio1.esFechaDdMmAaaaValida("31/01/2020"));
    }

    // 4) Mes máximo válido
    @Test
    void fechaValida_mes12_deberiaSerTrue() {
        assertTrue(Ejercicio1.esFechaDdMmAaaaValida("10/12/2020"));
    }

    // 5) Día fuera de rango (32)
    @Test
    void fechaInvalida_dia32_deberiaSerFalse() {
        assertFalse(Ejercicio1.esFechaDdMmAaaaValida("32/01/2020"));
    }

    // 6) Día 00 no permitido
    @Test
    void fechaInvalida_dia00_deberiaSerFalse() {
        assertFalse(Ejercicio1.esFechaDdMmAaaaValida("00/01/2020"));
    }

    // 7) Mes fuera de rango (13)
    @Test
    void fechaInvalida_mes13_deberiaSerFalse() {
        assertFalse(Ejercicio1.esFechaDdMmAaaaValida("15/13/2020"));
    }

    // 8) Mes 00 no permitido
    @Test
    void fechaInvalida_mes00_deberiaSerFalse() {
        assertFalse(Ejercicio1.esFechaDdMmAaaaValida("15/00/2020"));
    }

    // 9) Formato incorrecto (sin cero a la izquierda)
    @Test
    void fechaInvalida_sinCeroIzquierda_deberiaSerFalse() {
        assertFalse(Ejercicio1.esFechaDdMmAaaaValida("1/02/2026"));
    }

    // 10) Null debe devolver false
    @Test
    void fechaNull_deberiaSerFalse() {
        assertFalse(Ejercicio1.esFechaDdMmAaaaValida(null));
    }

   
}
