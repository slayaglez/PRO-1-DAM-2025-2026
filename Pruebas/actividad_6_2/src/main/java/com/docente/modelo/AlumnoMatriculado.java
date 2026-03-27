package com.docente.modelo;

import java.util.ArrayList;
import java.util.List;

import com.docente.validacion.Validaciones;


public class AlumnoMatriculado extends Alumno {

    private List<Asignatura> asignaturas;

    public AlumnoMatriculado(String identificador) {
        super(identificador);
        this.asignaturas = new ArrayList<>();
    }

    public AlumnoMatriculado(String identificador, String nombre, int edad, String curso) {
        super(identificador, nombre, edad, curso);
        this.asignaturas = new ArrayList<>();
    }

    public AlumnoMatriculado(String identificador, String nombre, int edad, String curso, List<Asignatura> asignaturas) {
        super(identificador, nombre, edad, curso);
        this.asignaturas = asignaturas == null ? new ArrayList<>() : new ArrayList<>(asignaturas);
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas == null ? new ArrayList<>() : new ArrayList<>(asignaturas);
    }

    public boolean addAsignatura(Asignatura asignatura) {
        if (asignatura == null || asignaturas.contains(asignatura)) {
            return false;
        }
        return asignaturas.add(asignatura);
    }

    public boolean removeAsignatura(String codigoAsignatura) {
       if(!Validaciones.esCodigoAsignaturaValido(codigoAsignatura)){
        return false;
       }
        return asignaturas.removeIf(asignatura -> asignatura.getCodigo().equals(codigoAsignatura));
    }

    public int getNumeroAsignaturas() {
        return asignaturas.size();
    }

    public boolean estaMatriculadoEn(String codigoAsignatura) {
        if(!Validaciones.esCodigoAsignaturaValido(codigoAsignatura)){
        return false;
       }

        Asignatura asignaturaBuscada = new Asignatura(codigoAsignatura);
        return asignaturas.contains(asignaturaBuscada);
    }

    public String toCsv() {
        StringBuilder codigos = new StringBuilder();
        for (int i = 0; i < asignaturas.size(); i++) {
            codigos.append(asignaturas.get(i).getCodigo());
            if (i < asignaturas.size() - 1) {
                codigos.append(',');
            }
        }
        return getIdentificador() + "|" + getNombre() + "|" + getEdad() + "|" + getCurso() + "|" + codigos;
    }

    @Override
    public String toString() {
        return "AlumnoMatriculado [identificador=" + getIdentificador()
                + ", nombre=" + getNombre()
                + ", edad=" + getEdad()
                + ", curso=" + getCurso()
                + ", numeroAsignaturas=" + getNumeroAsignaturas()
                + ", asignaturas=" + asignaturas + "]";
    }
}
