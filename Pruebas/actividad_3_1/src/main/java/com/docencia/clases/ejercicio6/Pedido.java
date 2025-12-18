/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Clase que trabaja con pedidos, su precio y su estado.
 */
package com.docencia.clases.ejercicio6;

import java.util.Objects;

public class Pedido {
    private String codigo;
    private double importe;
    private String estado;

    /**
     * Constructor vacio
     */
    public Pedido() {}

    /**
     * Constructor con identificador unico
     * @param codigo id unico
     */
    public Pedido(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Constructor con identificador unico
     * @param codigo id unico
     * @param importe importe del pedido
     * @param estado estado del pedido
     */
    public Pedido(String codigo, double importe, String estado) {
        this.codigo = codigo;
        this.importe = importe;
        this.estado = estado;
    }

    /** Getters y Setters */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pedido other = (Pedido) obj;
        return Objects.equals(codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Pedido [codigo=" + codigo + ", importe=" + importe + ", estado=" + estado + "]";
    }
}
