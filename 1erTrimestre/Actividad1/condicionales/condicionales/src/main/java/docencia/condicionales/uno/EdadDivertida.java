package docencia.condicionales.uno;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 24 sept 2025
 * @class Una serie de comentarios muy alegres respecto a tu edad
 * 
 */
public class EdadDivertida {
    public static void main(String[] args) {

        // Inicio la clase Scanner
        Scanner sc = new Scanner(System.in);
        Scanner entrada = new Scanner(System.in);

        // Hago un interruptor para saber cuando parar el programa
        int seguir = 1;
        // Bucle para que se repita el programa hasta que el usuario lo pare
        while(seguir == 1) {
            // Pausa estética
            System.out.println("Pulse Enter para continuar");
            String enterKey = sc.nextLine();

            // Pido la edad del usuario
            System.out.print("Ingresa tu edad: ");
            int edad = sc.nextInt();

            // Hago las comparaciones
            if (edad < 5 && edad > 0) {
                System.out.println("Eres un bebé genio con teclado.");
            } else if (edad < 13 && edad >= 5) {
                System.out.println("¡Cuidado! Podrías estar en la fase gamer pro.");
            } else if (edad < 20 && edad >= 13) {
                System.out.println("Adolescente detectado: nivel experto en memes.");
            } else if (edad < 60 && edad >= 20) {
                System.out.println("Adulto en misión: sobrevivir al café diario");
            } else if (edad >= 60) {
                System.out.println("¡Leyenda viva! Sabes más que Google.");
            } else {
                System.out.println("Introduce una edad válida crack.");
            }
        
            // ¿Quiere el usuario seguir?
            System.out.println("¿Seguir? 1/0");
            
            seguir = entrada.nextInt();

        
        }
    // Cierro la clase
    entrada.close();
    sc.close();

    }
}
