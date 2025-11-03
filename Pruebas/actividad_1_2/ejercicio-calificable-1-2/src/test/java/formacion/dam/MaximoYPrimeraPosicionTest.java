package formacion.dam;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MaximoYPrimeraPosicionTest {
  @Test
    void basico_MaxYPrimeraPosicion() {
        // [7, 2, 5, 2, 9] -> max = 9, idx = 4
        int[] res = MaximoYPrimeraPosicion.calcular(new int[]{7, 2, 5, 2, 9});
        assertNotNull(res);
        assertEquals(2, res.length, "Debe devolver [max, indice]");
        assertEquals(9, res[0]);
        assertEquals(4, res[1]);
    }

    @Test
    void negativosYRepetidos_PrimeraAparicion() {
        // [-3, -1, -1, -2] -> max = -1, idx = 1 (primera aparición)
        int[] res = MaximoYPrimeraPosicion.calcular(new int[]{-3, -1, -1, -2});
        assertArrayEquals(new int[]{-1, 1}, res);
    }

    @Test
    void unSoloElemento() {
        int[] res = MaximoYPrimeraPosicion.calcular(new int[]{42});
        assertArrayEquals(new int[]{42, 0}, res);
    }

    @Test
    void arrayVacio_LanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> MaximoYPrimeraPosicion.calcular(new int[]{}));
    }

    @Test
    void null_LanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> MaximoYPrimeraPosicion.calcular(null));
    }

    @Test
    void noModificaElArrayOriginal_YDevuelveNuevaReferencia() {
        int[] original = {5, 10, 10, 1};
        int[] copia = original.clone();

        int[] res = MaximoYPrimeraPosicion.calcular(original);

        // No modifica el array de entrada
        assertArrayEquals(copia, original, "El método no debe modificar el array de entrada");
        // Devuelve un NUEVO array (no la misma referencia)
        assertNotSame(original, res, "Debe devolver un nuevo array");
    }

    @Test
    void limitesEnteros() {
        // max es Integer.MAX_VALUE en la posición 1
        int[] res1 = MaximoYPrimeraPosicion.calcular(
                new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, 0});
        assertArrayEquals(new int[]{Integer.MAX_VALUE, 1}, res1);

        // todos iguales -> devuelve ese valor y el índice 0
        int[] res2 = MaximoYPrimeraPosicion.calcular(new int[]{7, 7, 7});
        assertArrayEquals(new int[]{7, 0}, res2);
    }

}