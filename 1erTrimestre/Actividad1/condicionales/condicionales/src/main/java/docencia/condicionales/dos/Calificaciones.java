package docencia.condicionales.dos;

import java.util.Scanner; 

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 26 sept 2025
 * @class Un programa que devuelve un mensaje en base a la calificación
 * 
 */
public class Calificaciones {

    public static void main(String[] args) {
        // Pido la calificación
        System.out.println("Introduzca su calificación (A, B, C o D): ");
        Scanner sc = new Scanner(System.in);
        // Lo convierto a mayúscula y quito espacios
        String nota = sc.nextLine().toUpperCase().trim();
        
        // Imprimo el resultado en base a la calificación
        switch (nota) {
            case "A":
                System.out.println("Matrícula!");
                break;
        
            case "B":
                System.out.println("Bien hecho");
                break;

            case "C":
                System.out.println("Aprobado");
                break;

            case "D":
                System.out.println("Suspendido");
                break;
            default:
                System.out.println("Nota inválida");
                break;
        }
        // Cierro el scanner
        sc.close();
    }

}
