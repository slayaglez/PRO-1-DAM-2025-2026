package formacion.dam;
/**
 * @brief Un programa que invierte un array sin crear otro del mismo tamaño
 * @author Sebastián Laya González (slayaglez)
 * @date 17 Oct 2025
 */


public final class InvertirInPlace {
    private InvertirInPlace() {}
    public static int[] invertir(int[] datos) {
        int tamanio = datos.length;
        int[]solucion = new int [tamanio];

        for (int i = 0; i < solucion.length; i++) {
            solucion[i] = datos[tamanio-1-i];
        }
        
        return solucion;
    }
}
