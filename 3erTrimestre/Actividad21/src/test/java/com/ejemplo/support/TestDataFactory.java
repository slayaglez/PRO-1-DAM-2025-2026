package com.ejemplo.support;

import com.ejemplo.model.Propietario;
import com.ejemplo.model.Inmueble;

public class TestDataFactory {

    public static Propietario propietario1() {
        return new Propietario("11111111A", "Ana", "ana@demo.com", "600111111", "Madrid", true);
    }

    public static Propietario propietario2() {
        return new Propietario("22222222B", "Luis", "luis@demo.com", "600222222", "Sevilla", true);
    }

    public static Propietario propietario3Inactivo() {
        return new Propietario("33333333C", "Marta", "marta@demo.com", "600333333", "Madrid", false);
    }

    public static Inmueble inmueble1(String dni) {
        return new Inmueble(null, "REF-111", "Piso", "Calle Mayor 1", "Madrid", 2020, 95, 125000.0, false, dni);
    }

    public static Inmueble inmueble2(String dni) {
        return new Inmueble(null, "REF-222", "Casa", "Avenida del Sol 8", "Sevilla", 2019, 120, 98000.0, false, dni);
    }

    public static Inmueble inmueble3Vendido(String dni) {
        return new Inmueble(null, "REF-333", "Local", "Plaza Norte 3", "Valencia", 2018, 80, 87000.0, true, dni);
    }
}
