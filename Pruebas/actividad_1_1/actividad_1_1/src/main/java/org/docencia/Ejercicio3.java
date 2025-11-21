package org.docencia;
import java.util.Scanner;
/**
 * 
 * @author slayaglez
 * @date 3 Oct 2025
 * @class Una calculadora de areas de circulos, cuadrados y triangulos. Introduce 
 * una opcion de estas y hace el calculo matematico correspondiente. Funciona perfectamente
 * con decimales. Las areas se calculan de la siguiente forma, la del circulo 
 * es 3.14*(radio)^2, la del cuadrado es lado^2 y la del triangulo es (altura*base)/2.
 */

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige una figura para calcular el área maestro: \n1. Círculo\n2. Cuadrado\n3. Triángulo\n");
        String eleccion = sc.nextLine().trim().toLowerCase();

        switch (eleccion) {
            case "1", "circulo":
                System.out.println("Introduzca el radio del círculo: ");
                float radioCirculo = sc.nextFloat();
                System.out.println("El área del círculo es: "+3.14*(radioCirculo*radioCirculo)+" maestro");
                break;
            case "2", "cuadrado":
                System.out.println("Introduzca el lado del cuadrado: ");
                float ladoCuadrado = sc.nextFloat();
                System.out.println("El área del círculo es: "+ladoCuadrado*ladoCuadrado+" maestro");
                break;
            case "3", "triangulo":
                System.out.println("Introduzca la base del triángulo: ");
                float baseTriangulo = sc.nextFloat();
                System.out.println("Introduce la altura del triángulo: ");
                float alturaTriangulo = sc.nextFloat();
                System.out.println("El área del triángulo es: "+(baseTriangulo*alturaTriangulo)/2+" maestro");
                break;
            default :
                System.out.println("Elección inválida maestro");
                break;
        }
        sc.close();
    }
}
