package com.ejemplo.model;

import java.util.Objects;

public class Pedido {

    private Long id;
    private String numero;
    private Long clienteId;
    private String fecha;
    private String estado;
    private double total;

    public Pedido() {
    }

    public Pedido(Long id, String numero, Long clienteId, String fecha, String estado, double total) {
        this.id = id;
        this.numero = numero;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", clienteId=" + clienteId +
                ", fecha='" + fecha + '\'' +
                ", estado='" + estado + '\'' +
                ", total=" + total +
                "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pedido other = (Pedido) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
