package edu.upc.servicetracking.entities;

import edu.upc.servicetracking.entities.Ruta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-29T16:17:03")
@StaticMetamodel(Conductor.class)
public class Conductor_ { 

    public static volatile SingularAttribute<Conductor, String> nombres;
    public static volatile CollectionAttribute<Conductor, Ruta> rutas;
    public static volatile SingularAttribute<Conductor, String> apellidos;
    public static volatile SingularAttribute<Conductor, String> dni;
    public static volatile SingularAttribute<Conductor, Integer> conductorid;
    public static volatile SingularAttribute<Conductor, String> celular;

}