package edu.upc.servicetracking.entities;

import edu.upc.servicetracking.entities.DetalleRuta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-15T19:51:06")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> razonsocial;
    public static volatile SingularAttribute<Cliente, String> latlong;
    public static volatile CollectionAttribute<Cliente, DetalleRuta> detalles;
    public static volatile SingularAttribute<Cliente, Integer> clienteid;

}