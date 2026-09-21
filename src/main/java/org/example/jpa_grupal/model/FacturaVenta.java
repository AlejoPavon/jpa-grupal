package org.example.jpa_grupal.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura_venta")
public class FacturaVenta extends AuditoriaApp {

    private Long numero;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;

    @ManyToOne
    @JoinColumn(nullable = true)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private CondicionIva condicionIva;

    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoMoneda tipoMoneda;

    @ManyToOne
    @JoinColumn(nullable = false)
    private PuntoVenta puntoVenta;

    private double importeCobrado;

    private double importeSaldo;

    @Column(nullable = false)
    private double importeTotal;

    private String cae;

    @Temporal(TemporalType.TIMESTAMP)
    private Date caeFechaVencimiento;

    private String resultadoAfip;

    private String motivoRechazo;

    @Column(nullable = false)
    private String estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAnulacion;

    private String observaciones;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<FacturaVentaDetalle> detalles;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setCondicionIva(CondicionIva condicionIva) {
        this.condicionIva = condicionIva;
    }

    public void setTipoMoneda(TipoMoneda tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public void setPuntoVenta(PuntoVenta puntoVenta) {
        this.puntoVenta = puntoVenta;
    }

    public void setDetalles(List<FacturaVentaDetalle> detalles) {
        this.detalles = detalles;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}