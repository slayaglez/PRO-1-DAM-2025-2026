package docencia.condicionales.tres;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 28 sept 2025
 * @class Una cuenta de banco donde puedes ingresar y 
 * retirar dinero más consultar saldo
 * 
 */

public class CajeroAutomatico2 {

    public static void main(String[] args) {
        // Inicio variables fuera del bucle
        int pagina=0;
        float saldo=0;
        // Inicio scanner
        Scanner sc = new Scanner(System.in);
        while (pagina != 8) {

            // Presento mi programa
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("   ==========BANCO SEBASMÁS2===========");
            System.out.println("     Todos los derechos reservados ©");
            System.out.println("      1. Consultar saldo");
            System.out.println("      2. Depositar dinero");
            System.out.println("      3. Retirar dinero");
            System.out.println("      8. Salir");
            // Pregunto a qué página ir
            System.out.println("    Introduzca el número de la sección deseada: ");
            pagina = sc.nextInt();

            // Declaro el la variable auxiliar para alterar el saldo
            float sumaDinero=0;
            // Entro al switch
            switch (pagina) 
            {
                // Imprimo saldo
                case 1:
                    System.out.println("Su saldo actual es de " + saldo +"$");
                    break;
                // Sumo a el saldo con una variable auxiliar
                case 2:
                    System.out.println("Inserte la cantidad de dinero que desea depositar: ");
                    sumaDinero = sc.nextFloat();
                    saldo += sumaDinero;
                    break;
                // Resto a el saldo con una variable auxiliar también
                case 3:
                    System.out.println("Inserte la cantidad de dinero que desea retirar: ");
                    sumaDinero = sc.nextFloat();
                    if(sumaDinero>saldo){
                        System.out.println("Error, fondos insuficientes");
                        break;
                    } else {
                        saldo -= sumaDinero;
                        break;
                    }
                // Salgo del programa
                case 8:
                    System.out.println("Gracias por usar Banco Sebasmás");
                    break;    
                    
            }
          
            
        }
        // Cierro scanner
        sc.close();
    }
}
