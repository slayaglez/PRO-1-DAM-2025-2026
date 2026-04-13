package com.ejemplo.model.xml;

import com.ejemplo.model.Inventario;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "inventarios")
public class Inventarios {

    @JacksonXmlProperty(localName = "inventario")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Inventario> items = new ArrayList<>();

    public Inventarios() {
    }

    public Inventarios(List<Inventario> items) {
        this.items = items;
    }

    public List<Inventario> getItems() {
        return items;
    }

    public void setItems(List<Inventario> items) {
        this.items = items;
    }
}
