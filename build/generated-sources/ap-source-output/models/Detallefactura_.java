package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Detalle;
import models.Factura;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-15T19:28:46")
@StaticMetamodel(Detallefactura.class)
public class Detallefactura_ { 

    public static volatile SingularAttribute<Detallefactura, Integer> id;
    public static volatile SingularAttribute<Detallefactura, Integer> iddetalle;
    public static volatile SingularAttribute<Detallefactura, Detalle> detalle;
    public static volatile SingularAttribute<Detallefactura, Factura> idfactura;

}