package com.ejemplo.service;

import com.ejemplo.model.Inmueble;
import java.util.List;
import java.util.function.BooleanSupplier;


public interface IInmuebleService {

    boolean crear(Inmueble inmueble);

    Inmueble buscarPorId(Long id);

    List<Inmueble> listarTodos();

    boolean actualizar(Inmueble inmueble);

    boolean eliminar(Long id);

    List<Inmueble> listarPorPropietario(String dni);

    List<Inmueble> listarVendidos();

    List<Inmueble> listarDisponibles();

    boolean cambiarPropietario(Long inmuebleId, String nuevoDni);

    boolean marcarComoVendido(Long inmuebleId);

    boolean actualizarMetrosCuadrados(Long inmuebleId, int metrosCuadrados);

    double calcularPrecioMedio();


    public double calcularValorTotalDisponible();

    public int contarInmueblesDePropietario(String dniPropietario);

    BooleanSupplier tiporComoVendido(Long id);
}
