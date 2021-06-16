/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import models.Item;

/**
 *
 * @author luis
 */
public interface IDaoItem {
    
    public String addItem(HttpServletRequest request, int id,int cantidad);
    public List<Item> getItem(HttpServletRequest request);
    public void cancel(HttpServletRequest request); 
    
}
