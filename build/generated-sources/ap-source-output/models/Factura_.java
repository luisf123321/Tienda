package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Cliente;
import models.Detallefactura;
import models.Empleado;
import models.Modopago;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-15T19:28:46")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, Date> fecha;
    public static volatile SingularAttribute<Factura, Double> total;
    public static volatile SingularAttribute<Factura, Integer> idpago;
    public static volatile ListAttribute<Factura, Detallefactura> detallefacturaList;
    public static volatile SingularAttribute<Factura, Integer> id;
    public static volatile SingularAttribute<Factura, Cliente> idcliente;
    public static volatile SingularAttribute<Factura, Empleado> idempleado;
    public static volatile SingularAttribute<Factura, Modopago> modopago;

}