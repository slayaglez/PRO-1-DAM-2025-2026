package es.docencia.clases.ejercicio2;

public class Programa2 {

    public static void main(String[] args) {
        Producto producto1 = new Producto("A123", 10.0f);
        Producto producto2 = new Producto("A123", 19.0f);

        if(producto1.equals(producto2)) {
            System.out.println("Somos el mismo producto");
        }
    }
}
