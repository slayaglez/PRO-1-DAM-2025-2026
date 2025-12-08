package com.docencia.composicion.ejercicio16;

import java.util.List;

public class Agenda {
    private List<Contacto> Agenda;

    public Agenda(List<Contacto> agenda) {
        Agenda = agenda;
    }

    public List<Contacto> getAgenda() {
        return Agenda;
    }

    public void setAgenda(List<Contacto> agenda) {
        Agenda = agenda;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Agenda == null) ? 0 : Agenda.hashCode());
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
        Agenda other = (Agenda) obj;
        if (Agenda == null) {
            if (other.Agenda != null)
                return false;
        } else if (!Agenda.equals(other.Agenda))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Agenda [Agenda=" + Agenda + "]";
    }
    
    
}
