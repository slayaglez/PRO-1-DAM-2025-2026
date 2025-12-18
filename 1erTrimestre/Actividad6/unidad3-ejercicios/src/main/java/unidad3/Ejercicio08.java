package unidad3;

public class Ejercicio08 {

    public static boolean esPrimo(int n) {
        if(n <= 1){
            throw new IllegalArgumentException();
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
