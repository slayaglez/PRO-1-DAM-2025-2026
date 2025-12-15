package docencia.condicionales.uno;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 24 sept 2025
 * @class Una máquina que da una respuesta en base al número que 
 * des en un rango del 1 al 3
 */
public class MaquinaSuerte {
    public static void main(String[] args) {
        // Inicio el Scanner
        Scanner sc = new Scanner(System.in);

        // Pido el número
        System.out.print("Ingresa un número del 1 al 3: ");
        int numero = sc.nextInt();

        // Hago las comparaciones
        if (numero==1) {
            System.out.println("Hoy encontrarás una galleta… ¡y será deliciosa!");
        } else if (numero==2) {
            System.out.println("Un pato te mirará raro en la calle.");
        } else if (numero==3) {
            System.out.println("Tendrás suerte… si compartes tu comida.");
        } else {
            System.out.println("Número misterioso: ¡prepárate para lo inesperado!");
        }

        // Cierro el Scanner
        sc.close();
    }
}
