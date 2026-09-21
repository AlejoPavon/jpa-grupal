package org.example.jpa_grupal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.example.jpa_grupal.model.Articulo;
import org.example.jpa_grupal.model.Cliente;
import org.example.jpa_grupal.model.CondicionIva;
import org.example.jpa_grupal.model.Contacto;
import org.example.jpa_grupal.model.Domicilio;
import org.example.jpa_grupal.model.FacturaVenta;
import org.example.jpa_grupal.model.FacturaVentaDetalle;
import org.example.jpa_grupal.model.ListaPrecio;
import org.example.jpa_grupal.model.ListaPrecioArticulo;
import org.example.jpa_grupal.model.PuntoVenta;
import org.example.jpa_grupal.model.TipoMoneda;
import org.example.jpa_grupal.model.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("FacturacionPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Date ahora = new Date();

        Usuario usuario = new Usuario("admin", "1234", "Alejo", "Usuario");

        PuntoVenta puntoVenta = new PuntoVenta();
        TipoMoneda tipoMoneda = new TipoMoneda();
        CondicionIva condicionIva = new CondicionIva();
        Cliente cliente = new Cliente();
        Contacto contacto = new Contacto();
        Domicilio domicilio = new Domicilio();
        ListaPrecio listaPrecio = new ListaPrecio();
        Articulo articulo = new Articulo();
        ListaPrecioArticulo listaPrecioArticulo = new ListaPrecioArticulo();
        FacturaVenta facturaVenta = new FacturaVenta();
        FacturaVentaDetalle detalle = new FacturaVentaDetalle();

        // Datos de auditoría
        puntoVenta.setFechaAlta(ahora);
        puntoVenta.setFechaModificacion(ahora);
        puntoVenta.setUsuarioCarga(usuario);
        puntoVenta.setUsuarioModificacion(usuario);

        tipoMoneda.setFechaAlta(ahora);
        tipoMoneda.setFechaModificacion(ahora);
        tipoMoneda.setUsuarioCarga(usuario);
        tipoMoneda.setUsuarioModificacion(usuario);

        condicionIva.setFechaAlta(ahora);
        condicionIva.setFechaModificacion(ahora);
        condicionIva.setUsuarioCarga(usuario);
        condicionIva.setUsuarioModificacion(usuario);

        cliente.setFechaAlta(ahora);
        cliente.setFechaModificacion(ahora);
        cliente.setUsuarioCarga(usuario);
        cliente.setUsuarioModificacion(usuario);

        listaPrecio.setFechaAlta(ahora);
        listaPrecio.setFechaModificacion(ahora);
        listaPrecio.setUsuarioCarga(usuario);
        listaPrecio.setUsuarioModificacion(usuario);

        articulo.setFechaAlta(ahora);
        articulo.setFechaModificacion(ahora);
        articulo.setUsuarioCarga(usuario);
        articulo.setUsuarioModificacion(usuario);

        listaPrecioArticulo.setFechaAlta(ahora);
        listaPrecioArticulo.setFechaModificacion(ahora);
        listaPrecioArticulo.setUsuarioCarga(usuario);
        listaPrecioArticulo.setUsuarioModificacion(usuario);

        facturaVenta.setFechaAlta(ahora);
        facturaVenta.setFechaModificacion(ahora);
        facturaVenta.setUsuarioCarga(usuario);
        facturaVenta.setUsuarioModificacion(usuario);
        facturaVenta.setFechaEmision(ahora);
        facturaVenta.setEstado("EMITIDA");

        // Datos del cliente
        cliente.setCuitCuil("20-12345678-9");
        cliente.setDenominacion("Cliente de prueba");

        // Datos de ListaPrecio
        listaPrecio.setCodigo("LP001");
        listaPrecio.setDenominacion("Lista de precios general");

        // Datos de Articulo
        articulo.setCodigo("ART001");
        articulo.setDenominacion("Articulo de prueba");

        // Datos de TipoMoneda
        tipoMoneda.setCodigoAfip("PES");
        tipoMoneda.setDenominacion("Peso Argentino");
        tipoMoneda.setSimbolo("$");

        // Relaciones del Cliente
        cliente.setContacto(contacto);
        cliente.setDomicilio(domicilio);

        // Relaciones de ListaPrecioArticulo
        listaPrecioArticulo.setListaPrecio(listaPrecio);
        listaPrecioArticulo.setArticulo(articulo);

        // Relación del detalle con ListaPrecioArticulo
        detalle.setListaPrecioArticulo(listaPrecioArticulo);

        // Relación bidireccional FacturaVenta <-> FacturaVentaDetalle
        detalle.setFactura(facturaVenta);

        List<FacturaVentaDetalle> detalles = new ArrayList<>();
        detalles.add(detalle);

        facturaVenta.setDetalles(detalles);

        // Asociaciones de FacturaVenta
        facturaVenta.setCliente(cliente);
        facturaVenta.setCondicionIva(condicionIva);
        facturaVenta.setTipoMoneda(tipoMoneda);
        facturaVenta.setPuntoVenta(puntoVenta);

        // Persistimos las entidades necesarias antes de la factura
        em.persist(usuario);
        em.persist(contacto);
        em.persist(domicilio);
        em.persist(cliente);
        em.persist(listaPrecio);
        em.persist(articulo);
        em.persist(listaPrecioArticulo);
        em.persist(condicionIva);
        em.persist(tipoMoneda);
        em.persist(puntoVenta);

        // Persistimos la factura
        em.persist(facturaVenta);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}