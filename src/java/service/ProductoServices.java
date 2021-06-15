/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.ProductoController;

import controller.exceptions.RollbackFailureException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Producto;

/**
 *
 * @author luis
 */


@Path("productos")
public class ProductoServices {
    
    @Resource
    private UserTransaction utx;
    
    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;
        
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> findAll() throws NamingException {
        ProductoController pp = new ProductoController(utx,Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.getProductos();
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String createProducto(Producto producto) throws Exception{
        ProductoController pp = new ProductoController(utx,Persistence.createEntityManagerFactory("TiendaPU"));
        return  pp.createProducto(producto);
    }
    
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String deleteProducto(@PathParam("id") Integer id) throws Exception{
        System.out.println(id);
        ProductoController pp = new ProductoController(utx,Persistence.createEntityManagerFactory("TiendaPU"));
        return  pp.deleteProducto(id);
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Producto getProducto(@PathParam("id") Integer id) throws NamingException{
        ProductoController pp = new ProductoController(utx,Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.getProducto(id);        
    }
    
    @GET
    @Path("list")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Producto> getProductos() throws NamingException {
        ProductoController pp = new ProductoController(utx,Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.getProductos() ;
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String getCountProducto() throws NamingException{
        ProductoController pp = new ProductoController(utx,Persistence.createEntityManagerFactory("TiendaPU"));
        
        return pp.getProductoCount();        
    }
    
    
    @PUT
    @Path("update")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Producto updateproducto(Producto producto) throws RollbackFailureException, Exception{
        
        ProductoController pp = new ProductoController(utx,Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.updateProducto(producto);       
        
    }
    
    
    
    
    
    
    
}
