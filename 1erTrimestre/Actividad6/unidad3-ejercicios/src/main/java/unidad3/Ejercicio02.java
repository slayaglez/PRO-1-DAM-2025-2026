package unidad3;


public class Ejercicio02 {

    public Ejercicio02() {}

    public static double operar(double a, double b, int opcion) {

        System.out.println("Escoja su operación: "+
                            "\n 1.Sumar"+
                            "\n 2.Restar"+
                            "\n 3.Multiplicar"+
                            "\n 4.Dividir");
        


        switch (opcion) {
            case 1:
                return a+b;
            case 2:
                return a-b;
            case 3:
                return a*b;
            case 4:
                if(b==0){
                    throw new ArithmeticException();
                }
                return a/b;
            default:
                throw new IllegalArgumentException();
        }
    }
}
