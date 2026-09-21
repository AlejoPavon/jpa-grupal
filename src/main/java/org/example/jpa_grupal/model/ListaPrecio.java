package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "lista_precio")
public class ListaPrecio extends AuditoriaApp {

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String denominacion;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}