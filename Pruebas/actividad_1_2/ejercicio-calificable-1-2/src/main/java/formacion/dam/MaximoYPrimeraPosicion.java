package formacion.dam;
/**
 * @brief Programa que devuelve un array con el número más
 * grande del array y su posición.
 * @author Sebastián Laya González (slayaglez)
 * @date 17 Oct 2025
 */

public final class MaximoYPrimeraPosicion {
    
    private MaximoYPrimeraPosicion() {}
    public static int[] calcular(int[] datos) {
        int maximo = datos[0];
        int indiceMax = 0;
        for (int i = 1; i < datos.length; i++) {
            int numero = datos[i];
            if(maximo < numero){
                maximo = numero;
                indiceMax = i;
            }
        }
        int[] solucion = new int[2];
        solucion[0] = maximo;
        solucion[1] = indiceMax;

        return solucion;
    }
}
