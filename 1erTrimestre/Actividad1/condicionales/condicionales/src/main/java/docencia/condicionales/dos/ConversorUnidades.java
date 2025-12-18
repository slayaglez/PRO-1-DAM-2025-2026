package docencia.condicionales.dos;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 24 sept 2025
 * @class Convierte unidades
 * 
 */

public class ConversorUnidades {
    public static void main(String[] args) {
        // Inicio el scanner
        Scanner sc = new Scanner(System.in);

        // Pregunto que unidad quiere convertir
        System.out.println("Conversor de unidades");
        System.out.println("¿Qué unidad desea convertir?");
        System.out.println("1. Kilómetros a millas");
        System.out.println("2. Millas a kilómetros");
        System.out.println("3. Celsius a Fahrenheit");
        System.out.println("4. Fahrenheit a Celsius");

        // Declaro las variables que voy a usar
        int opcion = sc.nextInt();
        float dato = 0;

        // Hago un switch con todos los cálculos correspondientes por unidad
        switch (opcion) {
            case 1:
                System.out.println("Introduzca los kilómetros: ");
                dato = sc.nextFloat();
                System.out.println("Eso son " + (dato/1.60934) + " millas");
                break;
        
            case 2:
                System.out.println("Introduzca las millas: ");
                dato = sc.nextFloat();
                System.out.println("Eso son " + (dato*1.60934) + " kilómetros");
                break;
            case 3:
                System.out.println("Introduzca los grados Celsius: ");
                dato = sc.nextFloat();
                System.out.println("Eso son " + ((dato * 9 / 5) + 32) + "° Fahrenheit");
                break;
            case 4:
                System.out.println("Introduzca los grados Fahrenheit: ");
                dato = sc.nextFloat();
                System.out.println("Eso son " + ((dato - 32) * 5 / 9) + "° Celsius");
                break;
            default:
                System.out.println("Introduzca una opción del 1 al 4");
                break;
        }
        // Cierro scanner
        sc.close();
    }
}
