/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.CategoriaController;
import controller.ClienteController;
import controller.exceptions.RollbackFailureException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.NamingException;
import javax.persistence.Persistence;
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
import models.Categoria;
import models.Cliente;

/**
 *
 * @author luis
 */

@Path("categoria")
public class CategoriaServices {
    
     
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categoria> getCategoria() throws NamingException {
        CategoriaController cl = new CategoriaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.getcategorias();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categoria getCategoria(@PathParam("id") int id) throws NamingException{
        
        CategoriaController cl = new CategoriaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.getCategoria(id);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String createCategoria(Categoria categoria) throws Exception{
        
        
        CategoriaController cl = new CategoriaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.createCategoria(categoria);
        
        
    }
    
    
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String deleteCategoria(@PathParam("id") int id) throws RollbackFailureException, Exception{
        CategoriaController cl = new CategoriaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.deleteCategoria(id);
        
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categoria updateCategoria(Categoria categoria) throws RollbackFailureException, Exception{
        CategoriaController cl = new CategoriaController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.updateCategoria(categoria);
    }
    
}
