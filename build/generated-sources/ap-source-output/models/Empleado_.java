package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Factura;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-16T15:42:29")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, Long> numdocumento;
    public static volatile SingularAttribute<Empleado, String> apellido;
    public static volatile ListAttribute<Empleado, Factura> facturaList;
    public static volatile SingularAttribute<Empleado, String> usuario;
    public static volatile SingularAttribute<Empleado, Integer> id;
    public static volatile SingularAttribute<Empleado, String> nombre;

}