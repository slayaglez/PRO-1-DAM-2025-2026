package org.docencia;
/**
 * 
 * @author slayaglez
 * @date 3 Oct 2025
 * @class Un array de numeros mixtos enterosque distingue entre positivos
 * negativos, ceros e imprime el mayor y menor. Ademas optimiza iterando una vez menos a elementos haya en el 
 * array. Esto se consigue asignando a la variable numero la primera posicion del array
 * e imprimiendo su resultado antes de entrar al bucle for, de esta manera solo tiene que
 * iterar por los elementos restantes del array. Uso el mismo principio para el número mayor
 * 
 */

public class Ejercicio4 {
    public static void main(String[] args) {
        int[] numeros = {-5, 0, 7, 3, -2};
        int numero = numeros[0];
        int maximoNumero= numeros[0];
        int minimoNumero= numeros[0];

        if(numero==0){
            System.out.println("cero detectado = 0");
        } else if(numero<0){
            System.out.println("numero negativo = "+numero);
        } else {
            System.out.println("numero positivo = "+numero);
        }
        
        for(int i=1; i<numeros.length; i++){
            numero=numeros[i];
            if(numero==0){
                System.out.println("cero detectado = 0");
            } else if(numero<0){
                System.out.println("numero negativo = "+numero);
            } else {
                System.out.println("numero positivo = "+numero);
            }
            if(maximoNumero<numero){
                maximoNumero=numero;
            }
            if(minimoNumero>numero) {
                minimoNumero=numero;
            }
        }
        System.out.println("El número más grande es "+maximoNumero);
        System.out.println("El número más pequeño es "+minimoNumero);
    }
}
