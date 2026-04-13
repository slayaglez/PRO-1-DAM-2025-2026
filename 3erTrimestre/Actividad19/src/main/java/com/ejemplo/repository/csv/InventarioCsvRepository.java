package com.ejemplo.repository.csv;

import com.ejemplo.model.Inventario;
import com.ejemplo.repository.IInventarioRepository;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InventarioCsvRepository extends CsvReaderAbstract implements IInventarioRepository {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;

    public InventarioCsvRepository(String path, String separatorRegex, String separatorWrite) {


    }

    @Override
    public boolean create(Inventario inventario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<Inventario> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Inventario findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Inventario inventario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    
}
