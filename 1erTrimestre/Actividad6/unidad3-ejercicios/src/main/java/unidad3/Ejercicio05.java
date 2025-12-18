package unidad3;


public class Ejercicio05 {

    public Ejercicio05() {}

    public static int[] tablaMultiplicar(int n) {
        int[] tabla = new int[10];

        for (int i = 0; i < tabla.length; i++) {
            tabla[i] = n * (i+1);
        }
        return tabla;
    }

    
    public static int sumaTabla(int n) {
        int suma=0;
        for (int i = 0; i < 10; i++) {
            suma += n*(i+1);
        }
        return suma;
    }
}
