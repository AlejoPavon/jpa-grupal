package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class AuditoriaApp extends EntityId {

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaAlta;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaBaja;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date fechaModificacion;

    @ManyToOne
    @JoinColumn(nullable = false)
    protected Usuario usuarioCarga;

    @ManyToOne
    protected Usuario usuarioBaja;

    @ManyToOne
    @JoinColumn(nullable = false)
    protected Usuario usuarioModificacion;

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public void setUsuarioCarga(Usuario usuarioCarga) {
        this.usuarioCarga = usuarioCarga;
    }

    public void setUsuarioModificacion(Usuario usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}