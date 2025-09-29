package docencia.condicionales.tres;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Un programa que devuelve si un número es par o no
 * 
 */
public class ParImpar {
    public static void main(String[] args) {
        // Abro el scanner
        Scanner sc = new Scanner(System.in);

        // Pido el numero al usuario
        System.out.println("Introduzca un número: ");
        int numero = sc.nextInt();

        // Si es divisible por 2 respondo par
        if(numero%2==0){
            System.out.println("Su numero es par");
        } else {
            System.out.println("Su número es impar");
        }
        //cierro scanner
        sc.close();
    }
}
