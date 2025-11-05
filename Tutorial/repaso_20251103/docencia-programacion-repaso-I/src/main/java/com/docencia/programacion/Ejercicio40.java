package com.docencia.programacion;

public class Ejercicio40 {
    private final char[][] board;

    /**
     * 
     */
    public Ejercicio40() {
        board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j]= ' ';
            }
        }
        
    }

    public boolean placeMark(int row, int col, char player) {
        
        if(board[row][col] == ' ' && (player == 'X' || player == 'O')){
            board[row][col] = player;
            return true;
        }
        return false;
        
    }

    public char checkWinner() {
        // TODO implementar
        return ' ';
    }
}
