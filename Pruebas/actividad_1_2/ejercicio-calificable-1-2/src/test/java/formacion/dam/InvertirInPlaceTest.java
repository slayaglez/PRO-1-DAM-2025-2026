package formacion.dam;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class InvertirInPlaceTest {
  @Test
    void invierteBasico() {
        int[] res = InvertirInPlace.invertir(new int[]{1, 2, 3, 4});
        assertArrayEquals(new int[]{4, 3, 2, 1}, res);
    }

    @Test
    void unSoloElemento_NoCambia() {
        int[] res = InvertirInPlace.invertir(new int[]{7});
        assertArrayEquals(new int[]{7}, res);
    }

    @Test
    void arrayVacio_DevuelveVacio() {
        int[] res = InvertirInPlace.invertir(new int[]{});
        assertArrayEquals(new int[]{}, res);
    }

    //@Test
    void null_LanzaIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> InvertirInPlace.invertir(null));
    }

    @Test
    void noModificaElArrayOriginal_YDevuelveNuevaReferencia() {
        int[] original = {10, 20, 30, 40};
        int[] copia = original.clone();

        int[] res = InvertirInPlace.invertir(original);

        // El original no cambia
        assertArrayEquals(copia, original, "El método no debe modificar el array de entrada");
        // El resultado es un NUEVO array (no la misma referencia)
        assertNotSame(original, res, "Debe devolver un nuevo array (copia invertida)");
    }

    @Test
    void funcionaConNegativosYDuplicados() {
        int[] res = InvertirInPlace.invertir(new int[]{-1, -1, 0, 2, 2});
        assertArrayEquals(new int[]{2, 2, 0, -1, -1}, res);
    }

    @Test
    void invertirDosVecesDevuelveElOriginal() {
        int[] a = {5, 1, 9, 9, 2};
        int[] b = InvertirInPlace.invertir(a);
        int[] c = InvertirInPlace.invertir(b);
        assertArrayEquals(a, c, "Invertir dos veces debería recuperar el original");
    }
}