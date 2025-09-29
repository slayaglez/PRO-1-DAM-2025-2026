package docencia.condicionales.tres;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Un programa que genera un numero aleatorio que debe 
 * adivinar el usuario
 * 
 */
public class NumeroSecreto {
    public static void main(String[] args) {

        // Abro Scanner
        Scanner sc = new Scanner(System.in);
        // Interruptor
        int continuar = 1;
        // Hago un número aleatorio para que haya rejugabilidad
            Random ran = new Random();
            int numeroSecreto = ran.nextInt(20);

        // Bucle hasta que el usuario adivine el número
        while (continuar != 0) {

            // Pido el número al usuario
            System.out.println("Introduzca el número en el que estoy pensando: (1 - 20)");
            int intento = sc.nextInt();

            // Si lo adivina se acaba el bucle, si no, se repite
            if (intento == numeroSecreto) {
                System.out.println("¡Lo adivinaste!");
                continuar = 0;
            } else if (intento < numeroSecreto) {
                System.out.println("¡Demasiado abajo!");
            } else if (intento > numeroSecreto) {
                System.out.println("¡Demasiado arriba!");
            } else {
                System.out.println("Introduzca un valor adecuado");
            }
        }
        // Cierro Scanner
        sc.close();

    }
}
