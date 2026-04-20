package com.ejemplo.model;

import java.util.Objects;

public class Inmueble {

    private Long id;
    private String referencia;
    private String tipo;
    private String direccion;
    private String ciudad;
    private Integer anioConstruccion;
    private Integer metrosCuadrados;
    private Double precio;
    private boolean vendido;
    private String dniPropietario;

    public Inmueble() {
    }

    public Inmueble(Long id, String referencia, String tipo, String direccion, String ciudad,
                    Integer anioConstruccion, Integer metrosCuadrados, Double precio, boolean vendido, String dniPropietario) {
        this.id = id;
        this.referencia = referencia;
        this.tipo = tipo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.anioConstruccion = anioConstruccion;
        this.metrosCuadrados = metrosCuadrados;
        this.precio = precio;
        this.vendido = vendido;
        this.dniPropietario = dniPropietario;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public Integer getAnioConstruccion() { return anioConstruccion; }
    public void setAnioConstruccion(Integer anioConstruccion) { this.anioConstruccion = anioConstruccion; }
    public Integer getMetrosCuadrados() { return metrosCuadrados; }
    public void setMetrosCuadrados(Integer metrosCuadrados) { this.metrosCuadrados = metrosCuadrados; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public boolean isVendido() { return vendido; }
    public void setVendido(boolean vendido) { this.vendido = vendido; }
    public String getDniPropietario() { return dniPropietario; }
    public void setDniPropietario(String dniPropietario) { this.dniPropietario = dniPropietario; }

    @Override
    public String toString() {
        return "Inmueble{" +
                "id=" + id +
                ", referencia='" + referencia + '\'' +
                ", tipo='" + tipo + '\'' +
                ", direccion='" + direccion + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", anioConstruccion=" + anioConstruccion +
                ", metrosCuadrados=" + metrosCuadrados +
                ", precio=" + precio +
                ", vendido=" + vendido +
                ", dniPropietario='" + dniPropietario + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inmueble inmueble = (Inmueble) o;
        return Objects.equals(id, inmueble.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setMatricula(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMatricula'");
    }

    public void setModelo(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setModelo'");
    }

    public void setKilometros(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setKilometros'");
    }

    public void setColor(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setColor'");
    }

    public Object getColor() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getColor'");
    }

    public Integer getKilometros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getKilometros'");
    }
}
