/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controller.exceptions.RollbackFailureException;
import models.Modopago;

/**
 *
 * @author luis
 */
public interface IDaoPago {
    
    public Modopago createPago(Modopago pago)throws RollbackFailureException, Exception;
    public Modopago getPago(int id);
    
}
