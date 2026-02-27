/**
 * @author slayaglez
 * @version 1.0.0
 * @brief programa que hace búsqueda binaria con recursividad
 */
package com.docencia.recursividad;

public class Ejercicio19 {
  
  public static int busquedaBinaria(int[] arregloOrdenado, int objetivo) {

    if (arregloOrdenado == null) {
        return -1;
    }

    return busqueda(arregloOrdenado, objetivo, 0, arregloOrdenado.length-1);
  }

  public static int busqueda(int[] arreglo, int objetivo, int inicio, int fin){

    if (inicio > fin) {
        return -1;
    }

    int indice = (inicio + fin) / 2;

    if (arreglo[indice] == objetivo) {
        return indice;
    }
    if (arreglo[indice] > objetivo) {
        return busqueda(arreglo, objetivo, inicio, indice-1);
    }
    if (arreglo[indice] < objetivo) {
        return busqueda(arreglo, objetivo, indice+1, fin);
    }

    return -1;
  }
}
