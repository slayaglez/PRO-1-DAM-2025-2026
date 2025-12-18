package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Un programa que devuelve si puedes subir a una montaña rusa 
 * en base a tu edad y altura.
 * 
 */
public class DetectorEdad {
    public static void main(String[] args) {
        // Pido la edad como int
        System.out.println("Introduzca su edad: ");
        Scanner sc = new Scanner(System.in);
        int edad = sc.nextInt();

        // Pido la altura como float
        System.out.println("Introduzca su altura: ");
        float altura = sc.nextFloat();

        // Hago un if y devuelvo el resultado
        if(edad >= 12 && altura >= 1.40){
            System.out.println("Puedes subir a la montaña rusa");
        } else {
            System.out.println("No puedes subir, lo siento");
        }

        // Cierro Scanner    
        sc.close();
        return;
    }
}
