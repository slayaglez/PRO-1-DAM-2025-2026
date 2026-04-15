package com.ejemplo.repository.sqlite;

import com.ejemplo.model.Inventario;
import com.ejemplo.repository.IInventarioRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class InventarioSqliteRepository extends SQLiteConnectionManager implements IInventarioRepository {

    private static String  rutaDB = "src/main/resources/sqlite/demo.db";
InventarioSqliteRepository() {
        super(rutaDB);
        //TODO Auto-generated constructor stub
    }

InventarioSqliteRepository(String rutaDB) {
        super(rutaDB);
        //TODO Auto-generated constructor stub
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
