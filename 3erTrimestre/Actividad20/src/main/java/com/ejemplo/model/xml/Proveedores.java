package com.ejemplo.model.xml;

import com.ejemplo.model.Proveedor;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "proveedores")
public class Proveedores {

    @JacksonXmlProperty(localName = "proveedor")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Proveedor> items = new ArrayList<>();

    public Proveedores() {
    }

    public Proveedores(List<Proveedor> items) {
        this.items = items;
    }

    public List<Proveedor> getItems() {
        return items;
    }

    public void setItems(List<Proveedor> items) {
        this.items = items;
    }
}
