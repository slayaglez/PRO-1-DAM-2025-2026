package com.ejemplo.repository.xml;

import com.ejemplo.model.Pedido;
import com.ejemplo.model.xml.Pedidos;
import com.ejemplo.repository.IPedidoRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PedidoXmlRepository implements IPedidoRepository {

    private Path path;
    private XmlMapper xmlMapper;

    public PedidoXmlRepository(String path) {
        this.path = inicializarPath(path);
        this.xmlMapper = new XmlMapper();
    }

    public boolean create(Pedido pedido) {
        if (pedido == null || pedido.getId() == null || findById(pedido.getId()) != null) {
            return false;
        }
        List<Pedido> pedidos = findAll();
        pedidos.add(pedido);
        writeAll(pedidos);
        return true;
    }

    public List<Pedido> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            Pedidos wrapper = xmlMapper.readValue(path.toFile(), Pedidos.class);
            List<Pedido> pedidos = wrapper.getItems();
            return pedidos == null ? new ArrayList<>() : pedidos;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el fichero XML de pedidos", e);
        }
    }

    public Pedido findById(Long id) {
        List<Pedido> pedidos = findAll();
        for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                return pedido;
            }
        }
        return null;
    }

    public boolean update(Pedido pedidoActualizado) {
        List<Pedido> pedidos = findAll();
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId().equals(pedidoActualizado.getId())) {
                pedidos.set(i, pedidoActualizado);
                writeAll(pedidos);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        List<Pedido> pedidos = findAll();
        boolean eliminado = pedidos.removeIf(pedido -> pedido.getId().equals(id));
        if (eliminado) {
            writeAll(pedidos);
        }
        return eliminado;
    }

    private void writeAll(List<Pedido> pedidos) {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            Pedidos wrapper = new Pedidos();
            wrapper.setItems(pedidos);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), wrapper);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo escribir el fichero XML de pedidos", e);
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
