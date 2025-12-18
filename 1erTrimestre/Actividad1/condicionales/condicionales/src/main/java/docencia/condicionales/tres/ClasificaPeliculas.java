package docencia.condicionales.tres;
import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 28 sept 2025
 * @class Un programa que devuelve una explicación
 * en base a la guía introducida para películas
 * 
 */
public class ClasificaPeliculas {
    public static void main(String[] args) {
        //abro scanner
        Scanner sc = new Scanner(System.in);
        //pido guia, quito espacios, todo mayúscula
        System.out.println("Introduzca clasificación (G, PG, R): ");
        String calificacion = sc.nextLine().trim().toUpperCase();
        //imprimo el mensaje en base a la guia
        switch (calificacion) {
            case "G": System.out.println("Todo público"); break;
            case "PG": System.out.println("Guía paternal sugerida"); break;
            case "R": System.out.println("Restringida"); break;
            default: System.out.println("Clasificación desconocida"); break;
        }
        //cierro scanner
        sc.close();
    }
}
