package com.ejemplo.model;

import java.util.Objects;

public class Inventario {

    private Long id;
    private Long productoId;
    private Long proveedorId;
    private String ubicacion;
    private int stockDisponible;
    private int stockMinimo;
    private String fechaActualizacion;

    public Inventario() {
    }

    public Inventario(Long id, Long productoId, Long proveedorId, String ubicacion, int stockDisponible, int stockMinimo, String fechaActualizacion) {
        this.id = id;
        this.productoId = productoId;
        this.proveedorId = proveedorId;
        this.ubicacion = ubicacion;
        this.stockDisponible = stockDisponible;
        this.stockMinimo = stockMinimo;
        this.fechaActualizacion = fechaActualizacion;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public Long getProveedorId() { return proveedorId; }
    public void setProveedorId(Long proveedorId) { this.proveedorId = proveedorId; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public int getStockDisponible() { return stockDisponible; }
    public void setStockDisponible(int stockDisponible) { this.stockDisponible = stockDisponible; }

    public int getStockMinimo() { return stockMinimo; }
    public void setStockMinimo(int stockMinimo) { this.stockMinimo = stockMinimo; }

    public String getFechaActualizacion() { return fechaActualizacion; }
    public void setFechaActualizacion(String fechaActualizacion) { this.fechaActualizacion = fechaActualizacion; }

    @Override
    public String toString() {
        return "Inventario{" +
                "id=" + id +
                ", productoId=" + productoId +
                ", proveedorId=" + proveedorId +
                ", ubicacion='" + ubicacion + '\'' +
                ", stockDisponible=" + stockDisponible +
                ", stockMinimo=" + stockMinimo +
                ", fechaActualizacion='" + fechaActualizacion + '\'' +
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
        Inventario other = (Inventario) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
