package com.docencia.composicion.ejercicio12;

import java.util.List;
import java.util.Objects;

public class Pedido {
    private List<LineaPedido> pedidos;

    public Pedido(List<LineaPedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<LineaPedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<LineaPedido> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.pedidos);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        return Objects.equals(this.pedidos, other.pedidos);
    }

    @Override
    public String toString() {
        return "Pedido [pedidos=" + pedidos + "]";
    }

    
}
