package com.docencia.composicion.ejercicio20;

import java.util.Objects;

public class Cita {

    private String fecha;
    private String motivo;
    private Mascota mascota;

    public Cita(){
    }

    public Cita(String fecha, String motivo, Mascota mascota) {
        this.fecha = fecha;
        this.motivo = motivo;
        this.mascota = mascota;
    }

    /** Getters y Setters */
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.fecha);
        hash = 97 * hash + Objects.hashCode(this.motivo);
        hash = 97 * hash + Objects.hashCode(this.mascota);
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
        final Cita other = (Cita) obj;
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.motivo, other.motivo)) {
            return false;
        }
        return Objects.equals(this.mascota, other.mascota);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CITA").append("\n");
        sb.append("fecha: ").append(fecha);
        sb.append(", motivo: ").append(motivo).append("\n");
        sb.append("Mascota: ").append(mascota);
        return sb.toString();
    }

    

}
