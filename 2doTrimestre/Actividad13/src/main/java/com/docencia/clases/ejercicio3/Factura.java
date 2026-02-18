/**
 * @author slayaglez
 * @version 1.0.0
 * @brief Programa que valida facturas de empresas y relacionados
 */
package com.docencia.clases.ejercicio3;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Factura {

    private final String numeroFactura;
    private final String iban;
    private final String nifEmpresa;
    private final LocalDate fechaEmision;
    private final LocalDate fechaVencimiento;

    public Factura(String numeroFactura, String iban, String nifEmpresa, LocalDate fechaEmision,
            LocalDate fechaVencimiento) {
        this.numeroFactura = numeroFactura;
        this.iban = iban;
        this.nifEmpresa = nifEmpresa;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }

    public void validate() {
        
        String patronIban = "^ES66[0-9]{20}$";
        if(!Pattern.matches(patronIban, this.iban)){
            throw new IllegalArgumentException("Iban incorrecto");
        }

        String patronFactura = "^FAC-[0-9]{4}-[0-9]{6}$";
        if(!Pattern.matches(patronFactura, this.numeroFactura)){
            throw new IllegalArgumentException("Factura incorrecta");
        }

        String patronNif = "^[A-Z][0-9]{7}[A-Z]$";
        if(!Pattern.matches(patronNif, this.nifEmpresa)){
            throw new IllegalArgumentException("NIF incorrecto");
        }

        if(fechaEmision.isAfter(fechaVencimiento)){
            throw new IllegalArgumentException("fechas sin sentido");
        }
    }

    public boolean isVencida(LocalDate hoy) {
        return fechaVencimiento.isBefore(hoy);
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public String getIban() {
        return iban;
    }

    public String getNifEmpresa() {
        return nifEmpresa;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
}
