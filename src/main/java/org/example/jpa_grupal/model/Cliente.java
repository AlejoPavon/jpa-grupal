package org.example.jpa_grupal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente extends AuditoriaApp {

    @Column(nullable = false)
    private String cuitCuil;

    @Column(nullable = false)
    private String denominacion;

    @OneToOne
    @JoinColumn(nullable = false)
    private Contacto contacto;

    @OneToOne
    @JoinColumn(nullable = false)
    private Domicilio domicilio;

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public void setCuitCuil(String cuitCuil) {
        this.cuitCuil = cuitCuil;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
}