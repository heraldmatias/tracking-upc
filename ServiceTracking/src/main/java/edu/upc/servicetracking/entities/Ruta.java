/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.servicetracking.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author holivares
 */
@Entity
@Table(name = "tb_ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT m FROM Ruta m")})
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer rutaid;

    @JoinColumn(name = "conductorid", referencedColumnName = "conductorid")
    @ManyToOne(optional = false)
    private Conductor conductorId;

    @NotNull
    @Size(min = 1, max = 50)
    private String fecharuta;

    @NotNull
    @Size(min = 1, max = 45)
    private Character estado;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rutaId")
    private Collection<DetalleRuta> detalles;

    public Ruta() {
    }

    public Ruta(Integer rutaid) {
        this.rutaid = rutaid;
    }

    public Integer getRutaid() {
        return rutaid;
    }

    public void setRutaid(Integer rutaid) {
        this.rutaid = rutaid;
    }

    public String getFecharuta() {
        return fecharuta;
    }

    public Conductor getConductorId() {
        return conductorId;
    }

    public void setConductorId(Conductor conductorId) {
        this.conductorId = conductorId;
    }

    public void setFecharuta(String fecharuta) {
        this.fecharuta = fecharuta;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<DetalleRuta> getDetalles() {
        return detalles;
    }

    public void setDetalles(Collection<DetalleRuta> detalles) {
        this.detalles = detalles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rutaid != null ? rutaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.rutaid == null && other.rutaid != null) || (this.rutaid != null && !this.rutaid.equals(other.rutaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return rutaid.toString();
    }

}
