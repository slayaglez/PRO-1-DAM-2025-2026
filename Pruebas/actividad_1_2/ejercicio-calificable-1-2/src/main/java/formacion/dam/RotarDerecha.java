package formacion.dam;
/**
 * @author slayaglez
 * @brief Un programa que rota el array dos posiciones hacia la derecha
 * @date 17 Oct 2025
 */

public final class RotarDerecha {
    private RotarDerecha() {}
    public static int[] rotar(int[] datos, int k) {
        int tamanio = datos.length;
        int [] solucion = new int [tamanio];
        // Recorro el bucle
        for (int i = 0; i < tamanio; i++) {
            // Indice vale i + 2
            int indice = i+k;
            // Si indice se sale del array
            if(indice < tamanio){
                // si indice aún no se sale del array
                solucion[indice]=datos[i];
            } else {
                // cuando indice se salga del array le resto el tamaño para 
                // que vuelva a empezar
                solucion[indice-tamanio] = datos[i];
            }
        }

        return solucion;
    }
}
