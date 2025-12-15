package docencia.condicionales.dos;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 26 sept 2025
 * @class Una calculadora que suma, multiplica, resta y divide dos valores dados
 * 
 */
public class Calculadora {

    public static void main(String[] args){
        // Inicio el scanner
        Scanner scannerNumero = new Scanner(System.in);

        // Pido el primer y segundo numero
        System.out.println("Introduzca el primer número:");
        float numero1 =scannerNumero.nextFloat();

        System.out.println("Introduzca el segundo número:");
        float numero2 = scannerNumero.nextFloat();

        // Pido el operador que quiera usar
        Scanner scannerOperador = new Scanner(System.in);
        System.out.println("Introduce la operación a realizar (+, -, *, /)");
        String operacion = scannerOperador.nextLine();

        // Hago un switch con los casos posibles (+, -, *, /) e imprimo el resultado
        switch (operacion) {
            case "+":
                System.out.println("Resultado: " + (numero1+numero2));
                break;
            case "-":
                System.out.println("Resultado: " + (numero1-numero2));
                break;
            case "*":
                System.out.println("Resultado: " + (numero1*numero2));
                break;
            case "/":
                // Si el divisor es 0 imprimo error
                if(numero2==0){
                    System.out.println("No se puede divir por 0");
                    break;
                }
                System.out.println("Resultado: " + (numero1/numero2));
                break;
            default:
                System.out.println("Operación inválida");
                break;
        }

        // Cierro scanner
        scannerNumero.close();
        scannerOperador.close();
    }
}
