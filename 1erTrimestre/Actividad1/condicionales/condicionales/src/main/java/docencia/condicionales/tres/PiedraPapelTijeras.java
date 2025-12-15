package docencia.condicionales.tres;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 27 sept 2025
 * @class Un programa que simula perfectamente el juego de
 * piedra papel o tijera
 * 
 */
public class PiedraPapelTijeras {
    public static void main(String[] args) {
        // Inicio el Scanner
        Scanner sc = new Scanner(System.in);

        // Pido la primera entrada
        System.out.println("PIEDRA PAPEL TIJERAS");
        System.out.println("Jugador 1, escoja: ");
        String jugador1 = sc.nextLine().trim().toLowerCase();
        int nivel1 = 0;
        // Pido la segunda
        System.out.println("Jugador 2, escoja: ");
        String jugador2 = sc.nextLine().trim().toLowerCase();
        int nivel2 = 0;


        // Si con suerte son iguales todo acaba aquí
        if(jugador1.equals(jugador2)){
            System.out.println("Empate");
        }
        // Si no, empezamos lo divertido
        // Si saca piedra es nivel 1
        if(jugador1.equals("piedra")) {
            nivel1 = 1;
        }
        if(jugador2.equals("piedra")) {
            nivel2 = 1;
        }
        // Si saca papel es nivel 2
        if(jugador1.equals("papel")) {
            nivel1 = 2;
        }
        if(jugador2.equals("papel")) {
            nivel2 = 2;
        }
        // Si saca tijera es nivel 3
        if(jugador1.equals("tijeras")) {
            nivel1 = 3;
        }
        if(jugador2.equals("tijeras")) {
            nivel2 = 3;
        }

        // Creo dos modelos de respuesta
        String ganaJugador1 = "Gana Jugador1 a Jugador2 porque ";
        String ganaJugador2 = "Gana Jugador2 a Jugador1 porque ";

        // Ahora gana el número mayor excepto cuando 1(piedra) y 3(tijera) donde 1 gana a 3
        if(nivel1>nivel2){ // Gana el mayor
            if(nivel1==3 && nivel2==1){ // Excepto cuando 1 y 3
                System.out.println(ganaJugador2 + jugador2 + " > " + jugador1);
            }
            System.out.println(ganaJugador1 + jugador1 + " > " + jugador2);
        
        } else if(nivel1<nivel2){ // Aqui cubro el caso opuesto
            if(nivel2==3 && nivel1==1){
                System.out.println(ganaJugador1 + jugador1 + " > " + jugador2);
            }
            System.out.println(ganaJugador2 + jugador2 + " > " + jugador1);
        }
        //cierro scanner
        sc.close();
        
    }
}
