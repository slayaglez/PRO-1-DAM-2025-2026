package org.docencia;
import java.util.Scanner;
/**
 * 
 * @author Sebastian Laya González (slayaglez)
 * @date 3 Oct 2025
 * @class Un programa que pregunta tus datos por consola y los devuelve de 
 * forma ordenada en un mensaje conjunto.
 * 
 */

public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca su nombre por favor: ");
        String nombre = sc.nextLine();

        System.out.println("Ahora introduzca su edad por favor: ");
        String edad = sc.nextLine();

        System.out.println("Por último su residencia por favor: ");
        String residencia = sc.nextLine();

        System.out.println("Hola, "+nombre+", tienes "+edad+" años y vives en "+residencia+".");
        
        sc.close();
    }
}