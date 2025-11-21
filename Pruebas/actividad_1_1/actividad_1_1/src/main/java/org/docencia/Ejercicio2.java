package org.docencia;
import java.util.Scanner;
/**
 * 
 * @author slayaglez
 * @date 3 Oct 2025
 * @class Al introducir un numero se compara para que no este fuera de un rango, luego 
 * se crea un array con los dias de la semana y a el numero dado se le resta uno  
 * para que equivalga a la posicion del array e imprima el dia de su interior.
 * 
 */

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduzca un número del 1 al 7: ");
        int numero = sc.nextInt();

        if(numero <= 0 || numero >= 8){
            System.out.println("¡Ese día no existe, viajero del tiempo!");
        } else {
            String[] semanaDias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};    
            System.out.println("El día es "+semanaDias[numero-1]+", sigue así viajero.");
        }
        sc.close();
    }
}