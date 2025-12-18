package docencia.condicionales.tres;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Una calculadora de propina que devuelve tanto la 
 * propina como el total
 * 
 */

public class CalculaPropinas {
    public static void main(String[] args) {
        
        // Abro scanner y declaro variables
        Scanner sc = new Scanner(System.in);
        float cuenta=0, propina=0, porcentaje=0;

        // Pido la cuenta y el porcentaje de propina
        System.out.println("Introduzca el precio de la cuenta: ");
        cuenta = sc.nextFloat();
        System.out.println("Introduzca el porcentaje de propina: ");
        porcentaje = sc.nextFloat();

        // Hago el cálculo e imprimo el resultado
        propina = cuenta*(porcentaje/100);
        System.out.println("Su total sería "+(cuenta+propina)+" euros, con "+propina+" euros de propina");
    
        // Cierro el scanner
        sc.close();
    }
}
