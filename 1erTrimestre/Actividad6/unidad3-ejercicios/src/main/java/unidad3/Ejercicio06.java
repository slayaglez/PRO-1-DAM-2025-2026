package unidad3;


public class Ejercicio06 {

    public static long factorial(int n) {
        if(n < 0 || n >= 20){
            throw new IllegalArgumentException();
        }
        int resultado=1;
        for (int i = 0; i < n; i++) {
            resultado *= n-i;
        }
        return resultado;
    }
}
