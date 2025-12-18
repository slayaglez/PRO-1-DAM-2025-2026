package com.example;

public class Maximo {
    public static void main(String[] args) {
        int[] numeros = {4, 7, 5, 9, 24, 8, 31, 3, 110, 66};
        int maximo=0;
        for(int numero : numeros) {
            if(maximo<numero) {
                maximo=numero;
            }
        }
        System.out.println(maximo + " es el mayor");
    }
}   
