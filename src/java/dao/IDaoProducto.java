/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.util.List;
import javax.ejb.Local;
import models.Producto;

/**
 *
 * @author luis
 */


public interface IDaoProducto {
    
    public List<Producto> getProductos();
    public Producto createProducto(Producto producto) throws RollbackFailureException, Exception;
    public Producto getProducto(Integer id);
    public String deleteProducto(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception;
    public Producto updateProducto(Producto producto) throws NonexistentEntityException, RollbackFailureException, Exception;
    
}
