package com.docencia.clases;
/**
 * @author slayaglez
 * @version 1.0.0
 * Clase que realiza la transformacion de valores enteros
 */
public final class IntegerUtils {
    private IntegerUtils() {}

    /**
     * Funcion que transforma un valor decimal a binario
     * @param x valor entero de la entrada
     * @return String con el valor binario
     */
    public static String bin(int x) {
        return Integer.toBinaryString(x);
    }


    public static int popcount(int x) {
        
        return 0;
    }

    /**
     * Funcion que compara dos enteros con signos 
     * @param a Valor de entrada a 
     * @param b Valor de entrada b
     * @return 0 si a == b, 1 si a < b, -1 si a > b
     */
    public static int comparaSinSigno(int a, int b) { 
        return Integer.compareUnsigned(a, b);
    }

    public static void main(String[] args) {
        String resultado = bin(6);
        System.out.println("Valor binario obtenido: "+resultado);

        System.out.println(comparaSinSigno(10, 20));
    }
}
