package com.docente.servicio;

import com.docente.modelo.Alumno;
import com.docente.modelo.Asignatura;
import com.docente.persistencia.IAsignaturaRepositorio;
import com.docente.persistencia.impl.AsignaturaRepositorioCSV;
import com.docente.validacion.Validaciones;

import java.util.ArrayList;
import java.util.List;


public class AsignaturaService implements IAsignaturaService {

    private final IAsignaturaRepositorio asignaturaRepositorio;
    private final List<Asignatura> asignaturas;

    public AsignaturaService() {
        this(new AsignaturaRepositorioCSV());
    }

    public AsignaturaService(IAsignaturaRepositorio asignaturaRepositorio) {
        this.asignaturaRepositorio = asignaturaRepositorio;
        this.asignaturas = new ArrayList<>(asignaturaRepositorio.obtenerAsignaturas());
    }

    /**
     * Metodo que lee la lista de asignaturas y devuelve lista de String
     */
    @Override
    public List<String> read() {
        List<String> asignaturaStr = new ArrayList<>();
        for (Asignatura asignatura : asignaturas) {
            asignaturaStr.add(asignatura.toString());
        }
        return asignaturaStr;
    }

    public boolean updateLista() {
        return asignaturaRepositorio.guardarAsignaturas(asignaturas);
    }

    @Override
    public boolean crearAsignatura(String codigo, String nombre, int horasSemanales) {
        if(!Validaciones.esCodigoAsignaturaValido(codigo)
            || !Validaciones.esNombreValido(nombre)
            || !Validaciones.esHorasSemanalesValidas(horasSemanales)){
           return false; 
        }

        Asignatura asignaturaNueva = new Asignatura(codigo, nombre, horasSemanales);
        if (asignaturas.contains(asignaturaNueva)) {
            return false;
        }
        asignaturas.add(asignaturaNueva);
        return updateLista();
    }

    @Override
    public boolean actualizarAsignatura(String codigo, String nombre, int horasSemanales) {
        if(!Validaciones.esCodigoAsignaturaValido(codigo)
            || !Validaciones.esNombreValido(nombre)
            || !Validaciones.esHorasSemanalesValidas(horasSemanales)){
           return false; 
        }

        Asignatura asignaturaNueva = new Asignatura(codigo, nombre, horasSemanales);
        if (!asignaturas.contains(asignaturaNueva)) {
            return false;
        }
        int posicion = asignaturas.indexOf(asignaturaNueva);
        asignaturas.set(posicion, asignaturaNueva);
        return updateLista();
    }

    @Override
    public boolean deleteAsignatura(String codigo) {
        if (!Validaciones.esIdentificadorValido(codigo)) {
            return false;
        }

        Asignatura asignaturaNueva = new Asignatura(codigo);
        if (!asignaturas.contains(asignaturaNueva)) {
            return false;
        }
        int posicion = asignaturas.indexOf(asignaturaNueva);
        asignaturas.remove(posicion);
        return updateLista();
    }

    @Override
    public Asignatura buscarAsignatura(String codigo) {
        if (!Validaciones.esIdentificadorValido(codigo)) {
            return null;
        }
        Asignatura asignaturaBusqueda = new Asignatura(codigo);
        if (!asignaturas.contains(asignaturaBusqueda)) {
            return null;
        }
        int indice = asignaturas.indexOf(asignaturaBusqueda);
        return asignaturas.get(indice);
    }
}
