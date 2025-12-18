package docencia.condicionales.tres;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Un programa que te dice qué hacer en base al color
 * del semáforo
 * 
 */
public class SemaforoSimulador {
    public static void main(String[] args) {
        // Abro scanner
        Scanner sc = new Scanner(System.in);

        // Pido un color de semáforo
        System.out.println("Introduzca un color de semáforo: ");
        String color = sc.nextLine().trim().toLowerCase();

        // En base al color respondo
        if(color.equals("rojo") || color.equals("r")) {
            System.out.println("Detener");
        } else if(color.equals("amarillo") || color.equals("a")){
            System.out.println("Precaución");
        } else if(color.equals("verde") || color.equals("v")) {
            System.out.println("Avanzar");
        } else {
            System.out.println("Eso no es un color de semáforo");
        }
        // Lo de siempre
        sc.close();
    }
}
