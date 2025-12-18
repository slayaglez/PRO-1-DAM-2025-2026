package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String semanaDias[] = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};

        System.out.println("Introduce un número: ");
        int numero = sc.nextInt();

        System.out.println(semanaDias[numero-1]+"\n");

        for(int i=0;i<semanaDias.length;i++){
            System.out.println(semanaDias[i]);
        }

        for(String dia : semanaDias) {
            System.out.println(dia);
        }
    }
}