package com.docente.servicio;

import java.util.ArrayList;
import java.util.List;

import com.docente.modelo.Alumno;
import com.docente.persistencia.IAlumnoRepositorio;
import com.docente.persistencia.impl.AlumnoRepositorioCSV;
import com.docente.validacion.Validaciones;

public class AlumnoService implements IAlumnoService {

    final IAlumnoRepositorio alumnoRepositorio;
    List<Alumno> alumnos;

    public AlumnoService() {
        this(new AlumnoRepositorioCSV());
    }

    public AlumnoService(IAlumnoRepositorio alumnoRepositorio) {
        this.alumnoRepositorio = alumnoRepositorio;
        this.alumnos = new ArrayList<>(alumnoRepositorio.obtenerAlumnos());
    }

    public List<String> read() {
        List<String> alumnosStr = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            alumnosStr.add(alumno.toString());
        }
        return alumnosStr;
    }

    public boolean updateLista() {
        alumnoRepositorio.guardarAlumnos(alumnos);
        return true;
    }

    public boolean crearAlumno(String identificador, String nombre, int edad, String curso) {
        if (!Validaciones.esIdentificadorValido(identificador)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esEdadValida(edad)
                || !Validaciones.esCursoValido(curso)) {
            return false;
        }

        Alumno alumnoNuevo = new Alumno(identificador, nombre, edad, curso);
        if (alumnos.contains(alumnoNuevo)) {
            return false;
        }
        alumnos.add(alumnoNuevo);
        return updateLista();
    }

    public boolean actualizarAlumno(String identificador, String nombre, int edad, String curso) {
        if (!Validaciones.esIdentificadorValido(identificador)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esEdadValida(edad)
                || !Validaciones.esCursoValido(curso)) {
            return false;
        }

        Alumno alumnoNuevo = new Alumno(identificador, nombre, edad, curso);
        if (!alumnos.contains(alumnoNuevo)) {
            return false;
        }
        int posicion = alumnos.indexOf(alumnoNuevo);
        alumnos.set(posicion, alumnoNuevo);
        return updateLista();
    }

    public boolean deleteAlumno(String indentificador) {
        if (!Validaciones.esIdentificadorValido(indentificador)) {
            return false;
        }

        Alumno alumnoNuevo = new Alumno(indentificador);
        if (!alumnos.contains(alumnoNuevo)) {
            return false;
        }
        int posicion = alumnos.indexOf(alumnoNuevo);
        alumnos.remove(posicion);
        return updateLista();
    }

    @Override
    public Alumno buscarAlumno(String identificador) {
        if (!Validaciones.esIdentificadorValido(identificador)) {
            return null;
        }
        Alumno alumnoBusqueda = new Alumno(identificador);
        if (!alumnos.contains(alumnoBusqueda)) {
            return null;
        }
        int indice = alumnos.indexOf(alumnoBusqueda);
        return alumnos.get(indice);
    }
}
