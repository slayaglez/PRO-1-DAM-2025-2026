package com.docencia.composicion.ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;

    public Carrito(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productos == null) ? 0 : productos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carrito other = (Carrito) obj;
        if (productos == null) {
            if (other.productos != null)
                return false;
        } else if (!productos.equals(other.productos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Carrito [productos=" + productos + "]";
    }

    public boolean agregarCarrito(Producto producto){

        if(producto == null){
            return false;
        }

        productos.add(producto);
        return true;
    }

    
}
