package docencia.condicionales.tres;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 28 sept 2025
 * @class Un programa que devuelve un día de la semana
 * en base al número introducido
 * 
 */
public class ConversorDias {
    public static void main(String[] args) {
        // Abro Scanner
        Scanner sc = new Scanner(System.in);
        // Pido el número por consola
        System.out.println("Introduzca un número para saber el día: ");
        int numero = sc.nextInt();
        // Imprimo el día correspondiente en base al número
        switch (numero) {
            case 1: System.out.println("Lunes"); break;
            case 2: System.out.println("Martes"); break;
            case 3: System.out.println("Miércoles"); break;
            case 4: System.out.println("Jueves"); break;
            case 5: System.out.println("Viernes"); break;
            case 6: System.out.println("Sábado"); break;
            case 7: case 0: System.out.println("Domingo"); break;
            default:  System.out.println("Valor inválido"); break;
        
        }
        // Cierro el scanner
        sc.close();
        
    }
}
