package com.ejemplo.repository;

import com.ejemplo.model.Inmueble;
import java.util.List;

public interface IInmuebleRepository {
    boolean create(Inmueble inmueble);
    List<Inmueble> findAll();
    Inmueble findById(Long id);
    boolean update(Inmueble inmueble);
    boolean deleteById(Long id);
}
