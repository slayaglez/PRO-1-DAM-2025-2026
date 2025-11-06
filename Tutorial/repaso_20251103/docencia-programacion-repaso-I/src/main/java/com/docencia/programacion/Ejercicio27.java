package com.docencia.programacion;
/**
 * Clase que opera en 2D con matrices sumando filas y columnas
 * @author slayaglez
 * @version 1.0.0
 */
public class Ejercicio27 {

    /**
     * Funcion que suma todos los elementos de la fila de una matriz
     * @param matrix la matriz
     * @param rowIndex el indice de la fila que se quiera sumar
     * @return un entero con el valor de la suma
     */
    public static int sumRow(int[][] matrix, int rowIndex) {
        if(matrix == null || rowIndex < 0 || rowIndex > matrix.length) {
            return 0;
        }
        int resultado=matrix[rowIndex][0];
        for (int i = 1; i < matrix[rowIndex].length; i++) {
            resultado += matrix[rowIndex][i];
        }
        return resultado;
    }

    /**
     * Funcion que suma todos loes elementos de la columna de una matriz
     * @param matrix la matriz
     * @param colIndex el indice de la columna que se quiera sumar
     * @return un entero con el valor de la su
     */
    public static int sumColumn(int[][] matrix, int colIndex) {
        if(matrix == null || colIndex < 0 || colIndex > matrix.length) {
            return 0;
        }
        int resultado=matrix[0][colIndex];
        for (int i = 1; i < matrix.length; i++) {
            resultado += matrix[i][colIndex];
        }
        return resultado;
    }
}
