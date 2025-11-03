package formacion.dam;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
class ElementosSobreMediaTest {
    @Test
    void elementosMayoresQueMedia_Basico() {
        // media = (2+4+6+8)/4 = 5.0 -> > 5.0 => [6, 8]
        int[] res = ElementosSobreMedia.filtrar(new int[]{2, 4, 6, 8});
        assertArrayEquals(new int[]{6, 8}, res);
    }

    @Test
    void todosIguales_DevuelveVacio() {
        // media = 5.0 -> no hay estrictamente mayores
        int[] res = ElementosSobreMedia.filtrar(new int[]{5, 5, 5});
        assertArrayEquals(new int[]{}, res);
    }

    @Test
    void arrayVacio_DevuelveVacio() {
        int[] res = ElementosSobreMedia.filtrar(new int[]{});
        assertArrayEquals(new int[]{}, res);
    }

    //@Test
    void null_LanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> ElementosSobreMedia.filtrar(null));
    }

    @Test
    void negativosYMixtos() {
        // Caso 1: media = (-5 + 0 + 5)/3 = 0.0 -> > 0.0 => [5]
        assertArrayEquals(new int[]{5},
                ElementosSobreMedia.filtrar(new int[]{-5, 0, 5}));

        // Caso 2: media = (-1 + -2 + -3)/3 = -2.0 -> > -2.0 => [-1]
        assertArrayEquals(new int[]{-1},
                ElementosSobreMedia.filtrar(new int[]{-1, -2, -3}));
    }

    @Test
    void mantieneOrdenYNoModificaOriginal() {
        int[] entrada = {10, 1, 10, 2, 10};
        int[] copia = entrada.clone();

        // media = (10+1+10+2+10)/5 = 6.6 -> > 6.6 => [10, 10, 10]
        int[] res = ElementosSobreMedia.filtrar(entrada);
        assertArrayEquals(new int[]{10, 10, 10}, res, "Debe mantener el orden relativo");

        // Verifica que el array original no se modificó
        assertArrayEquals(copia, entrada, "El método no debe modificar el array de entrada");
    }

    @Test
    void grandesValores_SinPerderPrecisionEnLaMedia() {
        // Si se suma en int, esto desbordaría. Con long no hay problema.
        // media = (1_000_000_000 + 1_000_000_000 + 1) / 3 = 666_666_667.0
        // > media => [1_000_000_000, 1_000_000_000]
        int[] res = ElementosSobreMedia.filtrar(new int[]{1_000_000_000, 1_000_000_000, 1});
        assertArrayEquals(new int[]{1_000_000_000, 1_000_000_000}, res);
    }

    @Test
    void casoLimite_UnSoloElemento() {
        // media = valor único -> no hay estrictamente mayores
        int[] res = ElementosSobreMedia.filtrar(new int[]{7});
        assertArrayEquals(new int[]{}, res);
    }
}