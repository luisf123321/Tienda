/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IDaoItem;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.Item;

/**
 *
 * @author luis
 */
public class ItemController implements IDaoItem {

    

    @Override
    public List<Item> getItem(HttpServletRequest request) {
            
        ArrayList<Item> cart = new ArrayList<Item>();
        HttpSession session = request.getSession(false);
	cart = (ArrayList<Item>) session.getAttribute("cart");

	if (cart == null) {
            cart = new ArrayList<Item>();
	}

	return cart;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cancel(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
	session.removeAttribute("cart");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String addItem(HttpServletRequest request, int id, int cantidad) {
        HttpSession session = request.getSession(false);
	ArrayList cart = (ArrayList) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList();
	}
        
        
        
        for(int i=0;i<cart.size();i++){
            Item itemcar = (Item) cart.get(i);
            long idcar = itemcar.getIdproducto();
            long cantidadcar = itemcar.getCantidad();
            if (idcar == id) {
		long items = cart.size();
		String result = ""+items ;
		return result;
            }
            
        }
        
        Item item = new Item();
        item.setIdproducto(id);
	item.setCantidad(cantidad);
        
        cart.add(item);
        System.out.println(cart.size());
	System.out.println(cart);	
	session.setAttribute("cart", cart);
        String items = "" + cart.size();
        return items;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
