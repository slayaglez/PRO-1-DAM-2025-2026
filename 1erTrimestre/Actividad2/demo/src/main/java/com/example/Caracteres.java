package com.example;
import java.util.Scanner;
/**
 * 
 * @author slayaglez
 * @date 3 Oct 2025
 * @class Jugando con caracteres
 */
public class Caracteres {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // PALÍNDROMO
        System.out.println("Palíndromo");
        String palindromo = sc.nextLine();
        char caracterIz;
        char caracterDe;
        boolean esPalindromo=true;

        for(int i=0; i<palindromo.length()/2 ;i++){
            
            if(palindromo.charAt(i)!= palindromo.charAt(palindromo.length()-1-i)){
                esPalindromo=false;
            }
        }
        if(esPalindromo){
            System.out.println("Sí es palíndromo");
        } else {
            System.out.println("No es palíndromo");
        }

        // SUSTITUCIÓN
        System.out.println("SUSTITUCIÓN");
        System.out.println("¿En qué frase desea sustituir la R por la L?");

        String nuevaCadena="";
        String sustitucion= sc.nextLine();

        for(int i=0; i<sustitucion.length(); i++){
            if(sustitucion.charAt(i)=='r'){
                nuevaCadena += 'l';
            } else {
                nuevaCadena+=sustitucion.charAt(i);
            }

        }
        System.out.println(nuevaCadena);

        // PRIMERA MAYUS
        System.out.println("MAYUS");
        System.out.println("Introduzca una frase: ");
        String fraseMayus=sc.nextLine().toLowerCase();
        boolean inicioFrase=true;
        String nuevaFrase="";
        for(int i=0; i<fraseMayus.length(); i++){
            if(fraseMayus.charAt(i)!=' ' && inicioFrase==true) {
                nuevaFrase+=Character.toUpperCase(fraseMayus.charAt(i));
                inicioFrase=false;
            } else {
                nuevaFrase+=fraseMayus.charAt(i);
            }
            if(fraseMayus.charAt(i)==' '){
                inicioFrase=true;
            }
        }
        System.out.println(nuevaFrase);
    }
}
