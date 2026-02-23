package com.docencia;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Ejercicio13Test {
  static Stream<Arguments> casos() {
    return Stream.of(
      Arguments.of(new int[]{1,2,3}, 2, 1),
      Arguments.of(new int[]{1,2,3}, 4, -1),
      Arguments.of(new int[]{}, 1, -1),
      Arguments.of(new int[]{5,5,5}, 5, 0),
      Arguments.of(new int[]{9,8,7}, 7, 2)
    );
  }

  @ParameterizedTest @MethodSource("casos")
  void prueba(int[] a, int x, int esperado) {
    assertEquals(esperado, com.docencia.recursividad.Ejercicio13.buscarLineal(a,x));
    assertEquals(esperado, com.docencia.logica.Ejercicio13.buscarLineal(a,x));
  }
}
