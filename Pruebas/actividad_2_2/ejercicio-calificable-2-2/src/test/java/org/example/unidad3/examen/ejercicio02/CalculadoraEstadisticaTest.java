package org.example.unidad3.examen.ejercicio02;

import org.docencia.unidad3.examen.ejercicio02.CalculadoraEstadistica;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraEstadisticaTest {

    private final CalculadoraEstadistica calc = new CalculadoraEstadistica();


    @ParameterizedTest
    @CsvSource({
            "3.0, 5.0, 1, 8.0",    // suma
            "10.0, 4.0, 2, 6.0",   // resta
            "2.0, 3.5, 3, 7.0"     // multiplicacion
    })
    void operarDeberiaCalcularCorrectamenteParaOpciones123(double a, double b, int opcion, double esperado) {
        double resultado = calc.operar(a, b, opcion);
        assertEquals(esperado, resultado, 1e-9);
    }

    @Test
    void operarDivisionDeberiaCalcularCorrectamente() {
        double resultado = calc.operar(10.0, 4.0, 4);
        assertEquals(2.5, resultado, 1e-9);
    }

    @Test
    void operarDivisionConNegativosDeberiaCalcularCorrectamente() {
        double resultado = calc.operar(-9.0, 3.0, 4);
        assertEquals(-3.0, resultado, 1e-9);
    }

    @Test
    void operarDeberiaLanzarArithmeticExceptionAlDividirEntreCero() {
        assertThrows(ArithmeticException.class,
                () -> calc.operar(5.0, 0.0, 4));
    }

    @Test
    void operarNoDeberiaLanzarExceptionSiOpcionNoEsDivisionAunqueBSeaCero() {
        assertDoesNotThrow(() -> calc.operar(5.0, 0.0, 1));
        double resultado = calc.operar(5.0, 0.0, 1);
        assertEquals(5.0, resultado, 1e-9);
    }

    @Test
    void operarDeberiaLanzarIllegalArgumentExceptionSiOpcionEsInvalida() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.operar(3.0, 4.0, 0));

        assertThrows(IllegalArgumentException.class,
                () -> calc.operar(3.0, 4.0, 5));
    }

    // ---------- Tests de calcularEstadisticas ----------

    @Test
    void calcularEstadisticasDeberiaCalcularCorrectamenteValoresBasicos() {
        double[] numeros = {1.0, 2.0, 3.0, 4.0};

        CalculadoraEstadistica.Estadisticas est = calc.calcularEstadisticas(numeros);

        assertEquals(4, est.getCantidad());
        assertEquals(2.5, est.getMedia(), 1e-9);
        assertEquals(4.0, est.getMaximo(), 1e-9);
        assertEquals(1.0, est.getMinimo(), 1e-9);
    }

    @Test
    void calcularEstadisticasDeberiaFuncionarConUnSoloElemento() {
        double[] numeros = {7.5};

        CalculadoraEstadistica.Estadisticas est = calc.calcularEstadisticas(numeros);

        assertEquals(1, est.getCantidad());
        assertEquals(7.5, est.getMedia(), 1e-9);
        assertEquals(7.5, est.getMaximo(), 1e-9);
        assertEquals(7.5, est.getMinimo(), 1e-9);
    }

    @Test
    void calcularEstadisticasDeberiaCalcularCorrectamenteConNegativos() {
        double[] numeros = {-5.0, 0.0, 10.0};

        CalculadoraEstadistica.Estadisticas est = calc.calcularEstadisticas(numeros);

        assertEquals(3, est.getCantidad());
        assertEquals(( -5.0 + 0.0 + 10.0 ) / 3.0, est.getMedia(), 1e-9);
        assertEquals(10.0, est.getMaximo(), 1e-9);
        assertEquals(-5.0, est.getMinimo(), 1e-9);
    }

    @Test
    void calcularEstadisticasDeberiaLanzarIllegalArgumentExceptionSiArrayVacio() {
        double[] numeros = {};

        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularEstadisticas(numeros));
    }

    @Test
    void calcularEstadisticasDeberiaLanzarIllegalArgumentExceptionSiArrayNulo() {
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularEstadisticas(null));
    }

    // ---------- Tests de equals/hashCode en Estadisticas (opcionales pero útiles) ----------

    @Test
    void estadisticasEqualsYHashCodeDeberianFuncionarParaObjetosIguales() {
        CalculadoraEstadistica.Estadisticas e1 =
                new CalculadoraEstadistica.Estadisticas(3, 2.0, 4.0, 0.0);
        CalculadoraEstadistica.Estadisticas e2 =
                new CalculadoraEstadistica.Estadisticas(3, 2.0, 4.0, 0.0);

        assertEquals(e1, e2);
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    void estadisticasEqualsDeberiaSerFalsoParaObjetosDiferentes() {
        CalculadoraEstadistica.Estadisticas e1 =
                new CalculadoraEstadistica.Estadisticas(3, 2.0, 4.0, 0.0);
        CalculadoraEstadistica.Estadisticas e2 =
                new CalculadoraEstadistica.Estadisticas(4, 2.0, 4.0, 0.0);

        assertNotEquals(e1, e2);
    }
}
