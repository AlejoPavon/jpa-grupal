package org.example.jpa_grupal.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contacto")
public class Contacto extends EntityId {

    private String email;

    private String telefono;

    private String celular;
}