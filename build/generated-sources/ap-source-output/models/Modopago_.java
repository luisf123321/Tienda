package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Factura;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-15T19:28:46")
@StaticMetamodel(Modopago.class)
public class Modopago_ { 

    public static volatile SingularAttribute<Modopago, String> descripcion;
    public static volatile SingularAttribute<Modopago, Factura> factura;
    public static volatile SingularAttribute<Modopago, Integer> id;
    public static volatile SingularAttribute<Modopago, String> nombre;

}