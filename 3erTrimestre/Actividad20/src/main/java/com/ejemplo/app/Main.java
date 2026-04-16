package com.ejemplo.app;

import com.ejemplo.repository.sqlite.ClienteSqliteRepository;

public class Main {

    public static void main(String[] args) {
        ClienteSqliteRepository repo = new ClienteSqliteRepository();
        boolean e = repo.deleteById(1l);
        System.out.println(e);
    }
    
    
}
