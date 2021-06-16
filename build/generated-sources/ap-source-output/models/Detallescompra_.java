package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Detallefactura;
import models.Producto;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-16T00:30:40")
@StaticMetamodel(Detallescompra.class)
public class Detallescompra_ { 

    public static volatile SingularAttribute<Detallescompra, Detallefactura> detallefactura;
    public static volatile SingularAttribute<Detallescompra, Double> valor;
    public static volatile SingularAttribute<Detallescompra, Integer> id;
    public static volatile SingularAttribute<Detallescompra, Integer> cantidad;
    public static volatile SingularAttribute<Detallescompra, Producto> idproducto;

}