package com.ejemplo.repository.csv;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.repository.ILineaPedidoRepository;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LineaPedidoCsvRepository extends CsvReaderAbstract implements ILineaPedidoRepository {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;

    public LineaPedidoCsvRepository(String path, String separatorRegex, String separatorWrite) {

    }

    @Override
    public boolean create(LineaPedido lineaPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<LineaPedido> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public LineaPedido findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(LineaPedido lineaPedido) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    
}
