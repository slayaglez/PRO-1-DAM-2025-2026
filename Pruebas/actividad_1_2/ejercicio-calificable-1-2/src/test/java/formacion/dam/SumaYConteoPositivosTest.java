package formacion.dam;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SumaYConteoPositivosTest {
@Test
    void basico_SumaYConteo() {
        // [1, -2, 3, 0, 5] -> suma=9 (1+3+5), conteo=3
        int[] res = SumaYConteoPositivos.calcular(new int[]{1, -2, 3, 0, 5});
        assertNotNull(res);
        assertEquals(2, res.length, "Debe devolver [suma, conteo]");
        assertEquals(9, res[0]);
        assertEquals(3, res[1]);
    }

    @Test
    void soloNegativosYZeros_ResultadoCero() {
        int[] res1 = SumaYConteoPositivos.calcular(new int[]{-1, -2, -3});
        assertArrayEquals(new int[]{0, 0}, res1);

        int[] res2 = SumaYConteoPositivos.calcular(new int[]{0, 0, 0});
        assertArrayEquals(new int[]{0, 0}, res2);
    }

    @Test
    void unSoloElementoPositivo() {
        int[] res = SumaYConteoPositivos.calcular(new int[]{7});
        assertArrayEquals(new int[]{7, 1}, res);
    }

    @Test
    void arrayVacio_DevuelveCeros() {
        int[] res = SumaYConteoPositivos.calcular(new int[]{});
        assertArrayEquals(new int[]{0, 0}, res);
    }

    @Test
    void null_LanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> SumaYConteoPositivos.calcular(null));
    }

    @Test
    void noModificaElArrayOriginal_YDevuelveNuevaReferencia() {
        int[] original = {10, 0, -5, 2, 2};
        int[] copia = original.clone();

        int[] res = SumaYConteoPositivos.calcular(original);

        // El original no cambia
        assertArrayEquals(copia, original, "No debe modificar el array de entrada");
        // Devuelve un NUEVO array (no la misma referencia)
        assertNotSame(original, res, "Debe devolver un nuevo array resultado");
    }

    @Test
    void valoresGrandes_SinOverflowInt() {
        // 1_000_000_000 + 500_000_000 = 1_500_000_000 (cabe en int)
        int[] res = SumaYConteoPositivos.calcular(new int[]{1_000_000_000, -3, 500_000_000});
        assertArrayEquals(new int[]{1_500_000_000, 2}, res);
    }

    @Test
    void mezcla_PosYNeg_YZeros() {
        // Positivos: 4, 1, 9 -> suma=14, conteo=3
        int[] res = SumaYConteoPositivos.calcular(new int[]{-2, 4, 0, 1, -7, 9});
        assertArrayEquals(new int[]{14, 3}, res);
    }
}