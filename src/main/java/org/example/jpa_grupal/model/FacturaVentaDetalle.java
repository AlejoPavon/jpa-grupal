package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factura_venta_detalle")
public class FacturaVentaDetalle extends EntityId {

    @ManyToOne
    @JoinColumn(nullable = false)
    private FacturaVenta factura;

    @ManyToOne
    @JoinColumn(nullable = false)
    private ListaPrecioArticulo listaPrecioArticulo;

    private String descripcion;

    @Column(nullable = false)
    private double cantidad;

    @Column(nullable = false)
    private double precioUnitario;

    private double porcentajeBonificacion;

    private double importeNeto;

    private double importeIva;

    @Column(nullable = false)
    private double importeSubtotal;

    public void setFactura(FacturaVenta factura) {
        this.factura = factura;
    }

    public void setListaPrecioArticulo(ListaPrecioArticulo listaPrecioArticulo) {
        this.listaPrecioArticulo = listaPrecioArticulo;
    }
}