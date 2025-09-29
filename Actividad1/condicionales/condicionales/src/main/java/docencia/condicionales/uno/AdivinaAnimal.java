package docencia.condicionales.uno;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 24 sept 2025
 * @class Una serie de preguntas que en base a las respuestas
 * adivina si un animal es de agua o de aire. O un perro travieso.
 * 
 */
public class AdivinaAnimal {
    
    public static void main(String[] args) {
        // Inicio el Scanner
        Scanner sc = new Scanner(System.in);

        // Pregunto si tiene alas
        System.out.print("¿Tiene alas? (sí/no): ");
        String alas = sc.nextLine();

        // Pregunto si es de agua
        System.out.print("¿Vive en el agua? (sí/no): ");
        String agua = sc.nextLine();

        // Hago comparaciones
        if (alas.equals("sí")) {
            System.out.println("¡Podría ser un pájaro… ¡o un dragón!");
        } else if (agua.equals("sí")) {
            System.out.println("Seguro que eres un pez, o una sirena secreta.");
        } else {
            System.out.println("Mmm... tal vez un perro travieso.");
        }

        // Cierro el Scanner
        sc.close();
    }
}
