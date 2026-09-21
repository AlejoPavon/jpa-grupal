package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "condicion_iva")
public class CondicionIva extends AuditoriaApp {

    @Column(nullable = false)
    private int codigoAfip;

    private String denominacion;
}