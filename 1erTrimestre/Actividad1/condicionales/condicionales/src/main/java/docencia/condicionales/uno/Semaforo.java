package docencia.condicionales.uno;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 24 sept 2025
 * @class En base al color del semáforo se te mostrará un mensaje
 * sobre lo que debes hacer
 * 
 */
public class Semaforo {
    public static void main(String[] args) {
        // Inicio el Scanner
        Scanner sc = new Scanner(System.in);

        // Pido el color del semáforo
        System.out.print("Ingresa el color del semáforo: ");
        String color = sc.nextLine().toLowerCase().trim();

        // Hago las comparaciones
        // Uso la funcion ".equals()" en vez de "=="" porque son Strings
        if (color.equals("rojo")) {
            System.out.println("¡Alto! Ni se te ocurra moverte");
        } else if (color.equals("amarillo")) {
            System.out.println("Prepárate... ¡pero no corras!");
        } else if (color.equals("verde")) {
            System.out.println("¡Avanza como un rayo!");
        } else {
            System.out.println("Ese color no existe en un semáforo... ¿arcoíris?");
        }

        // cierro el Scanner
        sc.close();
    }
}
