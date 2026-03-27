package com.docente.servicio;

import com.docente.modelo.Alumno;
import com.docente.modelo.AlumnoMatriculado;
import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAlumnoMatriculadoRepositorio;
import com.docente.persistencia.impl.AlumnoMatriculadoRepositorioCSV;
import com.docente.validacion.Validaciones;

import java.util.ArrayList;
import java.util.List;


public class AlumnoMatriculadoService implements IAlumnoMatriculadoService {

    private final IAlumnoMatriculadoRepositorio alumnoRepositorio;
    private final IAsignaturaService asignaturaService;
    private final List<AlumnoMatriculado> alumnosMatriculados;

    public AlumnoMatriculadoService() {
        this(new AlumnoMatriculadoRepositorioCSV(), new AsignaturaService());
    }

    public AlumnoMatriculadoService(IAlumnoMatriculadoRepositorio alumnoRepositorio, IAsignaturaService asignaturaService) {
        this.alumnoRepositorio = alumnoRepositorio;
        this.asignaturaService = asignaturaService;
        this.alumnosMatriculados = new ArrayList<>(alumnoRepositorio.obtenerAlumnosMatriculados());
    }

    @Override
    public List<String> read() {
        List<String> alumnosStr = new ArrayList<>();
        for (Alumno alumnoMat : alumnosMatriculados) {
            alumnosStr.add(alumnoMat.toString());
        }
        return alumnosStr;
    }

    public boolean updateLista() {
        alumnoRepositorio.guardarAlumnosMatriculados(alumnosMatriculados);
        return true;
    }

    @Override
    public boolean crearAlumnoMatriculado(String identificador, String nombre, int edad, String curso) {
        if (!Validaciones.esIdentificadorValido(identificador)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esEdadValida(edad)
                || !Validaciones.esCursoValido(curso)) {
            return false;
        }

        AlumnoMatriculado alumnoNuevo = new AlumnoMatriculado(identificador, nombre, edad, curso);
        if (alumnosMatriculados.contains(alumnoNuevo)) {
            return false;
        }
        alumnosMatriculados.add(alumnoNuevo);
        return updateLista();
    }

    @Override
    public boolean actualizarAlumnoMatriculado(String identificador, String nombre, int edad, String curso) {
        if (!Validaciones.esIdentificadorValido(identificador)
                || !Validaciones.esNombreValido(nombre)
                || !Validaciones.esEdadValida(edad)
                || !Validaciones.esCursoValido(curso)) {
            return false;
        }

        AlumnoMatriculado alumnoNuevo = new AlumnoMatriculado(identificador, nombre, edad, curso);
        if (!alumnosMatriculados.contains(alumnoNuevo)) {
            return false;
        }
        int posicion = alumnosMatriculados.indexOf(alumnoNuevo);
        alumnosMatriculados.set(posicion, alumnoNuevo);
        return updateLista();
    }

    @Override
    public boolean deleteAlumnoMatriculado(String identificador) {
        if (!Validaciones.esIdentificadorValido(identificador)) {
            return false;
        }

        Alumno alumnoNuevo = new Alumno(identificador);
        if (!alumnosMatriculados.contains(alumnoNuevo)) {
            return false;
        }
        int posicion = alumnosMatriculados.indexOf(alumnoNuevo);
        alumnosMatriculados.remove(posicion);
        return updateLista();
    }

    @Override
    public AlumnoMatriculado buscarAlumnoMatriculado(String identificador) {
        if (!Validaciones.esIdentificadorValido(identificador)) {
            return null;
        }
        AlumnoMatriculado alumnoBusqueda = new AlumnoMatriculado(identificador);
        if (!alumnosMatriculados.contains(alumnoBusqueda)) {
            return null;
        }
        int indice = alumnosMatriculados.indexOf(alumnoBusqueda);
        return alumnosMatriculados.get(indice);
    }

    @Override
    public boolean matricularAsignatura(String identificadorAlumno, String codigoAsignatura) {
        if(!Validaciones.esIdentificadorValido(identificadorAlumno)
            || !Validaciones.esCodigoAsignaturaValido(codigoAsignatura)){
            return false;        
        }
        
        AlumnoMatriculado alumnoBusqueda = new AlumnoMatriculado(identificadorAlumno);

        for (AlumnoMatriculado alumnoMatriculado : alumnosMatriculados) {
            if (alumnoMatriculado.equals(alumnoBusqueda)){
                return alumnoMatriculado.addAsignatura(new Asignatura(codigoAsignatura));
            }
        }
        return false;
    }

    @Override
    public boolean desmatricularAsignatura(String identificadorAlumno, String codigoAsignatura) {
        if(!Validaciones.esIdentificadorValido(identificadorAlumno)
            || !Validaciones.esCodigoAsignaturaValido(codigoAsignatura)){
            return false;        
        }
        
        AlumnoMatriculado alumnoBusqueda = new AlumnoMatriculado(identificadorAlumno);

        Asignatura asignatura = new Asignatura(codigoAsignatura);

        for (AlumnoMatriculado alumnoMatriculado : alumnosMatriculados) {
            if (alumnoMatriculado.equals(alumnoBusqueda) && alumnoMatriculado.getAsignaturas().contains(asignatura)){
                return alumnoMatriculado.removeAsignatura(codigoAsignatura);
            }
        }
        return false;
    }

    @Override
    public int getNumeroAsignaturas(String identificadorAlumno) {
        if(!Validaciones.esIdentificadorValido(identificadorAlumno)){
            return 0;        
        }
        
        AlumnoMatriculado alumnoBusqueda = new AlumnoMatriculado(identificadorAlumno);

        for (AlumnoMatriculado alumnoMatriculado : alumnosMatriculados) {
            if(alumnoMatriculado.equals(alumnoBusqueda)){
                return alumnoMatriculado.getNumeroAsignaturas();
            }
        }
        return 0;
    }

    @Override
    public boolean estaMatriculadoEn(String identificadorAlumno, String codigoAsignatura) {
        if(!Validaciones.esIdentificadorValido(identificadorAlumno)
            || !Validaciones.esCodigoAsignaturaValido(codigoAsignatura)){
            return false;        
        }
        
        AlumnoMatriculado alumnoBusqueda = new AlumnoMatriculado(identificadorAlumno);

        Asignatura asignatura = new Asignatura(codigoAsignatura);

        for (AlumnoMatriculado alumnoMatriculado : alumnosMatriculados) {
            if (alumnoMatriculado.equals(alumnoBusqueda) && alumnoMatriculado.getAsignaturas().contains(asignatura)){
                return true;
            }
        }
        return false;
        
    }
}
