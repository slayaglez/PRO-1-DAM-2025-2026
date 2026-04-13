package com.ejemplo.repository.xml;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.xml.Clientes;
import com.ejemplo.repository.IClienteRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClienteXmlRepository implements IClienteRepository {

    private Path path;
    private XmlMapper xmlMapper;

    public ClienteXmlRepository(String path) {
        this.path = inicializarPath(path);
        this.xmlMapper = new XmlMapper();
    }

    public boolean create(Cliente cliente) {
        if (cliente == null || cliente.getId() == null || findById(cliente.getId()) != null) {
            return false;
        }
        List<Cliente> clientes = findAll();
        clientes.add(cliente);
        writeAll(clientes);
        return true;
    }

    public List<Cliente> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            Clientes wrapper = xmlMapper.readValue(path.toFile(), Clientes.class);
            List<Cliente> clientes = wrapper.getItems();
            return clientes == null ? new ArrayList<>() : clientes;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el fichero XML de clientes", e);
        }
    }

    public Cliente findById(Long id) {
        List<Cliente> clientes = findAll();
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean update(Cliente clienteActualizado) {
        List<Cliente> clientes = findAll();
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(clienteActualizado.getId())) {
                clientes.set(i, clienteActualizado);
                writeAll(clientes);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        List<Cliente> clientes = findAll();
        boolean eliminado = clientes.removeIf(cliente -> cliente.getId().equals(id));
        if (eliminado) {
            writeAll(clientes);
        }
        return eliminado;
    }

    private void writeAll(List<Cliente> clientes) {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            Clientes wrapper = new Clientes();
            wrapper.setItems(clientes);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), wrapper);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo escribir el fichero XML de clientes", e);
        }
    }

    private Path inicializarPath(String ruta) {
        try {
            Path path = Path.of(ruta);
            crearCarpetasSiNoExisten(path);
            comprobarQueNoEsDirectorio(path, ruta);
            crearFicheroSiNoExiste(path);
            return path;
        } catch (IOException e) {
            throw new RuntimeException("No se pudo preparar el fichero XML: " + ruta, e);
        }
    }

    private void crearCarpetasSiNoExisten(Path path) throws IOException {
        if (path.getParent() != null && !Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
    }

    private void comprobarQueNoEsDirectorio(Path path, String ruta) {
        if (Files.exists(path) && Files.isDirectory(path)) {
            throw new RuntimeException("La ruta indicada es un directorio: " + ruta);
        }
    }

    private void crearFicheroSiNoExiste(Path path) throws IOException {
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }
}
