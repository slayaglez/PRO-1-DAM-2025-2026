package com.docencia.composicion.ejercicio16;

public class Telefono {
    private String tipo;
    private String numero;
    
    public Telefono(String tipo, String numero) {
        this.tipo = tipo;
        this.numero = numero;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
        Telefono other = (Telefono) obj;
        if (tipo == null) {
            if (other.tipo != null)
                return false;
        } else if (!tipo.equals(other.tipo))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Telefono [tipo=" + tipo + ", numero=" + numero + "]";
    }

    
}
