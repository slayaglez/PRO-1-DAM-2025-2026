package com.docencia.listas.ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio10 {

    private Ejercicio10() {
    }

    /**
     * Metodo que rota una lista k posiciones hacia la izquierda
     * @param lista lista a rotar
     * @param k numero de posiciones
     */
    public static void rotarIzquierda(List<Integer> lista, int k) {

        List<Integer> listaRotada = new ArrayList<>();

        if(k > lista.size()){
            k -= lista.size();
        }

        for (int i = 0; i < lista.size(); i++) {
            if(i+k < lista.size()){
                listaRotada.add(lista.get(i+k));
            } else {
                listaRotada.add(lista.get((i+k)-lista.size()));
            }
        }
        lista.removeAll(lista);
        lista.addAll(listaRotada);
    }


    /**
     * Metodo que rota una lista k posiciones hacia la derecha
     * @param lista lista a rotar
     * @param k numero de posiciones
     */
    public static void rotarDerecha(List<Integer> lista, int k) {

        List<Integer> listaRotada = new ArrayList<>();

        if(k > lista.size()){
            k -= lista.size();
        }

        for (int i = 0; i < lista.size(); i++) {
            if(lista.size()+i-k < lista.size()){
                listaRotada.add(lista.get(lista.size()+i-k));
            } else {
                listaRotada.add(lista.get(i-k));
            }
            
        }
        lista.removeAll(lista);
        lista.addAll(listaRotada);
    }
}
