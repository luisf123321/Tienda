/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.util.List;
import models.Factura;

/**
 *
 * @author luis
 */
public interface IDaoFactura {
    
    public List<Factura> getFacturas();
    public Factura createFactura(Factura factura) throws RollbackFailureException, Exception;
    public Factura getFactura(int id);
    public String deleteFactura(int id) throws NonexistentEntityException, RollbackFailureException, Exception;
    public Factura updateFactura(Factura factura) throws NonexistentEntityException, RollbackFailureException, Exception;
 
    
}
