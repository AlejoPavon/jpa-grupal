package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class Marca extends AuditoriaApp {

    @Column(nullable = false)
    private String denominacion;

    @Column(nullable = false)
    private Integer codigo;
}