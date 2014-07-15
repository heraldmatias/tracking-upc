/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.glassfish.movieplex7.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
 * @author Herald Olivares
 */
@Entity
@Table(name = "tb_ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT m FROM Ruta m"),
    @NamedQuery(name = "Ruta.findById", query = "SELECT m FROM Ruta m WHERE m.clienteid = :id"),
    @NamedQuery(name = "Ruta.findByName", query = "SELECT m FROM Ruta m WHERE m.razonsocial = :razonsocial"),
    @NamedQuery(name = "Ruta.findByActors", query = "SELECT m FROM Ruta m WHERE m.latlong = :latlong")})
public class Ruta implements Serializable {
    private static final long serialVersionUID = 1L;
//    `rutaid` bigint(20) NOT NULL AUTO_INCREMENT,
//  `conductorid` bigint(20) NOT NULL,
//  `fecharuta` date DEFAULT NULL,
//  `estado`
    @Id
    @NotNull
    private Integer rutaid;
        
    @NotNull
    private Integer conductorid;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String fecharuta;
    
    @NotNull
    @Size(min = 1, max = 45)
    private Character estado;
       

    public Ruta() {
    }

    public Ruta(Integer rutaid) {
        this.rutaid = rutaid;
    }

    public Ruta(Integer rutaid, Integer conductorid, String fecharuta, Character estado) {
        this.rutaid = rutaid;
        this.conductorid = conductorid;
        this.fecharuta = fecharuta;
        this.estado = estado;
    }

    public Integer getRutaid() {
        return rutaid;
    }

    public void setRutaid(Integer rutaid) {
        this.rutaid = rutaid;
    }

    public Integer getConductorid() {
        return conductorid;
    }

    public void setConductorid(Integer conductorid) {
        this.conductorid = conductorid;
    }

    public String getFecharuta() {
        return fecharuta;
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
