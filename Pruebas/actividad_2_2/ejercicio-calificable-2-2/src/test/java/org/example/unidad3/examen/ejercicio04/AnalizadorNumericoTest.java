package org.example.unidad3.examen.ejercicio04;

import org.docencia.unidad3.examen.ejercicio04.AnalizadorNumerico;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnalizadorNumericoTest {

    private final AnalizadorNumerico analizador = new AnalizadorNumerico();

    // ---------- Tests de contarSignos ----------

    @Test
    void contarSignosDeberiaContarCorrectamentePositivosNegativosYCeros() {
        int[] numeros = { -3, 0, 5, 10, -1, 0 };

        AnalizadorNumerico.ContadorSignos contador = analizador.contarSignos(numeros);

        assertEquals(2, contador.getPositivos());
        assertEquals(2, contador.getNegativos());
        assertEquals(2, contador.getCeros());
    }

    @Test
    void contarSignosDeberiaDevolverTodoCerosSiArrayVacio() {
        int[] numeros = {};

        AnalizadorNumerico.ContadorSignos contador = analizador.contarSignos(numeros);

        assertEquals(0, contador.getPositivos());
        assertEquals(0, contador.getNegativos());
        assertEquals(0, contador.getCeros());
    }

    @Test
    void contarSignosDeberiaLanzarIllegalArgumentExceptionSiArrayNull() {
        assertThrows(IllegalArgumentException.class,
                () -> analizador.contarSignos(null));
    }

    // ---------- Tests de calcularParesImpares ----------

    @Test
    void calcularParesImparesDeberiaSepararCorrectamenteEnRangoPositivo() {
        AnalizadorNumerico.ParesImpares resultado =
                analizador.calcularParesImpares(1, 5);

        List<Integer> pares = resultado.getPares();
        List<Integer> impares = resultado.getImpares();

        assertEquals(List.of(2, 4), pares);
        assertEquals(List.of(1, 3, 5), impares);
    }

    @Test
    void calcularParesImparesDeberiaFuncionarSiAEsMayorQueB() {
        AnalizadorNumerico.ParesImpares resultado =
                analizador.calcularParesImpares(5, 1);  // se debe interpretar como [1,5]

        List<Integer> pares = resultado.getPares();
        List<Integer> impares = resultado.getImpares();

        assertEquals(List.of(2, 4), pares);
        assertEquals(List.of(1, 3, 5), impares);
    }

    @Test
    void calcularParesImparesDeberiaFuncionarConRangoNegativo() {
        AnalizadorNumerico.ParesImpares resultado =
                analizador.calcularParesImpares(-3, 2);  // [-3, -2, -1, 0, 1, 2]

        List<Integer> pares = resultado.getPares();
        List<Integer> impares = resultado.getImpares();

        assertEquals(List.of(-2, 0, 2), pares);
        assertEquals(List.of(-3, -1, 1), impares);
    }

    @Test
    void calcularParesImparesDeberiaFuncionarSiRangoEsUnSoloNumero() {
        AnalizadorNumerico.ParesImpares resultado =
                analizador.calcularParesImpares(4, 4);

        List<Integer> pares = resultado.getPares();
        List<Integer> impares = resultado.getImpares();

        assertEquals(List.of(4), pares);
        assertTrue(impares.isEmpty());
    }

    // ---------- Tests de contarPrimos ----------

    @Test
    void contarPrimosDeberiaContarPrimosDelUnoAlDiez() {
        int cantidad = analizador.contarPrimos(1, 10);

        // Primos: 2, 3, 5, 7 -> 4
        assertEquals(4, cantidad);
    }

    @Test
    void contarPrimosDeberiaIgnorarNumerosMenoresOIgualesA1() {
        int cantidad = analizador.contarPrimos(-5, 5);

        // Primos en [-5,5]: 2, 3, 5 -> 3
        assertEquals(3, cantidad);
    }

    @Test
    void contarPrimosDeberiaFuncionarSiAEsMayorQueB() {
        int cantidad = analizador.contarPrimos(20, 10);

        // Primos en [10,20]: 11,13,17,19 -> 4
        assertEquals(4, cantidad);
    }

    @Test
    void contarPrimosDeberiaSerCeroSiNoHayPrimosEnElRango() {
        int cantidad = analizador.contarPrimos(14, 16); // 14, 15, 16

        assertEquals(0, cantidad);
    }

    // ---------- Tests de equals/hashCode para clases auxiliares (opcionales pero útiles) ----------

    @Test
    void contadorSignosEqualsYHashCodeDeberianFuncionarParaObjetosIguales() {
        AnalizadorNumerico.ContadorSignos c1 =
                new AnalizadorNumerico.ContadorSignos(1, 2, 3);
        AnalizadorNumerico.ContadorSignos c2 =
                new AnalizadorNumerico.ContadorSignos(1, 2, 3);

        assertEquals(c1, c2);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void paresImparesEqualsYHashCodeDeberianFuncionarParaObjetosIguales() {
        AnalizadorNumerico.ParesImpares p1 =
                new AnalizadorNumerico.ParesImpares(List.of(2, 4), List.of(1, 3));
        AnalizadorNumerico.ParesImpares p2 =
                new AnalizadorNumerico.ParesImpares(List.of(2, 4), List.of(1, 3));

        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());
    }
}
