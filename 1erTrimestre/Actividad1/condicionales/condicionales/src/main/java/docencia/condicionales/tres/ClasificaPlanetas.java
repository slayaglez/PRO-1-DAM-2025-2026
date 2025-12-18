package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 28 sept 2025
 * @class Un programa que devuelve un planeta y datos del mismo
 * en base al número introducido
 * 
 */
public class ClasificaPlanetas {
    public static void main(String[] args) {
        // Abro scanner
        Scanner sc = new Scanner(System.in);
        // Pido el número
        System.out.println("==Planetario==\nIntroduce un número del 1 al 8: ");
        int numero = sc.nextInt();
        // Imprimo la respuesta
        switch (numero) {
            case 1: System.out.println("Mercurio, el planeta más pequeño"); break;
            case 2: System.out.println("Venus, el de mayor temperatura"); break;
            case 3: System.out.println("Tierra, el único que alberga vida"); break;
            case 4: System.out.println("Marte, conocido como el planeta rojo"); break;
            case 5: System.out.println("Júpiter, el más grande de todos"); break;
            case 6: System.out.println("Saturno, el que cuyos anillos miden varios miles de kilómetros"); break;
            case 7: System.out.println("Urano, el que en su atmósfera pueden llover diamantes"); break;
            case 8: System.out.println("Neptuno, el más lejano de todos"); break;
    
            default: System.out.println("Número incorrecto"); break;
        }
        // Cierro el scanner
        sc.close();
    }
}
