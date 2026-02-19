package com.docencia;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Ejercicio11Test {
  static Stream<Arguments> casos() {
    return Stream.of(
      Arguments.of(new int[]{}, 0L),
      Arguments.of(new int[]{1}, 1L),
      Arguments.of(new int[]{1,2,3}, 6L),
      Arguments.of(new int[]{-1,1}, 0L),
      Arguments.of(new int[]{1000,-500,200}, 700L)
    );
  }

  @ParameterizedTest @MethodSource("casos")
  void prueba(int[] a, long esperado) {
    assertEquals(esperado, com.docencia.recursividad.Ejercicio11.sumaArreglo(a));
    assertEquals(esperado, com.docencia.logica.Ejercicio11.sumaArreglo(a));
  }
}
