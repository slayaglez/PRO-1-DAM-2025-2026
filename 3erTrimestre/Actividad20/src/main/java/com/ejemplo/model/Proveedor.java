package com.ejemplo.model;

import java.util.Objects;

public class Proveedor {

    private Long id;
    private String codigo;
    private String nombre;
    private String contacto;
    private String email;
    private String pais;

    public Proveedor() {
    }

    public Proveedor(Long id, String codigo, String nombre, String contacto, String email, String pais) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.contacto = contacto;
        this.email = email;
        this.pais = pais;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", contacto='" + contacto + '\'' +
                ", email='" + email + '\'' +
                ", pais='" + pais + '\'' +
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
        Proveedor other = (Proveedor) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
