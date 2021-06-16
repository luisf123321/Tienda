/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import controller.DetalleController;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.Detallescompra;


/**
 *
 * @author luis
 */

@Path("detalle")
public class DetalleServices {
    
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Detallescompra> findAll() throws NamingException {
        DetalleController pp = new DetalleController(Persistence.createEntityManagerFactory("TiendaPU"));
        return pp.getDetalles();
    }
    

    
    
    
}
