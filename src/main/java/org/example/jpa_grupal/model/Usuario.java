package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario extends EntityId {

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    public Usuario(String usuario, String clave, String nombre, String apellido) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
    }
}
