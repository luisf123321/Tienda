/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import controller.FacturaController;
import controller.ProductoController;
import controller.exceptions.RollbackFailureException;
import java.util.Date;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Factura;
import models.Producto;

/**
 *
 * @author luis
 */
@Path("factura")
public class FacturaServices {
    
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Factura> findAll() throws NamingException {
        FacturaController pp = new FacturaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.getFacturas();
    }
    
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Factura create(Factura factura) throws NamingException, Exception {
        factura.setFecha(new Date());
        
        FacturaController pp = new FacturaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.createFactura(factura);
    }
    
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Factura getFactura(@PathParam("id") int id) throws NamingException{
        FacturaController pp = new FacturaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.getFactura(id);        
    }
    
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String deleteFactura(@PathParam("id") int id) throws RollbackFailureException, Exception{
        FacturaController pp = new FacturaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.deleteFactura(id);
        
    }
    
    @PUT
    @Path("update")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Factura updateFactura(Factura factura) throws NamingException, RollbackFailureException, Exception{
        FacturaController pp = new FacturaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.updateFactura(factura);
    }
    
    
    @POST
    @Path("confirmarCompraEmp")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response confirmarCompraEmpleado(@Context HttpServletRequest request) throws NamingException, Exception{
        FacturaController pp = new FacturaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return Response.status(201).entity(pp.confirmarCompraEmpleado(request, 1)).build();
    }
    
    
}
