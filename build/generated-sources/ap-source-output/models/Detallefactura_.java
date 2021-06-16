package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Detallescompra;
import models.Factura;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-16T10:11:47")
@StaticMetamodel(Detallefactura.class)
public class Detallefactura_ { 

    public static volatile SingularAttribute<Detallefactura, Detallescompra> detallescompra;
    public static volatile SingularAttribute<Detallefactura, Integer> id;
    public static volatile SingularAttribute<Detallefactura, Integer> iddetalle;
    public static volatile SingularAttribute<Detallefactura, Factura> idfactura;

}