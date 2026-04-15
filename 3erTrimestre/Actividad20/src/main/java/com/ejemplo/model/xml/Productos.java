package com.ejemplo.model.xml;

import com.ejemplo.model.Producto;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "productos")
public class Productos {

    @JacksonXmlProperty(localName = "producto")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Producto> items = new ArrayList<>();

    public Productos() {
    }

    public Productos(List<Producto> items) {
        this.items = items;
    }

    public List<Producto> getItems() {
        return items;
    }

    public void setItems(List<Producto> items) {
        this.items = items;
    }
}
