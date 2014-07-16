/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.servicetracking.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author holivares
 */
@Entity
@Table(name = "tb_detalleruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleRuta.findAll", query = "SELECT m FROM DetalleRuta m"),
    @NamedQuery(name = "DetalleRuta.findByRuta", query = "SELECT s FROM DetalleRuta s WHERE s.rutaId.rutaid = :rutaId")})
public class DetalleRuta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer detallerutaid;

    @JoinColumn(name = "rutaid", referencedColumnName = "rutaid")
    @ManyToOne(optional = false)
    private Ruta rutaId;

    @JoinColumn(name = "clienteid", referencedColumnName = "clienteid")
    @ManyToOne(optional = false)
    private Cliente clienteId;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date horallegada;

    @Size(min = 1, max = 1)
    private String estado;

    @Size(min=1, max=200)
    private String observacion;

    public Integer getId() {
        return detallerutaid;
    }

    public void setId(Integer id) {
        this.detallerutaid = id;
    }

    public Integer getDetallerutaid() {
        return detallerutaid;
    }

    public void setDetallerutaid(Integer detallerutaid) {
        this.detallerutaid = detallerutaid;
    }

    public Ruta getRutaId() {
        return rutaId;
    }

    public void setRutaId(Ruta rutaId) {
        this.rutaId = rutaId;
    }

    public Cliente getClienteId() {
        return clienteId;
    }

    public void setClienteId(Cliente clienteId) {
        this.clienteId = clienteId;
    }

    public Date getHorallegada() {
        return horallegada;
    }

    public void setHorallegada(Date horallegada) {
        this.horallegada = horallegada;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detallerutaid != null ? detallerutaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleRuta)) {
            return false;
        }
        DetalleRuta other = (DetalleRuta) object;
        if ((this.detallerutaid == null && other.detallerutaid != null) || (this.detallerutaid != null && !this.detallerutaid.equals(other.detallerutaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upc.servicetracking.entities.DetalleRuta[ id=" + detallerutaid + " ]";
    }

}
