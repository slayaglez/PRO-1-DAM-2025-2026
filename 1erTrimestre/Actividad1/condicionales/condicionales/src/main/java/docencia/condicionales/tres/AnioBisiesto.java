package docencia.condicionales.tres;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Una calculadora de años bisiestos
 * 
 */
public class AnioBisiesto {
    public static void main(String[] args) {

        // Abro Scanner
        Scanner sc = new Scanner(System.in);
        // Pido el año
        System.out.println("Introduzca un año: ");
        int anio = sc.nextInt();
        // Calculo si es bisiesto (si es divisible por 4 y no 100 o por 400)
        if(anio%4==0 && anio%100!=0){
            System.out.println("El año es bisiesto");
        } else if(anio%400==0){
            System.out.println("El año es bisiesto ¡y divisible entre 400!");
        } else{
            System.out.println("El año no es bisiesto");
        }
        // Cierro Scanner
        sc.close();
    }
}
