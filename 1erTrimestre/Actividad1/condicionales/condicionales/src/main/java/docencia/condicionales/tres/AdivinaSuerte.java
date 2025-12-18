package docencia.condicionales.tres;

import java.util.Scanner;
import java.util.Random;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Un programa que te llama suertudo si introduces
 * un numero múltiplo de uno aleatorio que genera.
 * 
 */
public class AdivinaSuerte {
    public static void main(String[] args) {
        // Abro scanner
        Scanner sc = new Scanner(System.in);

        // Genero un número aleatorio del 2 al 7
        Random ran = new Random();
        int numero = ran.nextInt(2,7);

        // Declaro la condicion que se debe cumplir para romper el bucle
        int continuar=1;
        // Bucle hasta que se adivine
        while(continuar!=0){
            System.out.println("Prueba suerte: ");
            int respuesta = sc.nextInt();

            // Si acierta se acaba el bucle
            if(respuesta%numero==0) {
                System.out.println("¡¡Eres un suertudo!!");
                continuar=0;
            // Si se queda a un número le doy ua pista
            } else if (respuesta%numero==1 || respuesta%numero==(numero-1)) {
                System.out.println("¡¡Qué cerquita!!");
            // Lo desanimo si está lejos
            } else {
                System.out.println("Frío frío");
            }
        }
        // Cierro el scanner
        sc.close();
        

    }
}
