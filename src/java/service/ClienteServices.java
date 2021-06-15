/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.ClienteController;
import controller.ProductoController;
import controller.exceptions.RollbackFailureException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
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
import models.Cliente;
import models.Producto;

/**
 *
 * @author luis
 */



@Path("clientes")
public class ClienteServices {
    
    @Resource
    private UserTransaction utx;
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cliente> getClientes() throws NamingException {
        ClienteController cl = new ClienteController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.getClientes();
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente getCliente(@PathParam("id") int id) throws NamingException{
        
        ClienteController cl = new ClienteController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.getCliente(id);
    }
    
    
    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String createCliente(Cliente cliente) throws Exception{
        ClienteController cl = new ClienteController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.createCliente(cliente);
    }
    
    @DELETE
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String deleteCliente(@PathParam("id") int id) throws RollbackFailureException, Exception{
        ClienteController cl = new ClienteController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.deleteCliente(id);
    }
    
    @PUT
    @Path("/update")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Cliente updateCliente(Cliente cliente) throws RollbackFailureException, Exception{
        ClienteController cl = new ClienteController(Persistence.createEntityManagerFactory("TiendaPU"));
        return cl.updateCliente(cliente);        
    }
    
    
}
