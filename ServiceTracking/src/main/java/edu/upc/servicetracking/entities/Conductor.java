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
@Table(name = "tb_conductor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT m FROM Conductor m"),
    @NamedQuery(name = "Conductor.findByDni", query = "SELECT m FROM Conductor m WHERE m.dni=:dni")})
public class Conductor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer conductorid;

    @Size(min = 1, max = 100)
    private String nombres;

    @Size(min = 1, max = 100)
    private String apellidos;

    @Size(min = 1, max = 45)
    private String celular;

    @NotNull
    @Size(min = 1, max = 8)
    private String dni;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conductorId")
    private Collection<Ruta> rutas;

    public Integer getId() {
        return conductorid;
    }

    public void setId(Integer conductorid) {
        this.conductorid = conductorid;
    }

    public Integer getConductorid() {
        return conductorid;
    }

    public void setConductorid(Integer conductorid) {
        this.conductorid = conductorid;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @XmlTransient
    public Collection<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(Collection<Ruta> rutas) {
        this.rutas = rutas;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conductorid != null ? conductorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.conductorid == null && other.conductorid != null) || (this.conductorid != null && !this.conductorid.equals(other.conductorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upc.servicetracking.entities.Conductor[ id=" + conductorid + " ]";
    }

}
