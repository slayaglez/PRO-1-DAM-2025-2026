package org.docencia.unidad3.examen.ejercicio03;
/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que calcula una media pasado un array de enteros y te hace 
 * adivinar el numero dando pistas de tu cercania
 * 
 */
public class JuegoNotas {

    /**
     * Funcion que calcula la media de un array de enteros
     * @param notas array de enteros
     * @return media del array
     */
    public double calcularMedia(int[] notas) {
        if(notas == null || notas.length == 0){
            throw new IllegalArgumentException();
        }

        double media = notas[0];
        for (int i = 1; i < notas.length; i++) {
            media += notas[i];
        }
        return media/notas.length;

    }

    /**
     * Funcion que devuelve un mensaje en base a los cerca que 
     * el intento este de la media real
     * @param mediaReal numero a adivinar
     * @param intento intento del numero a adivinar
     * @return mensaje de feedback
     */
    public String evaluarIntento(double mediaReal, double intento) {
        if(mediaReal < intento){
            return "Demasiado alta";
        }
        if(mediaReal > intento){
            return "Demasiado baja";
        }
        if(mediaReal == intento){
            return "¡Correcta!";
        }
        return null;
    }
}
