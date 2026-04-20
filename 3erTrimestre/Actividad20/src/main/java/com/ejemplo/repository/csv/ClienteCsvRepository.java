package com.ejemplo.repository.csv;

import com.ejemplo.model.Cliente;
import com.ejemplo.repository.IClienteRepository;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClienteCsvRepository extends CsvReaderAbstract implements IClienteRepository {

    private Path path;
    private String separatorRegex;
    private String separatorWrite;
    private final File file;

    public ClienteCsvRepository(String ruta, String separatorRegex, String separatorWrite) {
        this.path = Paths.get(ruta);
        this.separatorRegex = separatorRegex;
        this.separatorWrite = separatorWrite;
        this.file = new File(ruta);
    }

    @Override
    public boolean create(Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            String clienteStr = translator(cliente);
            writer.write(clienteStr);
            writer.newLine();
            System.out.println("Registro agregado.");
            return true;
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo.");
            return false;
        }
    }

    @Override
    public List<Cliente> findAll() {
        try {
            List<String[]> rows = read(path, separatorRegex, false);
            List<Cliente> clientes = new ArrayList<Cliente>();
            for (String[] row : rows) {
                long id = Long.parseLong(row[0]);
                String nif = row[1];
                String nombre = row[2];
                String email = row[3];
                String telefono = row[4];
                String ciudad = row[5];
                String pais = row[6];
                boolean miActivo = Boolean.parseBoolean(row[7]);
                Cliente cliente = new Cliente(id, nif, nombre, email, telefono, ciudad, pais, miActivo);
                clientes.add(cliente);
            }
            return clientes;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Cliente findById(Long id) {
        List<Cliente> clientes = findAll();
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public boolean update(Cliente cliente) {
        deleteById(cliente.getId());
        create(cliente);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {

        List<Cliente> clientes = findAll();
        boolean eliminado = clientes.removeIf(c -> c.getId().equals(id));

        if (!eliminado) {
            System.out.println("No se encontró el cliente con ID: " + id);
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {
            for (Cliente cliente : clientes) {
                writer.write(translator(cliente));
                writer.newLine();
            }
            System.out.println("Registro eliminado con éxito.");
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo durante el borrado.");
            return false;
        }
    }

    public String translator(Cliente cliente) {
        String resultado = "" + cliente.getId() + separatorRegex + cliente.getNif() + separatorRegex
                + cliente.getNombre() + separatorRegex + cliente.getEmail() + separatorRegex + cliente.getTelefono()
                + separatorRegex + cliente.getCiudad() + separatorRegex + cliente.getPais() + separatorRegex
                + cliente.isActivo();

        return resultado;
    }

}
