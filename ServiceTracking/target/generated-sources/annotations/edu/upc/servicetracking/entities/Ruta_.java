package edu.upc.servicetracking.entities;

import edu.upc.servicetracking.entities.Conductor;
import edu.upc.servicetracking.entities.DetalleRuta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-15T19:51:06")
@StaticMetamodel(Ruta.class)
public class Ruta_ { 

    public static volatile SingularAttribute<Ruta, Character> estado;
    public static volatile SingularAttribute<Ruta, Conductor> conductorId;
    public static volatile SingularAttribute<Ruta, String> fecharuta;
    public static volatile SingularAttribute<Ruta, Integer> rutaid;
    public static volatile CollectionAttribute<Ruta, DetalleRuta> detalles;

}