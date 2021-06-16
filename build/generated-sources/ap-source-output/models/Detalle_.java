package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Detallefactura;
import models.Producto;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-15T19:28:46")
@StaticMetamodel(Detalle.class)
public class Detalle_ { 

    public static volatile SingularAttribute<Detalle, Detallefactura> detallefactura;
    public static volatile SingularAttribute<Detalle, Double> valor;
    public static volatile SingularAttribute<Detalle, Integer> id;
    public static volatile SingularAttribute<Detalle, Integer> cantidad;
    public static volatile SingularAttribute<Detalle, Producto> idproducto;

}