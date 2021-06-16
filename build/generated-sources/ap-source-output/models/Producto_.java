package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Categoria;
import models.Detalle;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-06-15T19:28:46")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, String> codigo;
    public static volatile SingularAttribute<Producto, String> ref;
    public static volatile SingularAttribute<Producto, Double> precio;
    public static volatile ListAttribute<Producto, Detalle> detalleList;
    public static volatile SingularAttribute<Producto, Categoria> idcategoria;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, String> nombre;

}