package com.ejemplo.service;

import com.ejemplo.model.Inmueble;
import com.ejemplo.repository.IPropietarioRepository;
import com.ejemplo.repository.IInmuebleRepository;
import com.ejemplo.repository.sqlite.PropietarioSqliteRepository;
import com.ejemplo.repository.sqlite.InmuebleSqliteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class InmuebleService implements IInmuebleService {

    private final IInmuebleRepository inmuebleRepository;
    private final IPropietarioRepository propietarioRepository;

    public InmuebleService() {
        this.inmuebleRepository = new InmuebleSqliteRepository();
        this.propietarioRepository = new PropietarioSqliteRepository();
    }

    @Override
    public boolean crear(Inmueble inmueble) {
        return inmuebleRepository.create(inmueble);
        
    }

    @Override
    public Inmueble buscarPorId(Long id) {
        return inmuebleRepository.findById(id);    
    }

    @Override
    public List<Inmueble> listarTodos() {
        return inmuebleRepository.findAll();
    }

    @Override
    public boolean actualizar(Inmueble inmueble) {
        return inmuebleRepository.update(inmueble);
    }

    @Override
    public boolean eliminar(Long id) {
        return inmuebleRepository.deleteById(id);        
    }

    @Override
    public List<Inmueble> listarPorPropietario(String dni) {
        List<Inmueble> resultado = new ArrayList<>();
        List<Inmueble> inmuebles = inmuebleRepository.findAll();
        for (Inmueble inmueble : inmuebles) {
            if(inmueble.getDniPropietario().equals(dni)) {
                resultado.add(inmueble);
            }
        }    
        return resultado.isEmpty()? null : resultado;
    }

    @Override
    public List<Inmueble> listarVendidos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarVendidos'");
    }

    @Override
    public List<Inmueble> listarDisponibles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarDisponibles'");
    }

    @Override
    public boolean cambiarPropietario(Long inmuebleId, String nuevoDni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cambiarPropietario'");
    }

    @Override
    public boolean marcarComoVendido(Long inmuebleId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'marcarComoVendido'");
    }

    @Override
    public boolean actualizarMetrosCuadrados(Long inmuebleId, int metrosCuadrados) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarMetrosCuadrados'");
    }

    @Override
    public double calcularPrecioMedio() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularPrecioMedio'");
    }

    @Override
    public double calcularValorTotalDisponible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calcularValorTotalDisponible'");
    }

    @Override
    public int contarInmueblesDePropietario(String dniPropietario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contarInmueblesDePropietario'");
    }

    @Override
    public BooleanSupplier tiporComoVendido(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tiporComoVendido'");
    }
}
