package docencia.condicionales.tres;
import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 28 sept 2025
 * @class Un programa que devuelve un mes
 * en base al número introducido
 * 
 */
public class MesesAnio {
    public static void main(String[] args) {
        //abro scanner
        Scanner sc = new Scanner(System.in);
        //pido numero
        System.out.println("Inserte número: ");
        int numero = sc.nextInt();
        //devuelvo mes numero x
        switch (numero) {
            case 1: System.out.println("Enero"); break;
            case 2: System.out.println("Febrero"); break;
            case 3: System.out.println("Marzo"); break;
            case 4: System.out.println("Abril"); break;
            case 5: System.out.println("Mayo"); break;
            case 6: System.out.println("Junio"); break;
            case 7: System.out.println("Julio"); break;
            case 8: System.out.println("Agosto"); break;
            case 9: System.out.println("Septiembre"); break;
            case 10: System.out.println("Octubre"); break;
            case 11: System.out.println("Noviembre"); break;
            case 12: System.out.println("Diciembre"); break;
        
            default: System.out.println("Incorrecto");
                break;
        }
        //devuelvo estación (emisferio norte)
        switch (numero) {
            case 1:case 2: case 3: System.out.println(", invierno"); break;
            case 4:case 5: case 6: System.out.println(", primavera"); break;
            case 7:case 8: case 9: System.out.println(", verano"); break;
            case 10:case 11: case 12: System.out.println(", otoño"); break;
        }
        //cierro scanner
        sc.close();
    }
}
