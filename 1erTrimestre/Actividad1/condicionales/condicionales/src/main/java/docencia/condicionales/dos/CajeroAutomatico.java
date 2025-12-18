package docencia.condicionales.dos;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 26 sept 2025
 * @class Una cuenta de banco donde puedes ingresar y retirar dinero más consultar saldo
 * 
 */

public class CajeroAutomatico {

    public static void main(String[] args) {
        // Inicio variables fuera del bucle
        int pagina=0;
        float saldo=0;
        while (pagina != 8) {
            //Mensaje de petición
            System.out.println("\n Pulse Enter para continuar");
            // Pido una entrada fantasma para un espaciado elegante entre respuesta y menu
            Scanner entradafantasma = new Scanner(System.in);
            String Casper = entradafantasma.nextLine();
            
            // Presento mi programa
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("   ==========BANCO SEBASMÁS===========");
            System.out.println("    Todos los derechos reservados ©");
            System.out.println("      1. Consultar saldo");
            System.out.println("      2. Depositar dinero");
            System.out.println("      3. Retirar dinero");
            System.out.println("      8. Salir");
            System.out.println("    Introduzca el número de la sección deseada: ");
            // Pregunto a qué ir pagina
            Scanner sc = new Scanner(System.in);
                    pagina = sc.nextInt();

            // Declaro el saldo
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
                    saldo -= sumaDinero;
                    break;
                // Salgo del programa
                case 8:
                    System.out.println("Gracias por usar Banco Sebasmás");
                    break;    
                    
            }
            // Cierro scanner
            
        }
        return;
    }
}
