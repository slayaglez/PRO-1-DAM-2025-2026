package org.docencia.ejercicio.calificable;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Ejercicio4Test {

    @Test
    void basicsTest() {
        assertEquals(5, Ejercicio4.tamPalabraEnFrase("hola mundo cruel", "mundo"));
        assertEquals(4, Ejercicio4.tamPalabraEnFrase("Java java JAVa", "JAVA")); // ignora caso
        assertEquals(0, Ejercicio4.tamPalabraEnFrase("hola mundo", "adios"));
    }

    @Test
    void separadoresYPuntuacionTest() {
        assertEquals(5, Ejercicio4.tamPalabraEnFrase("¡Hola, mundo!", "mundo")); // "mundo!" no vale como palabra, pero delimitamos por no alfanum
        assertEquals(0, Ejercicio4.tamPalabraEnFrase("co-operar", "cooperar")); // el guion separa: no coincide como palabra completa
        assertEquals(2, Ejercicio4.tamPalabraEnFrase("v2 es beta", "v2"));      // dígitos cuentan
    }

    @Test
    void bordesYNulosTest() {
        assertEquals(0, Ejercicio4.tamPalabraEnFrase(null, "algo"));
        assertEquals(0, Ejercicio4.tamPalabraEnFrase("texto", null));
        assertEquals(0, Ejercicio4.tamPalabraEnFrase("texto", ""));
        assertEquals(0, Ejercicio4.tamPalabraEnFrase("   ,,,   ", "nada")); // no hay palabras
    }

    @Test
    void unicodeTest() {
        assertEquals(7, Ejercicio4.tamPalabraEnFrase("mañana canción feliz", "canción"));
        assertEquals(0, Ejercicio4.tamPalabraEnFrase("canción", "cancion")); // sin normalizar, no coincide
        assertEquals(5, Ejercicio4.tamPalabraEnFrase("emoji🙂ok fin", "emoji")); // emoji separa
    }
}
