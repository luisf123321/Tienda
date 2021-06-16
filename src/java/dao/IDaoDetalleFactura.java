/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.util.List;
import models.Detallefactura;

/**
 *
 * @author luis
 */
public interface IDaoDetalleFactura {
    
    public List<Detallefactura> getDetalleFacturas();
    public Detallefactura createDetalleFactura(Detallefactura Detallefactura) throws RollbackFailureException, Exception;
    public Detallefactura getDetalleFactura(int id);
    public String deleteDetalleFactura(int id) throws NonexistentEntityException, RollbackFailureException, Exception;
    public Detallefactura updateDetalleFactura() throws NonexistentEntityException, RollbackFailureException, Exception;
 
    
    
}
