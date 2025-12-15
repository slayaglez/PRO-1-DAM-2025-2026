package org.formacion.array;

import java.util.*;

public class EjerciciosArrays {

    /**
     * Dado un array, devuelve un nuevo array con los elementos en orden inverso.
     * @param array de elementos
     * @return array ordenado
     */
    public static int[] invertir(int[] array) {

        int tamanio = array.length;
        int[] invertido = new int[tamanio];
        for(int i = 0; i < tamanio; i++){
            invertido[i] = array[tamanio-i-1];
        }
        return invertido;
    }

    /**
     * Cuenta cuantos pares completos hay de cada color.
     * @param array de colores de los
     * @return
     */
    public static int  paresCalcetines(String[] colores, String color) {
        int parejas=0;
        for(int i =0; i < colores.length; i++){
            if(colores[i].equals(color)){
                parejas++;
            }
        }
        return parejas/2;
    }


    /**
     * Quita duplicados manteniendo el primer ejemplar.
     * @param playlist
     * @return playlist sin duplicados
     */
    public static String[] sinRepetidos(String[] playlist) {
        String cancion;
        String []play = new String[playlist.length];
        for(int i=0; i < playlist.length; i++) {
            cancion = playlist[i];
            for(int j=0; j < play.length; j++) {
                if(play[j] != null){
                    play[j] = cancion;
                }
            }
        }
        return null;
    }

    /**
     * EJERCICIO DE EXAMEN
     * Rota un array k posiciones a la derecha.
     * @param array
     * @param k posiciones que debe de rotar
     * @return
     */
    public static int[] rotar(int[] array, int k) {
        int[] rotado = new int[array.length];

        for(int i = 0; i < array.length; i++){
            int indice = i+k;
            if (indice >= array.length) {
                rotado [indice-k] = array[indice-array.length];
             } else {
                rotado[i] = array[indice];
             }
        }

        return rotado;
    }

    /**
     * EJERCICIO DE EXAMEN
     * Devuelve un subarray desde índice i hasta j.
     * @param array
     * @param i posicion inicial
     * @param j posicion final
     * @return sub array
     */
    public static int[] rebanada(int[] array, int i, int j) {
        // Mensaje error
        if (i<0) {
            return null;
        } 
        if (j >= array.length) {
            return null;
        }
        if(i>j) {
            return null;
        }

        int[] resultado = new int[j-i];
        for (int k = 0; k < array.length; k++) {

            int indice = i+k;

            if(indice < array.length){
                resultado[k] = array[indice];
            }
         

        }

        return resultado;
    }

    /**
     * Suma solo los numeros pares del array.
     * @param array de numeros
     * @return suma de los numeros pares
     */
    public static int sumaPares(int[] array) {
        return 0;
    }

    /**
     * Intercambia el primer y último elemento.
     * @param array de numeros de entrada
     * @return
     */
    public static int[] swapExtremos(int[] array) {
        int auxiliar = array[0];
        array[0] = array[array.length-1];
        array[array.length-1] = auxiliar;
        return array;
    }

    /**
     * Devuelve los elementos comunes entre dos arrays.
     * @param arrayA
     * @param arrayB
     * @return array con valores comunes
     */
    public static int[] interseccion(int[] arrayA, int[] arrayB) {

        int[] tercerArray = new int[arrayB.length];
        int futuroTamanio=0;
        for(int i=0; i<arrayA.length; i++){
            for(int j=0; j<arrayB.length; j++){
                if(arrayA[i]==arrayB[j]){
                    futuroTamanio++;
                    tercerArray[j]=arrayA[i];
                }
            }
        }

        int [] cuartoArray = new int[futuroTamanio];
        for(int i =0; i<cuartoArray.length; i++){
            cuartoArray[i]=tercerArray[i];
        }
        return cuartoArray;
    }

    /**
     * Elementos que están en un array u otro, pero no en ambos.
     * @param arrayA
     * @param arrayB
     * @return array con la diferencia simetrica
     */
    public static int[] difSim(int[] arrayA, int[] arrayB) {
        
        // Borro las posiciones en las que hayan numeros iguales
        for(int i=0; i<arrayA.length; i++){
            for(int j=0; j<arrayB.length; j++){
                if(arrayA[i]==arrayB[j]){
                    arrayA[i]=0;
                    arrayB[j]=0;
                }
            }
        }
        // Hago un tamaño con las posiciones llenas tanto de A como de B
        int futuroTamanio=0;
        for(int numero : arrayA){
            if(numero != 0){
                futuroTamanio++;
            }
        }
        for(int numero : arrayB){
            if(numero != 0){
                futuroTamanio++;
            }
        }
        // Creo un array con el tamaño de las posiciones llenas
        int [] tercerArray = new int[futuroTamanio];
        // int contador=0;

        // for(int i =0; i<tercerArray.length-1; i++){
        //     for(int numero : arrayA){
        //     if(numero != 0){
        //         tercerArray[contador] = numero;
        //     }
        //     contador++;
        // }
        // for(int numero : arrayB){
        //     if(numero != 0){
        //         tercerArray[contador] = numero;
        //     }
        //     contador++;
        // }
        // }

        
        // return tercerArray;
        for(int i=0; i<tercerArray.length-1; i++){
            
        }
        return null;
    }

    /**
     * Comprueba si un array es palindromo.
     * @param array de entrada
     * @return true/false si es palindrome
     */
    public static boolean esPalindromo(int[] array) {
        for(int i = 0; i < array.length/2; i++) {
            if(array[i]!=array[array.length -1 -i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Busca el indice de un valor. 
     * @param array de entrada 
     * @param objetivo del indice
     * @return posicion en la que se encuentra
     */
    public static int buscar(int[] array, int objetivo) {

        if (objetivo >= array.length || objetivo < 0) {
            return -1;
        }

        return array[objetivo];
    }

    /**
     * Elimina elementos en las posiciones dadas.
     * @param array de entrada
     * @param indices con las posiciones a liminar
     * @return array sin las posiciones dadas
     */
    public static int[] eliminarPorIndices(int[] array, int[] indices) {
        for(int indice : indices){
            array[indice] = 0;
        }

        return array;
    }

    /**
     * Convierte una matriz en un array 1D.
     * @param matriz de entrada
     * @return array con la matriz aplanada
     */
    public static int[] aplanar2D(int[][] matriz) {

        return null;
    }

public static void main(String[] args) {

        System.out.println("Invertir: " + Arrays.toString(EjerciciosArrays.invertir(new int[]{1,2,3,4})));

        System.out.println("Pares de calcetines: " + EjerciciosArrays.paresCalcetines(new String[]{"rojo","azul","rojo","rojo","azul"}, "rojo"));

        System.out.println("Playlist sin repetidos: " + Arrays.toString(EjerciciosArrays.sinRepetidos(new String[]{"A","B","A","C","B"})));

        System.out.println("Rotación del carrusel: " + Arrays.toString(EjerciciosArrays.rotar(new int[]{1,2,3,4,5}, 2)));

        System.out.println("Rebanada de array: " + Arrays.toString(EjerciciosArrays.rebanada(new int[]{0,1,2,3,4}, 1, 4)));

        System.out.println("Suma de pares: " + EjerciciosArrays.sumaPares(new int[]{1,2,3,4,5,6}));

        System.out.println("Congelar extremos: " + Arrays.toString(EjerciciosArrays.swapExtremos(new int[]{10,20,30,40})));

        System.out.println(" Intersección: " + Arrays.toString(EjerciciosArrays.interseccion(new int[]{1,2,3,4}, new int[]{3,4,5})));
 
        System.out.println("Diferencia simétrica: " + Arrays.toString(EjerciciosArrays.difSim(new int[]{1,2,3}, new int[]{3,4,5})));

        System.out.println("Palíndromo: " + EjerciciosArrays.esPalindromo(new int[]{1,2,3,2,1}));

        System.out.println("Índice del tesoro: " + EjerciciosArrays.buscar(new int[]{10,20,30}, 20));

        System.out.println("Eliminación por índices: " + Arrays.toString(EjerciciosArrays.eliminarPorIndices(new int[]{1,2,3,4}, new int[]{1,3})));

    
        System.out.println("Aplanar Matriz: " + Arrays.toString(EjerciciosArrays.aplanar2D(new int[][]{{1,2},{3},{4,5}})));
    }
}
