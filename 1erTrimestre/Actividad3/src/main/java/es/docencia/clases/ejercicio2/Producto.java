package es.docencia.clases.ejercicio2;
import java.util.Objects;

public class Producto {
    private String codigo;
    private float precio;

    /** */
    public Producto() {}

    /**
     * Constructor con parámetros de la clase
     * @param codigo Código producto
     * @param precio Precio producto
     */
    public Producto(String codigo, float precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, precio);
    }
    

}
