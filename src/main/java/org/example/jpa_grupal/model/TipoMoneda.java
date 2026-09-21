package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_moneda")
public class TipoMoneda extends AuditoriaApp {

    @Column(nullable = false)
    private String codigoAfip;

    @Column(nullable = false)
    private String denominacion;

    @Column(nullable = false)
    private String simbolo;

    public void setCodigoAfip(String codigoAfip) {
        this.codigoAfip = codigoAfip;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}