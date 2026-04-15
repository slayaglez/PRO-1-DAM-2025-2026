package com.ejemplo.repository.csv;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClienteCsvRepository extends CsvReaderAbstract implements IClienteRepository  {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;
    

    public ClienteCsvRepository(String ruta, String separatorRegex, String separatorWrite) {

    }


    @Override
    public boolean create(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }


    @Override
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }


    @Override
    public Cliente findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }


    @Override
    public boolean update(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    
}
