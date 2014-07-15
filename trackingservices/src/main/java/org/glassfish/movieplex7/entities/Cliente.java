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
@Table(name = "tb_cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT m FROM Cliente m"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT m FROM Cliente m WHERE m.clienteid = :id"),
    @NamedQuery(name = "Cliente.findByName", query = "SELECT m FROM Cliente m WHERE m.razonsocial = :razonsocial"),
    @NamedQuery(name = "Cliente.findByActors", query = "SELECT m FROM Cliente m WHERE m.latlong = :latlong")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    private Integer clienteid;
    
    @NotNull
    @Size(min = 1, max = 50)
    private String razonsocial;
    
    @NotNull
    @Size(min = 1, max = 45)
    private String latlong;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movieId")
    private Collection<Ruta> showTimingCollection;

    public Cliente() {
    }

    public Cliente(Integer id) {
        this.clienteid = id;
    }

    public Cliente(Integer id, String name, String latlong) {
        this.clienteid = id;
        this.razonsocial = name;
        this.latlong = latlong;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
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

    @XmlTransient
    public Collection<Ruta> getShowTimingCollection() {
        return showTimingCollection;
    }

    public void setShowTimingCollection(Collection<Ruta> showTimingCollection) {
        this.showTimingCollection = showTimingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteid != null ? clienteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
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
        return razonsocial;
    }
    
}
