package docencia.condicionales.tres;
import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 28 sept 2025
 * @class Un programa que devuelve un canal
 * en base al número introducido
 * 
 */
public class ControlTV {
    public static void main(String[] args) {
        //abro scanner
        Scanner sc = new Scanner(System.in);
        //pido canal (numero)
        System.out.println("Introduce canal: ");
        int canal = sc.nextInt();
        //en base al numero imprimo canal
        switch (canal) {
            case 1: System.out.println("Noticias"); break;
            case 2: System.out.println("Deportes"); break;
            case 3: case 4: System.out.println("Canal no configurado"); break;
            case 5: System.out.println("Documentales"); break;
            case 6: case 7: case 8: System.out.println("Canal no configurado"); break;
            case 9: System.out.println("Sálvame Deluxe"); break;
            case 10: System.out.println("Dibujos"); break;
            default: System.out.println("Incorrecto"); break;
        }
        //cierro scanner
        sc.close();
    }
}
