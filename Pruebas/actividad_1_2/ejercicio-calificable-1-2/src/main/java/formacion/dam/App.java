package formacion.dam;

import java.util.Arrays;

public class App {
 
   public static void main(String[] args) {

        // Ej1A: Suma y conteo de positivos -> record Resultado(suma, conteo)
        int r1[] = SumaYConteoPositivos.calcular(new int[]{1, -2, 3, 0, 5});
        check(r1[0] == 9 && r1[1] == 3, "Ej1A");

        // Ej3A: Elementos sobre la media -> int[]
        var r3 = ElementosSobreMedia.filtrar(new int[]{2, 4, 6, 8});
        check(Arrays.equals(r3, new int[]{6, 8}), "Ej3A");

        // Ej4A: Invertir in place -> void (modifica el array recibido)
        //int[] a4 = {1, 2, 3, 4, 5};
        //InvertirInPlace.invertir(a4);
        //check(Arrays.equals(a4, new int[]{5, 4, 3, 2, 1}), "Ej4A");

        // Ej5A: Rotación a la derecha -> int[]
        var r5 = RotarDerecha.rotar(new int[]{1, 2, 3, 4, 5}, 2);
        check(Arrays.equals(r5, new int[]{4, 5, 1, 2, 3}), "Ej5A");

        // Ej2B: Máximo y primera posición -> record Resultado(maximo, indice)
        int[] r7 = MaximoYPrimeraPosicion.calcular(new int[]{-3, -1, -1, -2});
        check( r7[0]== -1 && r7[1] == 1, "Ej2B");

        System.out.println("✅ Verificación básica: todo OK.");
    }

    private static void check(boolean cond, String nombre) {
        if (!cond) throw new AssertionError("Fallo en " + nombre);
    }
}
