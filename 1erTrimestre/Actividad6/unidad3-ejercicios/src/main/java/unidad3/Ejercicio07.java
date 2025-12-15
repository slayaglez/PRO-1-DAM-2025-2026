package unidad3;

import java.util.*;


public class Ejercicio07 {

    public static class ParesImpares {
        private List<Integer> pares;
        private List<Integer> impares;

        public ParesImpares(){}

        public ParesImpares(List<Integer> pares, List<Integer> impares) {
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


    public static ParesImpares calcularParesImpares(int a, int b) {
        if(a > b){ // a siempre será el menor
            int aux = a;
            a = b;
            b = aux;
            }

        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();

        for (int i = a; i <= b; i++) {
            if(i % 2 == 0){
               pares.add(i); 
            }
            if(i % 2 != 0){
               impares.add(i); 
            }

        }
        return new ParesImpares(pares, impares);
    }
}
