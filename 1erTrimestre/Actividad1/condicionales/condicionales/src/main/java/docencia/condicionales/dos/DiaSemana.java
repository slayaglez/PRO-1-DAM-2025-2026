package docencia.condicionales.dos;

import java.util.Scanner;

/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 24 sept 2025
 * @class En base al color del semáforo se te mostrará un mensaje
 * sobre lo que debes hacer
 * 
 */

public class DiaSemana {
    public static void main(String[] args) {
        // Inicio la clase Scanner
        Scanner sc = new Scanner(System.in);
        // Inicio la variable dia y contador fuera del bucle
        int contador = 1, dia = 0;

        // Inicio bucle hasta que el usuario introduzca un valor correcto
        while (contador == 1) {

            // Pido el número
            System.out.print("Ingresa un número (1-7): ");
            dia = sc.nextInt();

            // Si no está entre 1 y 7 el bucle reinicia, si sí lo está salgo del bucle
            if (dia < 1 || dia > 7) {
                System.out.println("Introduzca un número válido");
            }
            else {
                contador = 0;
            }

        }

        // Hago un array con las respuestas
        String diasDeLaSemana[] = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
        // Resto 1 a la respuesta para que me devuelva la posición del día (0, 6)
        System.out.println(diasDeLaSemana[dia - 1]);

        // Cierro el Scanner
        sc.close();
    }
}
