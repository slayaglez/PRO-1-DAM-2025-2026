package com.ejemplo.repository.sqlite;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.repository.ILineaPedidoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LineaPedidoSqliteRepository  extends SQLiteConnectionManager implements ILineaPedidoRepository {
    private static String  rutaDB = "src/main/resources/sqlite/demo.db";
    LineaPedidoSqliteRepository() {
        super(rutaDB);
        //TODO Auto-generated constructor stub
    }
    LineaPedidoSqliteRepository(String rutaDB) {
        super(rutaDB);
        //TODO Auto-generated constructor stub
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
