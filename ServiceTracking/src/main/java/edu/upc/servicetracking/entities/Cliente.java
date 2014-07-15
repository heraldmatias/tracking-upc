/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.servicetracking.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


/**
 *
 * @author holivares
 */
@Entity
@Table(name = "tb_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT m FROM Cliente m"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT m FROM Cliente m WHERE m.clienteid = :id"),
    @NamedQuery(name = "Cliente.findByName", query = "SELECT m FROM Cliente m WHERE m.razonsocial = :razonsocial")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer clienteid;

    @NotNull
    @Size(min = 1, max = 50)
    private String razonsocial;

    @NotNull
    @Size(min = 1, max = 45)
    private String latlong;

    public Cliente() {
    }

    public Cliente(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Cliente(Integer clienteid, String name, String latlong) {
        this.clienteid = clienteid;
        this.razonsocial = name;
        this.latlong = latlong;
    }

    public Integer getId() {
        return clienteid;
    }

    public void setId(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getLatlong() {
        return latlong;
    }

    public void setLatlong(String latlong) {
        this.latlong = latlong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteid != null ? clienteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteid == null && other.clienteid != null) || (this.clienteid != null && !this.clienteid.equals(other.clienteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.upc.servicetracking.entities.Cliente[ id=" + clienteid + " ]";
    }

}
