/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.util.List;
import models.Detalle;

/**
 *
 * @author luis
 */
public interface IDaoDetalle {
    
    public List<Detalle> getDetalles();
    public Detalle createDetalle(Detalle Detalle) throws RollbackFailureException, Exception;
    public Detalle getDetalle(int id);
    public String deleteDetalle(int id) throws NonexistentEntityException, RollbackFailureException, Exception;
    public Detalle updateDetalle() throws NonexistentEntityException, RollbackFailureException, Exception;
 
    
}
