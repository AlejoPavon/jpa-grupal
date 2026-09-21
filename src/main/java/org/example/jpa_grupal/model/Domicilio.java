package org.example.jpa_grupal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "domicilio")
public class Domicilio extends EntityId {

    private String nombreCalle;

    private String numeroCalle;
}