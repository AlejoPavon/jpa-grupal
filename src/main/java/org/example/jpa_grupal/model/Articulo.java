package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articulo")
public class Articulo extends AuditoriaApp {

    @ManyToOne
    private Rubro rubro;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String denominacion;

    @ManyToOne
    private Marca marca;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}