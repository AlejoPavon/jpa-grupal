package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "punto_venta")
public class PuntoVenta extends AuditoriaApp {

    @Column(nullable = false)
    private int numero;

    private String descripcion;

    private String tipoEmision;

    private String domicilioComercial;
}