package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Un programa que responde distinto en base a la nota que introduzca el usuario
 * 
 */
public class ClasificarNotas {
    public static void main(String[] args) {
        
        // Abro scanner
        Scanner sc = new Scanner(System.in);

        // Pido la nota
        System.out.println("Introduzca su nota: ");
        float nota = sc.nextFloat();

        // Hago un array con los mensajes
        String[] mensNota = {"Suspenso", "Aprobado", "Notable", "Sobresaliente"};

        // Segun el rango de la nota imprimo cierta posición del array
        if(nota < 5){
            System.out.println(mensNota[0]);
        } else if (nota >= 5 && nota < 7){
            System.out.println(mensNota[1]);
        } else if (nota >= 7 && nota < 9){
            System.out.println(mensNota[2]);
        } else if (nota >= 9 && nota <= 10){
            System.out.println(mensNota[3]);
        } else {
            System.out.println("Introduzca un número válido:");
        }
        
        // Cierro scanner
        sc.close();
    }
}
