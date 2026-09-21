package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lista_precio_articulo")
public class ListaPrecioArticulo extends AuditoriaApp {

    @ManyToOne
    @JoinColumn(nullable = false)
    private ListaPrecio listaPrecio;

    @Column(nullable = false)
    private double precioVenta;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Articulo articulo;

    public void setListaPrecio(ListaPrecio listaPrecio) {
        this.listaPrecio = listaPrecio;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }
}