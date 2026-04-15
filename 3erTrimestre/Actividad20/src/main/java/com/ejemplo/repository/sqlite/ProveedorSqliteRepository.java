package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Proveedor;
import com.ejemplo.repository.IProveedorRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorSqliteRepository extends SQLiteConnectionManager implements IProveedorRepository {
    private static String  rutaDB = "src/main/resources/sqlite/demo.db";
    
    ProveedorSqliteRepository() {
    super(rutaDB);
    }
    ProveedorSqliteRepository(String rutaDB) {
        super(rutaDB);
        //TODO Auto-generated constructor stub
    }

    private SQLiteConnectionManager connectionManager;



    @Override
    public boolean create(Proveedor proveedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<Proveedor> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Proveedor findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public boolean update(Proveedor proveedor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    
}
