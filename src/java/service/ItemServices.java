/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import controller.ItemController;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import models.Item;

/**
 *
 * @author luis
 */

@Path("item")
public class ItemServices {
    
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Item>  getItem(@Context HttpServletRequest request){
        ItemController itemcontroller = new ItemController();
        return itemcontroller.getItem(request);
    }
    
    @GET
    @Path("add/{id}/{cantidad}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response add(@Context HttpServletRequest request,@PathParam("id") int id, @PathParam("cantidad") int cantidad){
        ItemController itemcontroller = new ItemController();
        String result = "{\"items\":" + itemcontroller.addItem(request, id, cantidad) + "}";
        return Response.status(201).entity(result).build();
    }
    
    @GET
    @Path("cancelar")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response cancelar(@Context HttpServletRequest request){
        ItemController itemcontroller = new ItemController();
        itemcontroller.cancel(request); 
   
        return Response.status(201).entity("ok").build();
    }
    
    
}
