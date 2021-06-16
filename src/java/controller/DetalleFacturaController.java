/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import dao.IDaoDetalleFactura;
import java.util.List;
import models.Detallefactura;

/**
 *
 * @author luis
 */
public class DetalleFacturaController implements IDaoDetalleFactura {

    @Override
    public List<Detallefactura> getDetalleFacturas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detallefactura createDetalleFactura(Detallefactura Detallefactura) throws RollbackFailureException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detallefactura getDetalleFactura(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteDetalleFactura(int id) throws NonexistentEntityException, RollbackFailureException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Detallefactura updateDetalleFactura() throws NonexistentEntityException, RollbackFailureException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
