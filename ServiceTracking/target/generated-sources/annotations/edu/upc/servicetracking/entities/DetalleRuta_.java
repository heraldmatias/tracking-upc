package edu.upc.servicetracking.entities;

import edu.upc.servicetracking.entities.Cliente;
import edu.upc.servicetracking.entities.Ruta;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-29T16:17:03")
@StaticMetamodel(DetalleRuta.class)
public class DetalleRuta_ { 

    public static volatile SingularAttribute<DetalleRuta, String> observacion;
    public static volatile SingularAttribute<DetalleRuta, String> estado;
    public static volatile SingularAttribute<DetalleRuta, Cliente> clienteId;
    public static volatile SingularAttribute<DetalleRuta, Date> horallegada;
    public static volatile SingularAttribute<DetalleRuta, Integer> detallerutaid;
    public static volatile SingularAttribute<DetalleRuta, Ruta> rutaId;

}