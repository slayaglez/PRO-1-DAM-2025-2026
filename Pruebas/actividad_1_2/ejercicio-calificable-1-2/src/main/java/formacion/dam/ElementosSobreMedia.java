package formacion.dam;
/**
 * @brief Un programa que hace una media de los números de un array
 * y en otro array mete los números que sean superiores a la media. 
 * @author Sebastián Laya González (slayaglez)
 * @date 17 Oct 2025
 */

import java.util.Arrays;


public final class ElementosSobreMedia {
    private ElementosSobreMedia() {}
    
    public static int[] filtrar(int[] datos) {

        int media=0;
        // Hallo la media
        for (int i = 0; i < datos.length; i++) {
            media += datos[i];
        }
        media = media/datos.length;
        int tamanio=0;

        // Creo un array auxiliar donde almacenaré solo
        // los valores mayores a la media
        int[] mayoresMedia = new int[datos.length];
        for (int i=0; i<datos.length; i++) {
            int numero = datos[i];
            if(numero > media){
                tamanio++;
                mayoresMedia[i] = datos[i];
            }
            
        }
        // Hago el array solucion con el tamaño definitivo y meto todas
        // las posiciones que no sean 0 del array auxiliar.
        int[] solucion = new int[tamanio];
        int contador=0;
        for (int i=0; i<mayoresMedia.length; i++) {
            int numero = mayoresMedia[i];
            if(numero!=0){
                solucion[contador]=numero;
                contador++;
            }
            
        }
        return solucion;
    }
}
