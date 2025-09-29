package es.ies.puerto;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 17 sept 2025
 */

public class Main {
    /**
     * Función principal
     * 
     * @param args argumentos de entrada
     */

    public static void main(String[] args) {


        int pagina = 0;
        while (pagina != 8) {
            //Mensaje de petición
            System.out.println("Pulse Enter");
            // Pido una entrada fantasma para un espaciado entre respuesta y menu
            Scanner entradafantasma = new Scanner(System.in);
            String Casper = entradafantasma.nextLine();
            // Presento mi programa
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("   ==========SEBASPEDIA===========");
            System.out.println("   Todos los derechos reservados ©");
            System.out.println("    1. Mi información personal");
            System.out.println("    2. Calculadora de notas");
            System.out.println("    3. Operaciones aritméticas");
            System.out.println("    4. InfoClima2000");
            System.out.println("    8. Salir del programa");
            System.out.println("    Introduzca el número de la sección deseada: ");
            // Pregunto pagina
            Scanner entradax = new Scanner(System.in);
                    pagina = entradax.nextInt();

            // Entro al switch
            switch (pagina) 
            {
                // Información personal
                case 1:
                    // Me presento
                    String nombre = "Sebastian";
                    String apellido = "Laya Gonzalez";
                    int edad = 21;
                    System.out.println("Me llamo " + nombre + " " + apellido + " y tengo " + edad + " años");
                    break;
                case 2:
                    // Voy a calcular una media de las notas que quiero sacar
                    // Pido los datos para la media
                    System.out.println("¿Qué nota quieres sacar en programación? ");
                    Double nota1;
                    Scanner entrada1 = new Scanner(System.in);
                    nota1 = entrada1.nextDouble();
                    System.out.println("¿Y en base de datos? ");
                    Double nota2;
                    Scanner entrada2 = new Scanner(System.in);
                    nota2 = entrada2.nextDouble();
                    System.out.println("Qué optimista, ¿y en inglés? ");
                    Double nota3;
                    Scanner entrada3 = new Scanner(System.in);
                    nota3 = entrada3.nextDouble();

                    // Calculamos la media
                    Double resultado = nota1 + nota2 + nota3;
                    resultado = resultado / 3;

                    // Imprimimos la media
                    // "%.2f" sirve para limitar los decimales a 2
                    System.out.printf("Tu media sería: %.2f", resultado);
                    System.out.println();
                    break;
                case 3:

                    // Declaro variables
                    int a = 10, b = 3;
                    // Pido y leo A
                    System.out.println("Introduzca valor de A: ");
                    Scanner variablenum = new Scanner(System.in);
                    a = variablenum.nextInt();

                    // Pido y leo B
                    System.out.println("Introduzca valor de B: ");
                    b = variablenum.nextInt();

                    // Operaciones aritmeticas
                    int suma = a + b;
                    int resta = a - b;
                    int multiplicacion = a * b;
                    int division = a / b;
                    int modulo = a % b;
                    System.out.println("Donde a = " + a + " y b = " + b);
                    System.out.println("a + b = " + suma);
                    System.out.println("a - b = " + resta);
                    System.out.println("a * b = " + multiplicacion);
                    System.out.println("a / b = " + division);
                    System.out.println("a % b = " + modulo);

                    variablenum.close();
                    break;

                case 4:

                    int temperatura = 32;
                    if(temperatura >25)
                    {
                        System.out.println("A la playa crack!");
                    }
                    else
                    {
                        System.out.println("A tu casa");
                    }

                    boolean haceSol = true;
                    if(haceSol)
                    {
                        System.out.println("No olvides la cremita solar");
                    }
                    
                    
            }
        }

        return;

    }
}