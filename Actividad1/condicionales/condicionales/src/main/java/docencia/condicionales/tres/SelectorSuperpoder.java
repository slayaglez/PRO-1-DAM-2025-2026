package docencia.condicionales.tres;
import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 28 sept 2025
 * @class Un programa que devuelve un poder
 * en base al número introducido
 * 
 */
public class SelectorSuperpoder {
    public static void main(String[] args) {
        //abro scanner
        Scanner sc = new Scanner(System.in);
        //pido numero
        System.out.println("Inserte un número: ");
        int numero = sc.nextInt();
        //imprimo poder en base a numero
        switch(numero){
            case 1: System.out.println("Vuelas");
            case 2: System.out.println("Invisible");
            case 3: System.out.println("Superfuerza");
            default: System.out.println("Valor inválido");
        }
        //cierro scanner
        sc.close();
    }
}
