package org.example.unidad3.examen.ejercicio03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.docencia.unidad3.examen.ejercicio03.JuegoNotas;

public class JuegoNotasTest {

    private final JuegoNotas juego = new JuegoNotas();

    // ---------- Tests de calcularMedia ----------

    @Test
    void calcularMediaDeberiaCalcularCorrectamenteConNotasPositivas() {
        int[] notas = {5, 7, 9};

        double media = juego.calcularMedia(notas);

        assertEquals(7.0, media, 1e-9);
    }

    @Test
    void calcularMediaDeberiaCalcularCorrectamenteConNotasMixtas() {
        int[] notas = {0, 10, 5};

        double media = juego.calcularMedia(notas);

        assertEquals(5.0, media, 1e-9);
    }

    @Test
    void calcularMediaDeberiaLanzarExcepcionSiArrayVacio() {
        int[] notas = {};

        assertThrows(IllegalArgumentException.class,
                () -> juego.calcularMedia(notas));
    }

    @Test
    void calcularMediaDeberiaLanzarExcepcionSiArrayEsNull() {
        assertThrows(IllegalArgumentException.class,
                () -> juego.calcularMedia(null));
    }

    // ---------- Tests de evaluarIntento ----------

    @Test
    void evaluarIntentoDeberiaIndicarDemasiadoBaja() {
        double mediaReal = 7.0;
        double intento = 5.0;

        String resultado = juego.evaluarIntento(mediaReal, intento);

        assertEquals("Demasiado baja", resultado);
    }

    @Test
    void evaluarIntentoDeberiaIndicarDemasiadoAlta() {
        double mediaReal = 7.0;
        double intento = 9.0;

        String resultado = juego.evaluarIntento(mediaReal, intento);

        assertEquals("Demasiado alta", resultado);
    }

    @Test
    void evaluarIntentoDeberiaIndicarCorrectaCuandoCoincideExactamente() {
        double mediaReal = 7.5;
        double intento = 7.5;

        String resultado = juego.evaluarIntento(mediaReal, intento);

        assertEquals("¡Correcta!", resultado);
    }

    // ---------- Simulación de partida de hasta 5 intentos ----------

    @Test
    void simulacionPartidaHastaCincoIntentosDeberiaAcertarEnAlguno() {
        int[] notas = {5, 7, 9};
        double mediaReal = juego.calcularMedia(notas); // 7.0

        double[] intentos = {3.0, 9.0, 7.0, 10.0, 6.0};

        boolean acertado = false;
        String ultimoMensaje = null;

        for (double intento : intentos) {
            ultimoMensaje = juego.evaluarIntento(mediaReal, intento);
            if ("¡Correcta!".equals(ultimoMensaje)) {
                acertado = true;
                break;
            }
        }

        assertTrue(acertado, "El jugador debería acertar la media en alguno de los intentos.");
        assertEquals("¡Correcta!", ultimoMensaje);
    }
}
