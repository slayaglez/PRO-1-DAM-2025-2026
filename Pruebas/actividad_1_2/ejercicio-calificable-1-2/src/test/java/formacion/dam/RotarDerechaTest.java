package formacion.dam;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RotarDerechaTest {
  @Test void casos() {
    assertArrayEquals(new int[]{4,5,1,2,3}, RotarDerecha.rotar(new int[]{1,2,3,4,5}, 2));
    assertArrayEquals(new int[]{}, RotarDerecha.rotar(new int[]{}, 3));
    //assertThrows(IllegalArgumentException.class, () -> RotarDerecha.rotar(null, 1));
  }
}