package com.ejemplo.repository.xml;

import com.ejemplo.model.LineaPedido;
import com.ejemplo.model.xml.LineasPedido;
import com.ejemplo.repository.ILineaPedidoRepository;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class LineaPedidoXmlRepository implements ILineaPedidoRepository {

    private Path path;
    private XmlMapper xmlMapper;

    public LineaPedidoXmlRepository(String path) {
        this.path = inicializarPath(path);
        this.xmlMapper = new XmlMapper();
    }

    public boolean create(LineaPedido lineaPedido) {
        if (lineaPedido == null || lineaPedido.getId() == null || findById(lineaPedido.getId()) != null) {
            return false;
        }
        List<LineaPedido> lineas = findAll();
        lineas.add(lineaPedido);
        writeAll(lineas);
        return true;
    }

    public List<LineaPedido> findAll() {
        try {
            if (!Files.exists(path) || Files.size(path) == 0L) {
                return new ArrayList<>();
            }
            LineasPedido wrapper = xmlMapper.readValue(path.toFile(), LineasPedido.class);
            List<LineaPedido> lineas = wrapper.getItems();
            return lineas == null ? new ArrayList<>() : lineas;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo leer el fichero XML de lineas de pedido", e);
        }
    }

    public LineaPedido findById(Long id) {
        List<LineaPedido> lineas = findAll();
        for (LineaPedido linea : lineas) {
            if (linea.getId().equals(id)) {
                return linea;
            }
        }
        return null;
    }

    public boolean update(LineaPedido lineaActualizada) {
        List<LineaPedido> lineas = findAll();
        for (int i = 0; i < lineas.size(); i++) {
            if (lineas.get(i).getId().equals(lineaActualizada.getId())) {
                lineas.set(i, lineaActualizada);
                writeAll(lineas);
                return true;
            }
        }
        return false;
    }

    public boolean deleteById(Long id) {
        List<LineaPedido> lineas = findAll();
        boolean eliminado = lineas.removeIf(linea -> linea.getId().equals(id));
        if (eliminado) {
            writeAll(lineas);
        }
        return eliminado;
    }

    private void writeAll(List<LineaPedido> lineas) {
        try {
            if (path.getParent() != null) {
                Files.createDirectories(path.getParent());
            }
            LineasPedido wrapper = new LineasPedido();
            wrapper.setItems(lineas);
            xmlMapper.writerWithDefaultPrettyPrinter().writeValue(path.toFile(), wrapper);
        } catch (Exception e) {
            throw new RuntimeException("No se pudo escribir el fichero XML de lineas de pedido", e);
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
