package docencia.condicionales.tres;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Una cuenta de comprar helado que tiene precios que se suman
 * y puedes consultar el total
 * 
 */
public class Heladeria {
    public static void main(String[] args) {
        // Abro Scanner
        Scanner sc = new Scanner(System.in);
        // Declaro variables
        int continuar=1;
        float carrito=0;
        // Bucle hasta que el usuario quiera salir
        while (continuar != 0) {
            // Pido lo que quiera el usuario
            System.out.println("Introduzca qué sabor desea: \n1.Vainilla 2.60$\n2.Chocolate 3.00$\n3.Fresa 2.80$\n4.Ver carrito\n5.Salir");
            int eleccion = sc.nextInt();
            // Sumo el precio de lo elegido al carrito
            switch (eleccion) {
                case 1:
                    System.out.println("Vainilla al carrito");
                    carrito += 2.60;
                    break;
                case 2:
                    System.out.println("Chocolate al carrito");
                    carrito += 3;
                    break;
                case 3:
                    System.out.println("Fresa al carrito");
                    carrito += 2.80;
                    break;
                case 4: // Imprimo carrito
                    System.out.println("Debe "+carrito+"$");
                    break;
                case 5: // Rompo el bucle
                    continuar=0;
                    break;
            }

        }
        // Cierro el Scanner
        sc.close();

    }
}
