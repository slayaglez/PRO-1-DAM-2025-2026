package com.docencia.programacion;

public class Ejercicio40 {
    private final char[][] board;

    /**
     * Constructor de la matriz, asigna el valor ' ' a cada casilla
     */
    public Ejercicio40() {
        board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]= ' ';
            }
        }
        
    }

    /**
     * Funcion que escribe el valor de player en la casilla pasada
     * @param row fila que se quiera escribir
     * @param col columna que se quiera escribir
     * @param player caracter que se quiera escribir 'X' o 'O'
     * @return si se pudo escribir o no (true/false)
     */
    public boolean placeMark(int row, int col, char player) {
        
        if(board[row][col] == ' ' && (player == 'X' || player == 'O')){
            board[row][col] = player;
            return true;
        }
        return false;
        
    }

    public char checkWinner() {
        
        /**
         * ANÁLISIS
         * Hay 8 casos de victoria
         * 
         * Suponiendo que:
         *  1 | 2 | 3
         * -----------
         *  4 | 5 | 6
         * -----------
         *  7 | 8 | 9
         * 
         * Combinaciones ganadoras serían
         * 123, 456, 789, 147, 258, 369, 159 y 357
         * 
         * Traducido al array sería:
         * b[0][0] b[0][1] b[0][2] = 123
         * b[1][0] b[1][1] b[1][2] = 456
         * b[2][0] b[2][1] b[2][2] = 789
         * b[0][0] b[1][0] b[2][0] = 147
         * b[0][1] b[1][1] b[2][1] = 258
         * b[0][2] b[1][2] b[2][2] = 369
         * 
         * Casos especiales (diagonal)
         * b[0][0] b[1][1] b[2][2] = 159
         * b[0][2] b[1][1] b[2][0] = 357
         * 
         * Si en estas casillas hay una misma marca gana dicha marca
         * 
         * Identifico el patrón, si la misma fila b[X][] o la misma columna b[][X] tiene marca, gana dicha marca
         * Bucle for que recorra la matriz y un if que compare b[X][] y b[][X].
         */

        int ganador=0;
        // Esto ubica un elemento X
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[0][j]== 'X') { //123
                    ganador++;
                }
                if (board[1][j]== 'X') { //456
                    ganador++;
                }
                if (board[2][j]== 'X') { //789
                    ganador++;
                }
            }
        }
        if (ganador == 3){
            return 'X';
        }
        return ' ';
    }
}
