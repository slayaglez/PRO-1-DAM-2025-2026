package com.docencia.listas.ejercicio08;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio08 {

    private Ejercicio08() {
    }

    public static class ResultadoParticion {
        private final List<Integer> pares;
        private final List<Integer> impares;

        public ResultadoParticion(List<Integer> pares, List<Integer> impares) {
            this.pares = pares;
            this.impares = impares;
        }

        public List<Integer> getPares() {
            return pares;
        }

        public List<Integer> getImpares() {
            return impares;
        }
    }

    public static ResultadoParticion partir(List<Integer> lista) {

        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        for (Integer integer : lista) {
            if(integer%2==0){
                pares.add(integer);
            } 
            else {
                impares.add(integer);
            }
        }

        ResultadoParticion resultado = new ResultadoParticion(pares, impares);
        return resultado;
    }
}
