package docencia.condicionales.tres;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 28 sept 2025
 * @class Un programa que devuelve un día de la semana
 * en base al número introducido
 * 
 */
public class ConversorDias {
    public static void main(String[] args) {
        // Abro Scanner
        Scanner sc = new Scanner(System.in);
        // Pido el número por consola
        System.out.println("Introduzca un número para saber el día: ");
        int numero = sc.nextInt();
        // Abro un array con todas las posibles respuestas


        // CAMBIAR ARRAY POR SWITCH



        String dias[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        // Si no está entre 0 y 7 error
        if(numero <0 || numero >7){ 
            System.out.println("Introduzca un número del 0 al 7");
        // Si es 0 es domingo
        } else if(numero==0){ 
            System.out.println("Día: "+dias[6]);
        // Cualquier otro caso imprimo la posición del número en el array -1 
        } else {
            System.out.println("Día: "+ dias[numero-1]);
        }
        // Cierro el scanner
        sc.close();
        
    }
}
