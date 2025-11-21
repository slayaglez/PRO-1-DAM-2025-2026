package formacion.dam;
/**
 * @author slayaglez
 * @brief Un programa que lee un array y suma sus números positivos
 * y los cuenta devolviendo un array con la suma y el conteo.
 * @date 17 Oct 2025
 */

public final class SumaYConteoPositivos {
    public record Resultado(int suma, int conteo) {}
    private SumaYConteoPositivos() {}
    
    public static int[] calcular(int[] datos) {
        int conteo = 0, suma = 0;
        for (int i = 0; i < datos.length; i++) {
            int numero = datos[i];
            if (numero > 0) {
                conteo++;
                suma+=numero;
            }
        }
        int[] solucion = new int[2];
        solucion[0]=suma;
        solucion[1]=conteo;

        return solucion;
    }
}
