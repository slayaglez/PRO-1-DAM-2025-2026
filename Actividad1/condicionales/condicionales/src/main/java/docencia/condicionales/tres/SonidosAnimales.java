package docencia.condicionales.tres;

import java.util.Scanner;
/**
 * Clase principal
 * 
 * @author slayaglez
 * @date 28 sept 2025
 * @class Un programa que devuelve un sonido en base al animal introducido
 * 
 */
public class SonidosAnimales {
    public static void main(String[] args) {
        //abro scanner
        Scanner sc = new Scanner(System.in);
        //pido animal
        System.out.println("Introduce un animal: ");
        String animal= sc.nextLine().trim().toLowerCase();
        //array de sonidos
        String sonidos[]={"Muuu", "Guaf, guaf!", "Miaus miau", "Beeeee", "Roaaar", "...", "Kikirikiiii", "¡Programar es divertido!"};
        //segun el animal imprimo su ruido 
        switch(animal){
            case "vaca", "bovino": System.out.println(sonidos[0]);
                break;
            case "perro", "can": System.out.println(sonidos[1]); 
                break;
            case "gato", "felino": System.out.println(sonidos[2]);
                break;
            case "cabra", "oveja": System.out.println(sonidos[3]);
                break;
            case "leon", "tigre": System.out.println(sonidos[4]);
                break;
            case "jirafa": System.out.println(sonidos[5]);
                break;
            case "gallo": System.out.println(sonidos[6]);
                break;
            case "persona": System.out.println(sonidos[7]);
        }
        //cierro scanner
        sc.close();
    }
}
